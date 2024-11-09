package com.virtukch.dongiveupbe.domain.quiz.dataloader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
