package com.virtukch.dongiveupbe.domain.comment.service;

import com.virtukch.dongiveupbe.domain.comment.dto.QuizCommentRequestDto;
import com.virtukch.dongiveupbe.domain.comment.dto.QuizCommentResponseDto;
import com.virtukch.dongiveupbe.domain.comment.entity.QuizComment;
import com.virtukch.dongiveupbe.domain.comment.exception.QuizCommentNotFoundException;
import com.virtukch.dongiveupbe.domain.comment.repository.QuizCommentRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class QuizCommentService {
    private final QuizCommentRepository quizCommentRepository;

    public QuizCommentService(QuizCommentRepository quizCommentRepository) {
        this.quizCommentRepository = quizCommentRepository;
    }

    // 댓글 생성
    public QuizCommentResponseDto save( Long quizId, QuizCommentRequestDto requestDto) {

        QuizComment quizComment = QuizComment.builder()
                .quizId(quizId)
                .memberId(requestDto.getMemberId())
                .quizCommentContent(requestDto.getQuizCommentContent())
                .quizCommentCreatedAt(LocalDateTime.now())
                .build();
        quizCommentRepository.save(quizComment);
        return QuizCommentResponseDto.fromEntity(quizComment);
    }

    // 댓글 수정
    public QuizCommentResponseDto update(Long commentId, QuizCommentRequestDto requestDto) {
        QuizComment quizComment = quizCommentRepository.findById(commentId)
                .orElseThrow(() -> new QuizCommentNotFoundException("댓글을 찾을 수 없습니다." + commentId));
        quizComment.update(requestDto);
        quizCommentRepository.save(quizComment);
        return QuizCommentResponseDto.fromEntity(quizComment);
    }

    // 댓글 삭제
    public void delete(Long commentId) {
        quizCommentRepository.deleteById(commentId);
    }

    // 특정 퀴즈의 모든 댓글 조회
    public List<QuizCommentResponseDto> getAllCommentsByQuizId(Long quizId) {
        List<QuizComment> comments = quizCommentRepository.findByQuizId(quizId);
        return comments.stream()
                .map(QuizCommentResponseDto::fromEntity)
                .toList();
    }

    // 특정 댓글 조회
    public QuizCommentResponseDto getCommentById(Long commentId) {
        QuizComment quizComment = quizCommentRepository.findById(commentId)
                .orElseThrow(() -> new QuizCommentNotFoundException("댓글을 찾을 수 없습니다." + commentId));
        return QuizCommentResponseDto.fromEntity(quizComment);
    }
}
