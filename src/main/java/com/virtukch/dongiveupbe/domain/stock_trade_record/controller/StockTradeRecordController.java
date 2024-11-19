package com.virtukch.dongiveupbe.domain.stock_trade_record.controller;

import com.virtukch.dongiveupbe.domain.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberResponseDto;
import com.virtukch.dongiveupbe.domain.game_member.service.GameMemberService;
import com.virtukch.dongiveupbe.domain.stock_trade_record.dto.StockTradeRecordResponseDto;
import com.virtukch.dongiveupbe.domain.stock_trade_record.service.StockTradeRecordService;
import com.virtukch.dongiveupbe.domain.stock_trade_record.dto.StockTradeRecordRequestDto;
import com.virtukch.dongiveupbe.security.common.utils.TokenUtils;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stock-trade-records")
@Tag(name = "주식 거래 내역 API")
public class StockTradeRecordController {

    private final StockTradeRecordService stockTradeRecordService;
    private final GameMemberService gameMemberService;

    public StockTradeRecordController(StockTradeRecordService stockTradeRecordService, GameMemberService gameMemberService) {
        this.stockTradeRecordService = stockTradeRecordService;
        this.gameMemberService = gameMemberService;
    }

    @PostMapping
    @Operation(summary = "주식을 사거나 팔 때 호출해 주세요", description = "tradeType 은 `BUY` 혹은 `SELL` 입니다. 주식 아이디는 주식이 생성될 때 응답으로 받을 수 있습니다. 또는, /api/v1/stocks 에서 조회할 수 있습니다.")
    @ApiResponse(responseCode = "200", description = "주식 거래 내역 생성 성공",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = StockTradeRecordRequestDto.class)))
    public ResponseEntity<StockTradeRecordResponseDto> createTradeRecord(
        @RequestBody StockTradeRecordRequestDto requestDto,
        HttpServletRequest request) {
        Long memberId = TokenUtils.getMemberIdFromRequest(request);
        GameMemberResponseDto gameMember = gameMemberService.findCurrentGameMemberByMemberId(memberId, requestDto.getGameId());
        if (gameMember == null) {
            throw new EntityNotFoundException("현재 게임에 참여 중인 멤버를 찾을 수 없습니다. memberId: " + memberId);
        }
        requestDto.setGameMemberId(gameMember.getGameMemberId());
        StockTradeRecordResponseDto responseDto = stockTradeRecordService.tradeStock(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    @Operation(summary = "전체 거래 내역 조회", description = "전체 주식 거래 내역을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "전체 주식 거래 내역 조회 성공",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = StockTradeRecordResponseDto.class)))
    public ResponseEntity<List<StockTradeRecordResponseDto>> getAllTradeRecords() {
        List<StockTradeRecordResponseDto> tradeRecords = stockTradeRecordService.getAllTradeRecords();
        return ResponseEntity.ok(tradeRecords);
    }


    @GetMapping("/game-member/{gameMemberId}")
    @Operation(summary = "특정 멤버의 거래 내역 조회", description = "특정 게임 멤버의 주식 거래 내역을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "특정 게임 멤버의 거래 내역 조회 성공",
        content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = StockTradeRecordResponseDto.class)))
    public ResponseEntity<List<StockTradeRecordResponseDto>> getTradeRecordsByMemberId(
        @PathVariable Long gameMemberId) {
        List<StockTradeRecordResponseDto> tradeRecords = stockTradeRecordService.getTradeRecordsByGameMemberId(
                gameMemberId);
        return ResponseEntity.ok(tradeRecords);
    }
}
