package com.virtukch.dongiveupbe.multiple_choice_view.service;

import com.virtukch.dongiveupbe.multiple_choice_view.dto.MultipleChoiceViewResponseDto;
import com.virtukch.dongiveupbe.multiple_choice_view.entity.MultipleChoiceView;
import com.virtukch.dongiveupbe.multiple_choice_view.repository.MultipleChoiceViewRepository;
import com.virtukch.dongiveupbe.quiz.repository.QuizRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MultipleChoiceViewService {

    private final MultipleChoiceViewRepository multipleChoiceViewRepository;

    @Autowired
    public MultipleChoiceViewService(MultipleChoiceViewRepository multipleChoiceViewRepository) {
        this.multipleChoiceViewRepository = multipleChoiceViewRepository;
    }

    public ResponseEntity<List<MultipleChoiceViewResponseDto>> findByQuizId(Long quizId) {
        List<MultipleChoiceView> multipleChoiceViewList = multipleChoiceViewRepository.findByQuizId(
            quizId);

        if (multipleChoiceViewList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(multipleChoiceViewRepository.findByQuizId(quizId).stream()
            .map(MultipleChoiceViewResponseDto::fromEntity).toList());
    }
}
