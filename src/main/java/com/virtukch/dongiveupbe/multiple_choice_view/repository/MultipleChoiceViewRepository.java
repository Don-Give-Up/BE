package com.virtukch.dongiveupbe.multiple_choice_view.repository;

import com.virtukch.dongiveupbe.multiple_choice_view.entity.MultipleChoiceView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultipleChoiceViewRepository extends JpaRepository<MultipleChoiceView, Long> {

    List<MultipleChoiceView> findByQuizId(Long quizId);
}