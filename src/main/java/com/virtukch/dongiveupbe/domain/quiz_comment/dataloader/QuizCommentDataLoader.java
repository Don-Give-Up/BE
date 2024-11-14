package com.virtukch.dongiveupbe.domain.quiz_comment.dataloader;

import com.virtukch.dongiveupbe.domain.quiz_comment.dto.QuizCommentRequestDto;
import com.virtukch.dongiveupbe.domain.quiz_comment.repository.QuizCommentRepository;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"localCreate", "devCreate", "prodCreate"})
public class QuizCommentDataLoader implements CommandLineRunner {

    private final QuizCommentRepository quizCommentRepository;

    public QuizCommentDataLoader(QuizCommentRepository quizCommentRepository) {
        this.quizCommentRepository = quizCommentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        QuizCommentRequestDto quizCommentRequestDto1 = QuizCommentRequestDto.builder()
            .quizId(149L)
            .memberId(2L)
            .quizCommentContent(
                "슈링크플레이션에 대한 개념을 이해하기 어려운 부분이 있었던 것 같아요. 슈링크플레이션은 가격은 그대로인데 물건의 양이 줄어드는 현상이에요. 예를 들어, 가격이 같지만 초콜릿의 크기가 작아지거나 음료수의 용량이 줄어드는 경우죠. 기업들이 가격 인상을 피하면서 양을 줄이는 방법이에요. 가격과 양의 관계를 이해하면 더 쉽게 알 수 있을 거예요 경제 개념을 더 공부하면 퀴즈에서 좋은 결과를 얻을 수 있을 거예요!")
            .quizCommentCreatedAt(LocalDateTime.now())
            .build();
        quizCommentRepository.save(QuizCommentRequestDto.toEntity(quizCommentRequestDto1));

        QuizCommentRequestDto quizCommentRequestDto2 = QuizCommentRequestDto.builder()
            .quizId(149L)
            .memberId(3L)
            .quizCommentContent(
                "아이들에게 슈링크플레이션을 설명할 때, 실제 사례를 보여주면 더 쉽게 이해할 수 있을 것 같아요! 실생활과 연결하는 것이 중요하죠.")
            .quizCommentCreatedAt(LocalDateTime.now())
            .build();

        quizCommentRepository.save(QuizCommentRequestDto.toEntity(quizCommentRequestDto2));

        QuizCommentRequestDto quizCommentRequestDto3 = QuizCommentRequestDto.builder()
            .quizId(149L)
            .memberId(4L)
            .quizCommentContent("이런 개념을 가르치면서 소비자 교육의 필요성을 강조해줘야겠어요. 아이들이 똑똑한 소비자가 되도록 도와야 합니다.")
            .quizCommentCreatedAt(LocalDateTime.now())
            .build();

        quizCommentRepository.save(QuizCommentRequestDto.toEntity(quizCommentRequestDto3));

        QuizCommentRequestDto quizCommentRequestDto4 = QuizCommentRequestDto.builder()
            .quizId(149L)
            .memberId(6L)
            .quizCommentContent(
                "이런 내용은 아이들에게 단순한 경제 개념 이상의 것을 가르칠 수 있는 기회가 될 것 같아요. 소비자 의식을 키워주는 것이 중요하죠!")
            .quizCommentCreatedAt(LocalDateTime.now())
            .build();

        quizCommentRepository.save(QuizCommentRequestDto.toEntity(quizCommentRequestDto4));
    }
}
