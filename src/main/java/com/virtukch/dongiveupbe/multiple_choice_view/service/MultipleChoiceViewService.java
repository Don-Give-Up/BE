package com.virtukch.dongiveupbe.multiple_choice_view.service;

import com.virtukch.dongiveupbe.multiple_choice_view.dto.MultipleChoiceViewRequestDto;
import com.virtukch.dongiveupbe.multiple_choice_view.dto.MultipleChoiceViewResponseDto;
import com.virtukch.dongiveupbe.multiple_choice_view.entity.MultipleChoiceView;
import com.virtukch.dongiveupbe.multiple_choice_view.exception.MultipleChoiceViewNotFoundException;
import com.virtukch.dongiveupbe.multiple_choice_view.repository.MultipleChoiceViewRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultipleChoiceViewService {

    private final MultipleChoiceViewRepository multipleChoiceViewRepository;

    @Autowired
    public MultipleChoiceViewService(MultipleChoiceViewRepository multipleChoiceViewRepository) {
        this.multipleChoiceViewRepository = multipleChoiceViewRepository;
    }

    public List<MultipleChoiceViewResponseDto> findByQuizId(Long quizId) {
        List<MultipleChoiceView> multipleChoiceViewList = multipleChoiceViewRepository.findByQuizId(
            quizId);

        if (multipleChoiceViewList.isEmpty()) {
            throw new MultipleChoiceViewNotFoundException("No views found for quiz id: " + quizId);
        }

        return multipleChoiceViewRepository.findByQuizId(quizId).stream()
            .map(MultipleChoiceViewResponseDto::fromEntity).toList();
    }

    public MultipleChoiceViewResponseDto save(
        MultipleChoiceViewRequestDto multipleChoiceViewRequestDto) {
        return MultipleChoiceViewResponseDto.fromEntity(multipleChoiceViewRepository.save(
            MultipleChoiceViewRequestDto.toEntity(multipleChoiceViewRequestDto)));
    }
}