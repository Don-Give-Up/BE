package com.virtukch.dongiveupbe.domain.game.dataloader;

import com.virtukch.dongiveupbe.domain.game.entity.Game;
import com.virtukch.dongiveupbe.domain.game.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class GameDataLoader implements CommandLineRunner {

    private final GameRepository gameRepository;

    @Autowired
    public GameDataLoader(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Long memberId = 6L;

        // 게임 데이터 추가
        gameRepository.save(Game.builder()
                .memberId(memberId)
                .gameName("금융 퀴즈 대회")
                .gamePassword("1234")
                .build());

        gameRepository.save(Game.builder()
                .memberId(memberId)
                .gameName("금융 상식 마스터 도전!")
                .gamePassword("2345")
                .build());

        gameRepository.save(Game.builder()
                .memberId(memberId)
                .gameName("금리와 경제 퀴즈")
                .gamePassword("3456")
                .build());

        log.info("Game data has been loaded.");
    }
}
