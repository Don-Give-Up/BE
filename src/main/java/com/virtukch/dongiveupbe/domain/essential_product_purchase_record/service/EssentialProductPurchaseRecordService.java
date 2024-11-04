package com.virtukch.dongiveupbe.domain.essential_product_purchase_record.service;

import com.virtukch.dongiveupbe.domain.essential_product_purchase_record.dto.EssentialProductPurchaseRecordRequestDto;
import com.virtukch.dongiveupbe.domain.essential_product_purchase_record.dto.EssentialProductPurchaseRecordResponseDto;
import com.virtukch.dongiveupbe.domain.essential_product_purchase_record.entity.EssentialProductPurchaseRecord;
import com.virtukch.dongiveupbe.domain.essential_product_status.entity.EssentialProductStatus;
import com.virtukch.dongiveupbe.domain.essential_product_status.service.EssentialProductStatusService;
import com.virtukch.dongiveupbe.domain.game_member.dto.GameMemberResponseDto;
import com.virtukch.dongiveupbe.domain.game_member.service.GameMemberService;
import com.virtukch.dongiveupbe.domain.essential_product_purchase_record.repository.EssentialProductPurchaseRecordRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EssentialProductPurchaseRecordService {
    private final EssentialProductPurchaseRecordRepository essentialProductPurchaseRecordRepository;
    private final GameMemberService gameMemberService;
    private final EssentialProductStatusService essentialProductStatusService;

    public EssentialProductPurchaseRecordService(EssentialProductPurchaseRecordRepository essentialProductPurchaseRecordRepository, GameMemberService gameMemberService, EssentialProductStatusService essentialProductStatusService) {
        this.essentialProductPurchaseRecordRepository = essentialProductPurchaseRecordRepository;
        this.gameMemberService = gameMemberService;
        this.essentialProductStatusService = essentialProductStatusService;
    }

    @Transactional
    public void recordPurchase(EssentialProductPurchaseRecordRequestDto requestDto) {
        // GameMember ID 유효성 체크
        GameMemberResponseDto gameMemberResponseDto = gameMemberService.findById(requestDto.getGameMemberId());

        // EssentialProductStatus ID 유효성 체크
        EssentialProductStatus productStatus = essentialProductStatusService.findById(requestDto.getEssentialProductStatusId());

        // EssentialProductPurchaseRecord 생성
        EssentialProductPurchaseRecord essentialProductPurchaseRecord = EssentialProductPurchaseRecord.builder()
                .essentialProductStatusId(productStatus.getEssentialProductStatusId())  // 유효한 ID 사용
                .gameMemberId(gameMemberResponseDto.getGameMemberId())  // 유효한 ID 사용
                .essentialProductPurchaseAmount(requestDto.getEssentialProductPurchaseAmount())
                .build();

        essentialProductPurchaseRecordRepository.save(essentialProductPurchaseRecord);
    }

    @Transactional(readOnly = true)
    public List<EssentialProductPurchaseRecordResponseDto> getPurchaseRecordsByMember(long gameMemberId) {
        return essentialProductPurchaseRecordRepository.findByGameMemberId(gameMemberId).stream()
                .map(EssentialProductPurchaseRecordResponseDto::fromEntity)
                .toList();
    }

}
