package com.virtukch.dongiveupbe.multiple_choice_view.dataloader;

import com.virtukch.dongiveupbe.multiple_choice_view.entity.MultipleChoiceView;
import com.virtukch.dongiveupbe.multiple_choice_view.repository.MultipleChoiceViewRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MultipleChoiceViewDataLoader implements CommandLineRunner {

    private final MultipleChoiceViewRespository multipleChoiceViewRespository;

    @Autowired
    public MultipleChoiceViewDataLoader(
        MultipleChoiceViewRespository multipleChoiceViewRespository) {
        this.multipleChoiceViewRespository = multipleChoiceViewRespository;
    }

    @Override
    public void run(String... args) throws Exception {
        MultipleChoiceView multipleChoiceView1 = MultipleChoiceView.builder()
            .quizId(3L)
            .viewIndex(1)
            .viewContent("김채호")
            .build();
        multipleChoiceViewRespository.save(multipleChoiceView1);

        MultipleChoiceView multipleChoiceView2 = MultipleChoiceView.builder()
            .quizId(3L)
            .viewIndex(2)
            .viewContent("카리나")
            .build();
        multipleChoiceViewRespository.save(multipleChoiceView2);

        MultipleChoiceView multipleChoiceView3 = MultipleChoiceView.builder()
            .quizId(3L)
            .viewIndex(3)
            .viewContent("윈터")
            .build();
        multipleChoiceViewRespository.save(multipleChoiceView3);

        MultipleChoiceView multipleChoiceView4 = MultipleChoiceView.builder()
            .quizId(3L)
            .viewIndex(4)
            .viewContent("닝닝")
            .build();
        multipleChoiceViewRespository.save(multipleChoiceView4);

        MultipleChoiceView multipleChoiceView5 = MultipleChoiceView.builder()
            .quizId(3L)
            .viewIndex(5)
            .viewContent("지젤")
            .build();
        multipleChoiceViewRespository.save(multipleChoiceView5);
    }
}