package com.virtukch.dongiveupbe.domain.bookmark.dto;

import com.virtukch.dongiveupbe.domain.bookmark.entity.Bookmark;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookmarkRequestDto {
    private Long memberId;

    private Long quizId;

    public Bookmark toEntity() {
        return Bookmark.builder()
                .memberId(this.memberId)
                .quizId(this.quizId)
                .build();
    }
}
