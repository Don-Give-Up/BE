package com.virtukch.dongiveupbe.domain.article.dataloader;

import com.virtukch.dongiveupbe.domain.article.dto.ArticleRequestDto;
import com.virtukch.dongiveupbe.domain.article.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class ArticleDataLoader implements CommandLineRunner {

    private final ArticleRepository articleRepository;

    public ArticleDataLoader(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ArticleRequestDto articleRequestDto1 = ArticleRequestDto.builder()
            .memberId(1L)
            .articleTitle("채호진의 퀴즈 웹에 오신 걸 환영합니다 횐님들^_^")
            .articleContents("인사 야무지게 드리겠습니다 ^_^")
            .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto1));

        ArticleRequestDto articleRequestDto2 = ArticleRequestDto.builder()
            .memberId(2L)
            .articleTitle("너무 유익한 웹 사이트인 것 같아요~!")
            .articleContents("어떻게 이런 걸 만들 생각을 하셨죠?? 채호진님들 정말 천재!")
            .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto2));

        ArticleRequestDto articleRequestDto3 = ArticleRequestDto.builder()
            .memberId(3L)
            .articleTitle("아이들이 정말 바람직하게 자랄 수 있겠어요!")
            .articleContents("채호진님들 정말 천재요!")
            .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto3));

        ArticleRequestDto articleRequestDto4 = ArticleRequestDto.builder()
            .memberId(4L)
            .articleTitle("호진희 담임입니다. 너무 좋은 서비스를 만들어 주셔서 다행입니다.")
            .articleContents("채호진님들 정말 천재에요!")
            .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto4));

        ArticleRequestDto articleRequestDto6 = ArticleRequestDto.builder()
            .memberId(6L)
            .articleTitle("오 마이! 너무 좋아요~!~!")
            .articleContents("어떻게 이런 걸 만들 생각을 하셨죠?? 채호진님들 정말 천재에요!")
            .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto6));

        ArticleRequestDto articleRequestDto7 = ArticleRequestDto.builder()
            .memberId(7L)
            .articleTitle("굿이에요 굿~~!~!~!")
            .articleContents("어떻게 이런 걸 만들 생각을 하셨죠?? 채호진님들 정말 천재에요!")
            .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto7));
    }
}