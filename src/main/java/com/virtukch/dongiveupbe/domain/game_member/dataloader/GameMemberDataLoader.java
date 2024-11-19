package com.virtukch.dongiveupbe.domain.game_member.dataloader;

import com.virtukch.dongiveupbe.domain.game_member.entity.GameMember;
import com.virtukch.dongiveupbe.domain.game_member.repository.GameMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class GameMemberDataLoader implements CommandLineRunner {

    private final GameMemberRepository gameMemberRepository;

    public GameMemberDataLoader(GameMemberRepository gameMemberRepository) {
        this.gameMemberRepository = gameMemberRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadGameMembers();
    }

    private void loadGameMembers() {
        if (gameMemberRepository.count() == 0) {
            // 첫 번째 GameMember 생성
            GameMember gameMember1 = GameMember.builder()
                    .gameMemberId(1L)
                    .memberId(1L)
                    .gameId(1L)
                    .gameMemberMoney(42950)
                    .build();

            // 두 번째 GameMember 생성
            GameMember gameMember2 = GameMember.builder()
                    .gameMemberId(2L)
                    .memberId(2L)
                    .gameId(1L)
                    .gameMemberMoney(42950)
                    .build();

            gameMemberRepository.save(gameMember1);
            gameMemberRepository.save(gameMember2);

            log.info("GameMember 데이터 스텁이 추가되었습니다: gameMemberId 1, 2. gameId는 1, money는 각각 10000, 15000으로 설정되었습니다.");
        } else {
            log.info("이미 GameMember 데이터가 존재합니다. 데이터 로드를 생략합니다.");
        }
    }
}
