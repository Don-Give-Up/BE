package com.virtukch.dongiveupbe.multiple_choice_view.dataloader;

import com.virtukch.dongiveupbe.multiple_choice_view.entity.MultipleChoiceView;
import com.virtukch.dongiveupbe.multiple_choice_view.repository.MultipleChoiceViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"localCreate", "devCreate", "prod"})
public class MultipleChoiceViewDataLoader implements CommandLineRunner {

    private final MultipleChoiceViewRepository multipleChoiceViewRepository;

    @Autowired
    public MultipleChoiceViewDataLoader(
        MultipleChoiceViewRepository multipleChoiceViewRepository) {
        this.multipleChoiceViewRepository = multipleChoiceViewRepository;
    }

    // local (ddl-auto: none, DataLoader 작동 X)
    // localCreate (ddl-auto: create, DataLoader 작동 O)
    // dev (ddl-auto: none, DataLoader 작동 X)
    // devCreate (ddl-auto: create, DataLoader 작동 O)
    // prod (ddl-auto: create, DataLoader 작동 O)
    @Override
    public void run(String... args) throws Exception {
        MultipleChoiceView multipleChoiceView1 = MultipleChoiceView.builder()
            .quizId(3L)
            .viewIndex(1)
            .viewContent("김채호")
            .build();
        multipleChoiceViewRepository.save(multipleChoiceView1);

        MultipleChoiceView multipleChoiceView2 = MultipleChoiceView.builder()
            .quizId(3L)
            .viewIndex(2)
            .viewContent("카리나")
            .build();
        multipleChoiceViewRepository.save(multipleChoiceView2);

        MultipleChoiceView multipleChoiceView3 = MultipleChoiceView.builder()
            .quizId(3L)
            .viewIndex(3)
            .viewContent("윈터")
            .build();
        multipleChoiceViewRepository.save(multipleChoiceView3);

        MultipleChoiceView multipleChoiceView4 = MultipleChoiceView.builder()
            .quizId(3L)
            .viewIndex(4)
            .viewContent("닝닝")
            .build();
        multipleChoiceViewRepository.save(multipleChoiceView4);

        MultipleChoiceView multipleChoiceView5 = MultipleChoiceView.builder()
            .quizId(3L)
            .viewIndex(5)
            .viewContent("지젤")
            .build();
        multipleChoiceViewRepository.save(multipleChoiceView5);
    }
}