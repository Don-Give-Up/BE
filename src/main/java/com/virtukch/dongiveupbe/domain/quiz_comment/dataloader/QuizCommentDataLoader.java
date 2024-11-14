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
        quizCommentRepository.save(QuizCommentRequestDto.toEntity(QuizCommentRequestDto.builder()
            .quizId(149L)
            .memberId(7L)
            .quizCommentContent("슈링크플레이션에 대한 개념을 이해하기 어려운 부분이 있었던 것 같아요.\n"
                + "슈링크플레이션은 가격은 그대로인데 물건의 양이 줄어드는 현상이에요. \n"
                + "예를 들어, 가격이 같지만 초콜릿의 크기가 작아지거나 음료수의 용량이 줄어드는 경우죠. 기업들이 가격 인상을 피하면서 양을 줄이는 방법이에요. \n"
                + "'가격'과 '양'의 관계를 이해하면 더 쉽게 알 수 있을 거예요. \n"
                + "경제 개념을 더 공부하면 퀴즈에서 좋은 결과를 얻을 수 있을 거예요!")
            .quizCommentCreatedAt(LocalDateTime.now())
            .build()));
    }
}
