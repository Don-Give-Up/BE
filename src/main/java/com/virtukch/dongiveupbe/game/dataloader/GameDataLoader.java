package com.virtukch.dongiveupbe.game.dataloader;

import com.virtukch.dongiveupbe.game.entity.Game;
import com.virtukch.dongiveupbe.game.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prod"})
public class GameDataLoader implements CommandLineRunner {

    private final GameRepository gameRepository;

    public GameDataLoader(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Game game1 = new Game(1L, "경제 모험", "eco123");
        Game game2 = new Game(2L, "투자의 달인", "invest456");
        Game game3 = new Game(3L, "부자 되기 챌린지", "rich789");
        Game game4 = new Game(4L, "무역 왕국", "trade999");
        Game game5 = new Game(5L, "경제 퀴즈 배틀", "quizeco321");

        gameRepository.save(game1);
        gameRepository.save(game2);
        gameRepository.save(game3);
        gameRepository.save(game4);
        gameRepository.save(game5);

        log.info("Game 경제 관련 스텁 데이터가 삽입되었습니다.");
    }
}
