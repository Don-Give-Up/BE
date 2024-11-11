package com.virtukch.dongiveupbe.domain.quiz.service;

import com.virtukch.dongiveupbe.domain.quiz.dto.QuizBEResponseDto;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizRequestDto;
import com.virtukch.dongiveupbe.domain.quiz.dto.QuizResponseDto;
import com.virtukch.dongiveupbe.domain.quiz.entity.Quiz;
import com.virtukch.dongiveupbe.domain.quiz.exception.QuizNotFoundException;
import com.virtukch.dongiveupbe.domain.quiz.repository.QuizRepository;
import java.util.List;

import com.virtukch.dongiveupbe.security.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final MemberService memberService;

    @Autowired
    public QuizService(QuizRepository quizRepository, MemberService memberService) {
        this.quizRepository = quizRepository;
        this.memberService = memberService;
    }

    // 1. 퀴즈 전체 조회
    public List<QuizResponseDto> findAll() {
        return quizRepository.findAll().stream().map(QuizResponseDto::fromEntity).toList();
    }

    public Page<QuizBEResponseDto> findAllQuiz(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return quizRepository.findAll(pageable)
                .map(quiz -> QuizBEResponseDto.from(quiz, memberService.findMemberNicknameByMemberId(quiz.getMemberId())));
    }

    // 2. 퀴즈 아이디로 조회
    public QuizResponseDto findById(Long id) {
        return QuizResponseDto.fromEntity(quizRepository.findById(id)
            .orElseThrow(() -> new QuizNotFoundException("해당 아이디와 일치하는 퀴즈가 존재하지 않습니다.")));
    }

    // 3. 퀴즈 단일 생성
    public QuizResponseDto save(QuizRequestDto quizRequestDto, Long memberId) {
        // 입력값 로깅
        log.info("Received QuizRequestDto: {}", quizRequestDto);
        log.info("MemberId: {}", memberId);

        Quiz quiz = QuizRequestDto.toEntity(quizRequestDto);

        // 변환된 Quiz 엔티티 로깅
        log.info("Constructed Quiz Entity: {}", quiz);

        Quiz savedQuiz = quizRepository.save(quiz);

        // 저장된 Quiz 엔티티 로깅
        log.info("Saved Quiz Entity: {}", savedQuiz);

        return QuizResponseDto.fromEntity(savedQuiz);
    }
}