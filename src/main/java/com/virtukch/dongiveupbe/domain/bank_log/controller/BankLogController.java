package com.virtukch.dongiveupbe.domain.bank_log.controller;

import com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogRequestDto;
import com.virtukch.dongiveupbe.domain.bank_log.dto.BankLogResponseDto;
import com.virtukch.dongiveupbe.domain.bank_log.service.BankLogService;
import com.virtukch.dongiveupbe.domain.game_member.service.GameMemberService;
import com.virtukch.dongiveupbe.security.common.utils.TokenUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banklogs")
@Tag(name = "저축 이용 내역 API", description = "저축 이용 내역과 관련된 API를 제공합니다.")
public class BankLogController {
    private final BankLogService bankLogService;
    private final GameMemberService gameMemberService;

    public BankLogController(BankLogService bankLogService, GameMemberService gameMemberService) {
        this.bankLogService = bankLogService;
        this.gameMemberService = gameMemberService;
    }

    @GetMapping
    @Operation(
            summary = "전체 저축 이용 내역 조회",
            description = "모든 저축 이용 내역을 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "전체 내역 조회 성공",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BankLogResponseDto.class)))
            }
    )
    public ResponseEntity<List<BankLogResponseDto>> getAllBankLogs() {
        List<BankLogResponseDto> bankLogs = bankLogService.getAll();
        return ResponseEntity.ok(bankLogs);
    }

    @GetMapping("/game-member/{gameMemberId}")
    @Operation(
            summary = "특정 멤버의 저축 이용 내역 조회",
            description = "특정 게임 멤버의 저축 이용 내역을 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "멤버 내역 조회 성공",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BankLogResponseDto.class)))
            }
    )
    public ResponseEntity<List<BankLogResponseDto>> getAllBankLogsByMemberId(@PathVariable("memberId") Long memberId) {
        List<BankLogResponseDto> bankLogs = bankLogService.getBankLogsByMemberId(memberId);
        return ResponseEntity.ok(bankLogs);
    }

    @PostMapping
    @Operation(
            summary = "저축 이용 내역 생성",
            description = "새로운 저축 이용 내역을 생성합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "저축 이용 내역 생성 성공",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BankLogResponseDto.class)))
            }
    )
    public ResponseEntity<BankLogResponseDto> save(@Valid @RequestBody BankLogRequestDto requestDto,
                                                   HttpServletRequest request) {
        Long memberId = TokenUtils.getMemberIdFromRequest(request);
        Long gameId = requestDto.getGameId();
        Long gameMemberId = gameMemberService.findCurrentGameMemberByMemberId(memberId, gameId).getGameMemberId();
        requestDto.setGameMemberId(gameMemberId);
        BankLogResponseDto responseDto = bankLogService.save(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
