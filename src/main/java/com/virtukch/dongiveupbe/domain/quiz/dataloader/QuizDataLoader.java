package com.virtukch.dongiveupbe.domain.quiz.dataloader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizRequestDto;
import com.virtukch.dongiveupbe.domain.quiz.exception.DeveloperParsingException;
import com.virtukch.dongiveupbe.domain.quiz.repository.QuizRepository;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizSystemRequestDto;
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
//        if (quizRepository.findById(1L).isEmpty()) {
//            parseFirstQuizData();
//            log.info("퀴즈 데이터 1이 생성되었습니다.");
//        }
//
//        if (quizRepository.findById(31L).isEmpty()) {
//            parseSecondQuizData();
//            log.info("퀴즈 데이터 2가 생성되었습니다.");
//        }
//
//        if (quizRepository.findById(66L).isEmpty()) {
//            parseThirdQuizData();
//            log.info("퀴즈 데이터 3이 생성되었습니다.");
//        }

        createAIQuizData();
    }

    private void createAIQuizData() {
        QuizRequestDto quizRequestDto1 = QuizRequestDto.builder()
            .memberId(7L)
            .quizCategory("금융 뉴스")
            .quizTitle("슈링크플레이션은 가격을 올리지 않고 상품의 용량을 줄여 가격 인상 효과를 노리는 방식이다.")
            .quizType("AI QUIZ")
            .quizAnswer("O")
            .quizDescription("슈링크플레이션은 상품의 가격은 그대로 유지하면서 용량을 줄여, 이로써 실질적으로 가격을 올린 것과 같은 효과를 내는 방식을 말합니다. 이를 통해 소비자는 물건의 가격이 올랐는지 모르고 물건을 구매하게 됩니다.")
            .quizLevel("AI")
            .build();
        quizRepository.save(QuizRequestDto.toEntity(quizRequestDto1));

        QuizRequestDto quizRequestDto2 = QuizRequestDto.builder()
            .memberId(7L)
            .quizCategory("경제 뉴스")
            .quizTitle("세계보건기구(WHO)는 바이러스의 이름에 특정 지역, 동물, 개인이나 집단을 지칭하는 명칭을 쓰지 않는다.")
            .quizType("AI QUIZ")
            .quizAnswer("O")
            .quizDescription("맞아요, WHO는 2015년부터 바이러스의 이름에 특정 지역, 동물, 개인이나 집단을 지칭하는 명칭을 쓰지 않는 원칙을 정했어요. 이는 특정 지역, 민족 등에 대한 혐오를 불러일으키지 않기 위한 조치입니다.")
            .quizLevel("AI")
            .build();
        quizRepository.save(QuizRequestDto.toEntity(quizRequestDto2));
    }

    private void parseFirstQuizData() {
        ObjectMapper objectMapper = new ObjectMapper();
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
}
