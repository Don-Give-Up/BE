package com.virtukch.dongiveupbe.domain.article_comment.service;

import com.virtukch.dongiveupbe.domain.article.exception.ArticleNotFoundException;
import com.virtukch.dongiveupbe.domain.article_comment.dto.ArticleCommentPatchRequestDto;
import com.virtukch.dongiveupbe.domain.article_comment.dto.ArticleCommentRequestDto;
import com.virtukch.dongiveupbe.domain.article_comment.dto.ArticleCommentResponseDto;
import com.virtukch.dongiveupbe.domain.article_comment.entity.ArticleComment;
import com.virtukch.dongiveupbe.domain.article_comment.repository.ArticleCommentRepository;
import com.virtukch.dongiveupbe.security.member.repository.MemberRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;
    private final MemberRepository memberRepository;

    public ArticleCommentService(ArticleCommentRepository articleCommentRepository,
        MemberRepository memberRepository) {
        this.articleCommentRepository = articleCommentRepository;
        this.memberRepository = memberRepository;
    }

    // 1. 댓글 전체 조회
    public List<ArticleCommentResponseDto> findAllByArticleId(Long articleId) {
        return articleCommentRepository.findAllByArticleId(articleId).stream().map(
            articleComment -> ArticleCommentResponseDto.fromEntity(articleComment,
                memberRepository.findMemberNicknameByMemberId(articleComment.getMemberId())
                    .getMemberNickname())).toList();
    }

    // 2. 댓글 생성
    public ArticleCommentResponseDto save(ArticleCommentRequestDto articleCommentRequestDto,
        Long memberId) {
        articleCommentRequestDto.setMemberId(memberId);
        ArticleComment articleComment = articleCommentRepository.save(
            ArticleCommentRequestDto.toEntity(articleCommentRequestDto));
        String memberNickname = memberRepository.findMemberNicknameByMemberId(memberId)
            .getMemberNickname();
        return ArticleCommentResponseDto.fromEntity(articleComment, memberNickname);
    }

    // 3. 댓글 수정
    public ArticleCommentResponseDto save(Long articleCommentId,
        ArticleCommentPatchRequestDto articleCommentPatchRequestDto) {
        ArticleComment articleComment = articleCommentRepository.findById(articleCommentId)
            .orElseThrow(() -> new ArticleNotFoundException("Not Found By Article Id"));
        articleComment.setArticleCommentContent(
            articleCommentPatchRequestDto.getArticleCommentContent());
        String memberNickname = memberRepository.findMemberNicknameByMemberId(
            articleComment.getMemberId()).getMemberNickname();
        articleComment.setArticleCommentUpdatedAt(LocalDateTime.now());
        return ArticleCommentResponseDto.fromEntity(articleCommentRepository.save(articleComment),
            memberNickname);
    }

    // 4. 댓글 삭제
    public void deleteById(Long articleCommentId) {
        articleCommentRepository.deleteById(articleCommentId);
    }
}