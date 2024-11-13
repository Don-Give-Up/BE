package com.virtukch.dongiveupbe.domain.article_comment.dataloader;

import com.virtukch.dongiveupbe.domain.article_comment.dto.ArticleCommentRequestDto;
import com.virtukch.dongiveupbe.domain.article_comment.repository.ArticleCommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class ArticleCommentDataLoader implements CommandLineRunner {

    private final ArticleCommentRepository articleCommentRepository;

    public ArticleCommentDataLoader(ArticleCommentRepository articleCommentRepository) {
        this.articleCommentRepository = articleCommentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        for (long i = 1L; i < 7L; i++) {
            ArticleCommentRequestDto articleCommentRequestDto1 = ArticleCommentRequestDto.builder()
                .articleId(i)
                .memberId(1L)
                .articleCommentContent("많은 사랑 부탁드립니다.")
                .build();

            articleCommentRepository.save(ArticleCommentRequestDto.toEntity(articleCommentRequestDto1));

            ArticleCommentRequestDto articleCommentRequestDto2 = ArticleCommentRequestDto.builder()
                .articleId(i)
                .memberId(2L)
                .articleCommentContent("피드백 남겨주시면 감사하겠습니다!")
                .build();

            articleCommentRepository.save(ArticleCommentRequestDto.toEntity(articleCommentRequestDto2));

            ArticleCommentRequestDto articleCommentRequestDto3 = ArticleCommentRequestDto.builder()
                .articleId(i)
                .memberId(3L)
                .articleCommentContent("항상 재미있게 쓰고 있는 서비스입니다 ^^")
                .build();

            articleCommentRepository.save(ArticleCommentRequestDto.toEntity(articleCommentRequestDto3));

            ArticleCommentRequestDto articleCommentRequestDto4 = ArticleCommentRequestDto.builder()
                .articleId(i)
                .memberId(4L)
                .articleCommentContent("북마크 기능이 특히 좋은 것 같아요 ^^")
                .build();

            articleCommentRepository.save(ArticleCommentRequestDto.toEntity(articleCommentRequestDto4));

            ArticleCommentRequestDto articleCommentRequestDto6 = ArticleCommentRequestDto.builder()
                .articleId(i)
                .memberId(6L)
                .articleCommentContent("쥬라기 공원 게임 한 번 참여해 보세요!")
                .build();

            articleCommentRepository.save(ArticleCommentRequestDto.toEntity(articleCommentRequestDto6));

            ArticleCommentRequestDto articleCommentRequestDto7 = ArticleCommentRequestDto.builder()
                .articleId(i)
                .memberId(7L)
                .articleCommentContent("AI 너무 좋다 삐빅! 삐빅!")
                .build();

            articleCommentRepository.save(ArticleCommentRequestDto.toEntity(articleCommentRequestDto7));
        }
    }
}
