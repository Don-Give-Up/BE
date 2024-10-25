package com.virtukch.dongiveupbe.quiz.dataloader;

import com.virtukch.dongiveupbe.quiz.entity.IsAcceptedByTeacher;
import com.virtukch.dongiveupbe.quiz.entity.MultipleChoiceQuizAnswer;
import com.virtukch.dongiveupbe.quiz.entity.OXQuizAnswer;
import com.virtukch.dongiveupbe.quiz.entity.Quiz;
import com.virtukch.dongiveupbe.quiz.entity.QuizType;
import com.virtukch.dongiveupbe.quiz.repository.QuizRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QuizDataLoader implements CommandLineRunner {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizDataLoader(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    // local (ddl-auto: none, DataLoader 작동 X)
    // localCreate (ddl-auto: create, DataLoader 작동 O)
    // dev (ddl-auto: none, DataLoader 작동 X)
    // devCreate (ddl-auto: create, DataLoader 작동 O)
    // prod (ddl-auto: create, DataLoader 작동 O)
    @Override
    public void run(String... args) throws Exception {
        Quiz quiz1 = Quiz.builder()
            .memberId(3L)
            .unitId(1L)
            .quizTitle("송호진의 키는 190이 넘는다??")
            .quizType(QuizType.OX)
            .oxQuizAnswer(OXQuizAnswer.X)
            .multipleChoiceQuizAnswer(null)
            .subjectiveQuizAnswer(null)
            .isAcceptedByTeacher(IsAcceptedByTeacher.ACCEPTED_BY_TEACHER)
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .quizLevel(1L)
            .build();
        quizRepository.save(quiz1);

        Quiz quiz2 = Quiz.builder()
            .memberId(3L)
            .unitId(2L)
            .quizTitle("다음 보기 중 남자인 사람은?")
            .quizType(QuizType.MULTIPLE_CHOICE)
            .oxQuizAnswer(null)
            .multipleChoiceQuizAnswer(MultipleChoiceQuizAnswer.ONE)
            .subjectiveQuizAnswer(null)
            .isAcceptedByTeacher(IsAcceptedByTeacher.ACCEPTED_BY_TEACHER)
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .quizLevel(2L)
            .build();
        quizRepository.save(quiz2);

        Quiz quiz3 = Quiz.builder()
            .memberId(null)
            .unitId(3L)
            .quizTitle("[AI 퀴즈] 10월 25일 금요일 종가 기준 삼성전자의 가격은?")
            .quizType(QuizType.MULTIPLE_CHOICE)
            .oxQuizAnswer(null)
            .multipleChoiceQuizAnswer(MultipleChoiceQuizAnswer.ONE)
            .subjectiveQuizAnswer(null)
            .isAcceptedByTeacher(IsAcceptedByTeacher.NOT_ACCEPTED_BY_TEACHER)
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .quizLevel(3L)
            .build();
        quizRepository.save(quiz3);

        Quiz quiz4 = Quiz.builder()
            .memberId(4L)
            .unitId(4L)
            .quizTitle("오르지 않는 것은?")
            .quizType(QuizType.SUBJECTIVE)
            .oxQuizAnswer(null)
            .multipleChoiceQuizAnswer(null)
            .subjectiveQuizAnswer("내 월급")
            .isAcceptedByTeacher(IsAcceptedByTeacher.ACCEPTED_BY_TEACHER)
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .quizLevel(4L)
            .build();
        quizRepository.save(quiz4);

        Quiz quiz5 = Quiz.builder()
            .memberId(5L)
            .unitId(5L)
            .quizTitle("김채호는 잘생겼나요??")
            .quizType(QuizType.OX)
            .oxQuizAnswer(OXQuizAnswer.O)
            .multipleChoiceQuizAnswer(null)
            .subjectiveQuizAnswer(null)
            .isAcceptedByTeacher(IsAcceptedByTeacher.ACCEPTED_BY_TEACHER)
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .quizLevel(1L)
            .build();
        quizRepository.save(quiz5);
    }
}