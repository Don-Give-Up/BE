package com.virtukch.dongiveupbe.domain.article_comment.service;

import com.virtukch.dongiveupbe.domain.article_comment.dto.ArticleCommentRequestDto;
import com.virtukch.dongiveupbe.domain.article_comment.dto.ArticleCommentResponseDto;
import com.virtukch.dongiveupbe.domain.article_comment.entity.ArticleComment;
import com.virtukch.dongiveupbe.domain.article_comment.repository.ArticleCommentRepository;
import com.virtukch.dongiveupbe.security.member.repository.MemberRepository;
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
}