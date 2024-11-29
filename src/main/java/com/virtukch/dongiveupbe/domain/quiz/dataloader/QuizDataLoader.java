package com.virtukch.dongiveupbe.domain.quiz.dataloader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizAIRequestDto;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizRequestDto;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizSystemRequestDto;
import com.virtukch.dongiveupbe.domain.quiz.exception.DeveloperParsingException;
import com.virtukch.dongiveupbe.domain.quiz.repository.QuizRepository;
import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class QuizDataLoader implements CommandLineRunner {

    private final QuizRepository quizRepository;

    public QuizDataLoader(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (quizRepository.findById(1L).isEmpty()) {
            parseFirstQuizData();
            log.info("퀴즈 데이터 1이 생성되었습니다.");
        }

        if (quizRepository.findById(31L).isEmpty()) {
            parseSecondQuizData();
            log.info("퀴즈 데이터 2가 생성되었습니다.");
        }

        if (quizRepository.findById(66L).isEmpty()) {
            parseThirdQuizData();
            log.info("퀴즈 데이터 3이 생성되었습니다.");
        }

        this.createAIEconomyQuizData();
        log.info("AI 경제 퀴즈 데이터 생성");

        this.createAIFinanceQuizData();
        log.info("AI 금융 퀴즈 데이터 생성");

        this.createLastAIQuizData();
        log.info("마지막에 들어갈 데이터 생성");
    }

    private void createAIEconomyQuizData() {
        ObjectMapper objectMapper = new ObjectMapper();
        // QuizSystemRequestDto QuizAIRequestDto 는 memberId 만 다름
        List<QuizAIRequestDto> quizAIRequestDtoList = null;

        try {
            quizAIRequestDtoList = objectMapper.readValue(
                new File("src/main/resources/json/ai_economy_quiz_data.json"),
                new TypeReference<>() {
                });
        } catch (IOException e) {
            log.info(e.getMessage());
            throw new DeveloperParsingException("AI 퀴즈 파싱 중 오류 발생");
        }

        for (QuizAIRequestDto quizAIRequestDto : quizAIRequestDtoList) {
            quizRepository.save(QuizAIRequestDto.toEntity(quizAIRequestDto));
        }
    }

    private void createAIFinanceQuizData() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<QuizAIRequestDto> quizAIRequestDtoList = null;

        try {
            quizAIRequestDtoList = objectMapper.readValue(
                new File("src/main/resources/json/ai_finance_quiz_data.json"),
                new TypeReference<>() {

                });
        } catch (IOException e) {
            throw new DeveloperParsingException("AI 퀴즈 파싱 중 오류 발생");
        }
        long memberId = 1L;
        for (QuizAIRequestDto quizAIRequestDto : quizAIRequestDtoList) {
            if (memberId >= 7) {
                memberId = 0L;
            }
            memberId++;
            while (memberId == 1 || memberId == 5) {
                memberId++;
            }
            quizRepository.save(QuizAIRequestDto.toEntity(quizAIRequestDto, memberId));
        }
    }

    private void parseFirstQuizData() {
        ObjectMapper objectMapper = new ObjectMapper();
        // QuizSystemRequestDto QuizAIRequestDto 는 memberId 만 다름
        List<QuizSystemRequestDto> quizSystemRequestDtoList = null;

        try {
            quizSystemRequestDtoList = objectMapper.readValue(
                new File("src/main/resources/json/quiz01.json"),
                new TypeReference<>() {
                });
        } catch (IOException e) {
            throw new DeveloperParsingException("퀴즈 데이터 1 파싱 중 오류 발생");
        }

        for (QuizSystemRequestDto quizSystemRequestDto : quizSystemRequestDtoList) {
            quizRepository.save(QuizSystemRequestDto.toEntity(quizSystemRequestDto));
        }
    }

    private void parseSecondQuizData() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<QuizSystemRequestDto> quizSystemRequestDtoList = null;

        try {
            quizSystemRequestDtoList = objectMapper.readValue(
                new File("src/main/resources/json/quiz02.json"),
                new TypeReference<>() {
                });
        } catch (IOException e) {
            throw new DeveloperParsingException("퀴즈 데이터 2 파싱 중 오류 발생");
        }

        for (QuizSystemRequestDto quizSystemRequestDto : quizSystemRequestDtoList) {
            quizRepository.save(QuizSystemRequestDto.toEntity(quizSystemRequestDto));
        }
    }

    private void parseThirdQuizData() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<QuizSystemRequestDto> quizSystemRequestDtoList = null;

        try {
            quizSystemRequestDtoList = objectMapper.readValue(
                new File("src/main/resources/json/quiz03.json"),
                new TypeReference<>() {
                });
        } catch (IOException e) {
            throw new DeveloperParsingException("퀴즈 데이터 3 파싱 중 오류 발생");
        }

        for (QuizSystemRequestDto quizSystemRequestDto : quizSystemRequestDtoList) {
            quizRepository.save(QuizSystemRequestDto.toEntity(quizSystemRequestDto));
        }
    }

    private void createLastAIQuizData() {
        QuizRequestDto quizRequestDto1 = QuizRequestDto.builder()
            .memberId(7L)
            .quizCategory("경제 퀴즈")
            .quizTitle("세계보건기구(WHO)는 바이러스의 이름에 특정 지역, 동물, 개인이나 집단을 지칭하는 명칭을 쓰지 않는다.")
            .quizType("AI QUIZ")
            .quizAnswer("O")
            .quizDescription(
                "맞아요, WHO는 2015년부터 바이러스의 이름에 특정 지역, 동물, 개인이나 집단을 지칭하는 명칭을 쓰지 않는 원칙을 정했어요. 이는 특정 지역, 민족 등에 대한 혐오를 불러일으키지 않기 위한 조치입니다.")
            .quizLevel("normal")
            .build();
        quizRepository.save(QuizRequestDto.toEntity(quizRequestDto1));

        QuizRequestDto quizRequestDto2 = QuizRequestDto.builder()
            .memberId(7L)
            .quizCategory("금융 퀴즈")
            .quizTitle("한 주 당 만 원인 주식이 월요일에 100% 상승하고, 화요일에 100% 하락했습니다. 수요일의 주식 가격은 만 원인가요?")
            .quizType("AI QUIZ")
            .quizAnswer("X")
            .quizDescription(
                "월요일에 주식 가격이 100% 상승하면 1만 원에서 2만 원이 됩니다. 그런데 화요일에 100% 하락은 2만 원의 전체 금액이 사라진다는 뜻이므로, 주식 가격은 0원이 됩니다.")
            .quizLevel("normal")
            .build();
        quizRepository.save(QuizRequestDto.toEntity(quizRequestDto2));


        QuizRequestDto quizRequestDto3 = QuizRequestDto.builder()
                .memberId(3L)
                .quizCategory("금융 퀴즈")
                .quizTitle("소비자물가지수가 상승했다는 것은 우리가 사는데 필요한 물건이나 서비스의 가격이 전반적으로 올랐다는 것을 의미합니다.")
                .quizType("O/X")
                .quizAnswer("O")
                .quizDescription(
                        "소비자물가지수는 우리가 일상생활에서 사는데 필요한 물건이나 서비스의 가격 변동을 보여주는 지표입니다. 이 지표가 올라갔다는 것은 일반적으로 가격이 전반적으로 올랐다는 것을 의미합니다. 이 기사에서는 한국의 소비자물가지수가 전년 동월 대비 5.2% 상승했다고 말하고 있습니다.")
                .quizLevel("normal")
                .build();
        quizRepository.save(QuizRequestDto.toEntity(quizRequestDto3));

        QuizRequestDto quizRequestDto4 = QuizRequestDto.builder()
                .memberId(2L)
                .quizCategory("금융 퀴즈")
                .quizTitle("정부가 물가 안정을 우선으로 하면 경기 부양 계획에 문제가 생길 수 있습니다.")
                .quizType("O/X")
                .quizAnswer("O")
                .quizDescription(
                        " 물가 안정을 위해 정부가 예를 들어 공공요금을 동결하면, 이는 경제를 활성화시키는 데 필요한 투자나 지출을 제한할 수 있습니다. 그래서 정부가 물가 안정을 우선시하면 경기 부양 계획에 차질이 생길 수 있습니다.")
                .quizLevel("normal")
                .build();
        quizRepository.save(QuizRequestDto.toEntity(quizRequestDto4));

        QuizRequestDto quizRequestDto5 = QuizRequestDto.builder()
                .memberId(4L)
                .quizCategory("금융 퀴즈")
                .quizTitle("인플레이션은 경제 활동이 활발해져서 상품의 수요가 공급을 초과할 때 발생합니다. \n 따라서 인플레이션은 늘 경제에 좋은 영향을 미칩니다.")
                .quizType("O/X")
                .quizAnswer("X")
                .quizDescription(
                        "인플레이션은 경제 활동이 활발해져 수요가 공급을 초과할 때 발생하는 것은 맞지만, 이것이 늘 경제에 좋은 영향을 미치는 것은 아닙니다. 인플레이션이 심해지면 소비자의 구매력이 하락하게 되며 경제에 부정적인 영향을 미칠 수 있습니다.")
                .quizLevel("normal")
                .build();
        quizRepository.save(QuizRequestDto.toEntity(quizRequestDto5));
    }
}
