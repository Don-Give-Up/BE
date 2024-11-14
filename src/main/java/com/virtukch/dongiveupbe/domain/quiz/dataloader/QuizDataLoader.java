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
        for (QuizAIRequestDto quizAIRequestDto : quizAIRequestDtoList) {
            quizRepository.save(QuizAIRequestDto.toEntity(quizAIRequestDto));
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
            .quizCategory("금융 퀴즈")
            .quizTitle("슈링크플레이션은 가격을 올리지 않고 상품의 용량을 줄여 가격 인상 효과를 노리는 방식이다.")
            .quizType("AI QUIZ")
            .quizAnswer("O")
            .quizDescription(
                "슈링크플레이션은 상품의 가격은 그대로 유지하면서 용량을 줄여, 이로써 실질적으로 가격을 올린 것과 같은 효과를 내는 방식을 말합니다. 이를 통해 소비자는 물건의 가격이 올랐는지 모르고 물건을 구매하게 됩니다.")
            .quizLevel("normal")
            .build();
        quizRepository.save(QuizRequestDto.toEntity(quizRequestDto1));

        QuizRequestDto quizRequestDto2 = QuizRequestDto.builder()
            .memberId(7L)
            .quizCategory("경제 퀴즈")
            .quizTitle("세계보건기구(WHO)는 바이러스의 이름에 특정 지역, 동물, 개인이나 집단을 지칭하는 명칭을 쓰지 않는다.")
            .quizType("AI QUIZ")
            .quizAnswer("O")
            .quizDescription(
                "맞아요, WHO는 2015년부터 바이러스의 이름에 특정 지역, 동물, 개인이나 집단을 지칭하는 명칭을 쓰지 않는 원칙을 정했어요. 이는 특정 지역, 민족 등에 대한 혐오를 불러일으키지 않기 위한 조치입니다.")
            .quizLevel("normal")
            .build();
        quizRepository.save(QuizRequestDto.toEntity(quizRequestDto2));

        QuizRequestDto quizRequestDto3 = QuizRequestDto.builder()
            .memberId(1L)
            .quizCategory("경제 퀴즈")
            .quizTitle("한 주 당 만 원인 주식이 월요일에 100% 상승하고, 화요일에 100% 하락했습니다. 수요일의 주식 가겨은 만 원인가요?")
            .quizType("주식")
            .quizAnswer("X")
            .quizDescription("100% 하락한 다음 날의 주가는 0원 입니다.")
            .quizLevel("normal")
            .build();
        quizRepository.save(QuizRequestDto.toEntity(quizRequestDto3));
    }
}