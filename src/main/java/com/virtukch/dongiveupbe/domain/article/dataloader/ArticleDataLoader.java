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
                .memberId(2L)
                .articleTitle("인플레이션은 늘 경제에 좋은 영향을 미칠까요?")
                .articleContents(
                        "퀴즈: '인플레이션은 경제 활동이 활발해져서 상품의 수요가 공급을 초과할 때 발생합니다. " +
                                "따라서 인플레이션은 늘 경제에 좋은 영향을 미칩니다.'라는 질문에 대해 이야기 나눠봅시다!\n\n" +
                                "인플레이션은 때로는 경제 활동을 활성화시킬 수 있지만, 과도한 인플레이션은 소비자 구매력을 떨어뜨리고 " +
                                "경제에 부정적인 영향을 미칠 수 있습니다. 선생님들께서는 인플레이션과 관련된 다른 사례나 수업에서 사용하신 자료가 있다면 공유해 주세요!"
                )
                .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto1));

        ArticleRequestDto articleRequestDto2 = ArticleRequestDto.builder()
                .memberId(3L)
                .articleTitle("학생들이 재미있어했던 퀴즈 주제 공유")
                .articleContents("저는 경제 관련 퀴즈를 수업에서 활용했는데, 특히 '인플레이션' 주제가 학생들에게 흥미를 끌었습니다. 다른 선생님들께서 재미있게 활용하신 퀴즈 주제를 공유해주시면 좋겠습니다!")
                .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto2));

        ArticleRequestDto articleRequestDto3 = ArticleRequestDto.builder()
                .memberId(4L)
                .articleTitle("퀴즈 생성 도구 사용법에 대한 질문")
                .articleContents("퀴즈 생성 도구를 사용하면서 학생 맞춤형 퀴즈를 만드는 방법이 궁금합니다. 혹시 다른 선생님들께서 사용하신 특별한 팁이나 도구가 있으면 공유 부탁드립니다!")
                .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto3));

        ArticleRequestDto articleRequestDto4 = ArticleRequestDto.builder()
                .memberId(2L)
                .articleTitle("다른 선생님들과 협업 퀴즈 제작해보신 분?")
                .articleContents("여러 선생님들과 함께 퀴즈를 제작하는 방식을 시도해보고 싶습니다. 협업을 통해 더 창의적인 퀴즈를 만들어본 경험이 있으신 분들의 조언을 듣고 싶어요!")
                .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto4));

        ArticleRequestDto articleRequestDto6 = ArticleRequestDto.builder()
                .memberId(3L)
                .articleTitle("퀴즈 플랫폼에서 북마크 기능 활용 후기")
                .articleContents("퀴즈 플랫폼에서 제공하는 북마크 기능이 정말 유용했습니다. 자주 사용하는 퀴즈를 북마크해 두니 수업 준비가 훨씬 간편해졌습니다. 다른 선생님들은 어떻게 활용하고 계신가요?")
                .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto6));

        ArticleRequestDto articleRequestDto7 = ArticleRequestDto.builder()
                .memberId(4L)
                .articleTitle("AI 기반 퀴즈 생성 기능 후기")
                .articleContents("최근에 AI를 활용해 퀴즈를 생성해보았습니다. 간단한 주제도 상세히 다룰 수 있어 유용했는데요, 다른 선생님들은 AI 퀴즈 생성 기능을 어떻게 활용하고 계신가요?")
                .build();

        articleRepository.save(ArticleRequestDto.toEntity(articleRequestDto7));
    }
}
