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
import org.springframework.data.domain.Sort;
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

    public Page<QuizBEResponseDto> findAllQuiz(Pageable pageable, String searchType, String searchKeyword) {
        Page<Quiz> quizPage;

        if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
            searchKeyword = searchKeyword.toLowerCase();
            switch (searchType) {
                case "title":
                    quizPage = quizRepository.findByQuizTitleContainingIgnoreCase(searchKeyword, pageable);
                    break;
                case "category":
                    quizPage = quizRepository.findByQuizCategoryContainingIgnoreCase(searchKeyword, pageable);
                    break;
                case "level":
                    quizPage = quizRepository.findByQuizLevelContainingIgnoreCase(searchKeyword, pageable);
                    break;
                case "all":
                    quizPage = quizRepository.findByAllFields(searchKeyword, pageable);
                    break;
                default:
                    quizPage = quizRepository.findAll(pageable);
            }
        } else {
            quizPage = quizRepository.findAll(pageable);
        }

        return quizPage.map(quiz -> {
            String nickname = memberService.findMemberNicknameByMemberId(quiz.getMemberId());
            return QuizBEResponseDto.from(quiz, nickname);
        });
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

    public QuizBEResponseDto findByQuizId(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new QuizNotFoundException("퀴즈가 없음" + quizId));
        String memberNickname = memberService.findMemberNicknameByMemberId(quiz.getMemberId());

        return QuizBEResponseDto.from(quiz, memberNickname);
    }
}