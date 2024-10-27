package com.virtukch.dongiveupbe.game.service;

import com.virtukch.dongiveupbe.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.game.dto.GameRequestDto;
import com.virtukch.dongiveupbe.game.dto.GameResponseDto;
import com.virtukch.dongiveupbe.game.entity.Game;
import com.virtukch.dongiveupbe.game.repository.GameRepository;
import com.virtukch.dongiveupbe.member.dto.MemberResponseDto;
import com.virtukch.dongiveupbe.member.entity.Member;
import com.virtukch.dongiveupbe.member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final MemberService memberService;

    public GameService(GameRepository gameRepository, MemberService memberService) {
        this.gameRepository = gameRepository;
        this.memberService = memberService;
    }

    @Transactional
    public GameResponseDto saveGame(GameRequestDto requestDto) {
        MemberResponseDto member = memberService.findById(requestDto.getMemberId());

        Game game = Game.builder()
                .memberId(member.getMemberId())
                .gameName(requestDto.getGameName())
                .gamePassword(requestDto.getGamePassword())
                .build();

        Game savedGame = gameRepository.save(game);
        return GameResponseDto.fromEntity(savedGame);
    }

    @Transactional(readOnly = true)
    public GameResponseDto getGame(Long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new EntityNotFoundException("게임 방을 찾을 수 없습니다. ID: " + gameId));
        return GameResponseDto.fromEntity(game);
    }

    @Transactional(readOnly = true)
    public List<GameResponseDto> getAllGames() {
        return gameRepository.findAll().stream()
                .map(GameResponseDto::fromEntity)
                .toList();
    }
}
