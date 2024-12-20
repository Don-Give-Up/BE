package com.virtukch.dongiveupbe.domain.round.service;

import com.virtukch.dongiveupbe.domain.essential_product.exception.EntityNotFoundException;
import com.virtukch.dongiveupbe.domain.round.repository.RoundRepository;
import com.virtukch.dongiveupbe.domain.round.entity.Round;
import org.springframework.stereotype.Service;

@Service
public class RoundService {

    private final RoundRepository roundRepository;

    public RoundService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    public void createRoundsForGame(Long gameId) {
        // 주어진 급여 및 이자율 데이터
        Long[] salaries = {
                266475L, 292600L, 310365L, 318725L, 334400L, 389785L, 438900L, 475475L,
                524590L, 593560L, 647900L, 727320L, 787930L, 836000L, 858990L, 902880L,
                957220L, 1015740L, 1088890L, 1166220L, 1260270L, 1352230L, 1573770L,
                1745150L, 1795310L, 1822480L, 1914440L, 2010580L
        };

        Double[] rates = {
                17.07, 14.38, 12.07, 12.29, 12.44, 12.36, 13.27, 14.85, 5.00, 5.16, 4.69, 4.21, 4.00,
                3.65,
                3.33, 4.19, 4.77, 4.78, 1.98, 2.16, 3.09, 3.08, 2.59, 2.34, 1.65, 1.34, 1.26, 1.52
        };

        // 각 라운드에 대한 데이터를 삽입
        for (int i = 0; i < salaries.length; i++) {
            Round round = Round.builder()
                    .gameId(gameId)
                    .roundSalary(salaries[i])
                    .roundInterestRate(rates[i])
                    .build();
            roundRepository.save(round);
        }
    }
    public Round findRoundById(Long roundId) {
        return roundRepository.findById(roundId)
                .orElseThrow(() -> new EntityNotFoundException("해당 라운드를 찾을 수 없습니다. 라운드 ID: " + roundId));
    }

}
