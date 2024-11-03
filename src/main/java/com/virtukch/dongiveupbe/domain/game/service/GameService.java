package com.virtukch.dongiveupbe.domain.game.service;

import com.virtukch.dongiveupbe.domain.game.dto.GameResponseDto;
import com.virtukch.dongiveupbe.domain.game.entity.Game;
import com.virtukch.dongiveupbe.domain.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.domain.game.dto.GameRequestDto;
import com.virtukch.dongiveupbe.domain.game.repository.GameRepository;
import com.virtukch.dongiveupbe.domain.member.dto.MemberResponseDto;
import com.virtukch.dongiveupbe.domain.member.service.MemberService;
import com.virtukch.dongiveupbe.domain.round.service.RoundService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final MemberService memberService;
    private final RoundService roundService;

    public GameService(GameRepository gameRepository, MemberService memberService, RoundService roundService) {
        this.gameRepository = gameRepository;
        this.memberService = memberService;
        this.roundService = roundService;
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
        // 게임이 생성 되면 라운드 생성
        roundService.createRoundsForGame(savedGame.getGameId());
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
