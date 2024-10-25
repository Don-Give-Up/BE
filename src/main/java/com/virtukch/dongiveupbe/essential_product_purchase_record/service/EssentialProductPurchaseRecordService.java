package com.virtukch.dongiveupbe.essential_product_purchase_record.service;

import com.virtukch.dongiveupbe.essential_product_purchase_record.dto.EssentialProductPurchaseRecordRegisterRequestDto;
import com.virtukch.dongiveupbe.essential_product_purchase_record.dto.EssentialProductPurchaseRecordResponseDto;
import com.virtukch.dongiveupbe.essential_product_purchase_record.entity.EssentialProductPurchaseRecord;
import com.virtukch.dongiveupbe.essential_product_purchase_record.repository.EssentialProductPurchaseRecordRepository;
import com.virtukch.dongiveupbe.essential_product_status.entity.EssentialProductStatus;
import com.virtukch.dongiveupbe.essential_product_status.service.EssentialProductStatusService;
import com.virtukch.dongiveupbe.game_member.entity.GameMember;
import com.virtukch.dongiveupbe.game_member.service.GameMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void recordPurchase(EssentialProductPurchaseRecordRegisterRequestDto requestDto) {
        // GameMember ID 유효성 체크
        GameMember gameMember = gameMemberService.findById(requestDto.getGameMemberId());

        // EssentialProductStatus ID 유효성 체크
        EssentialProductStatus productStatus = essentialProductStatusService.findById(requestDto.getEssentialProductStatusId());

        // EssentialProductPurchaseRecord 생성
        EssentialProductPurchaseRecord record = EssentialProductPurchaseRecord.builder()
                .essentialProductStatusId(productStatus.getEssentialProductStatusId())  // 유효한 ID 사용
                .gameMemberId(gameMember.getGameMemberId())  // 유효한 ID 사용
                .essentialProductPurchaseAmount(requestDto.getEssentialProductPurchaseAmount())
                .build();

        essentialProductPurchaseRecordRepository.save(record);
    }

    @Transactional(readOnly = true)
    public List<EssentialProductPurchaseRecordResponseDto> getPurchaseRecordsByMember(long gameMemberId) {
        return essentialProductPurchaseRecordRepository.findByGameMemberId(gameMemberId).stream()
                .map(EssentialProductPurchaseRecordResponseDto::fromEntity)
                .toList();
    }

}
