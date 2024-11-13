package com.virtukch.dongiveupbe.domain.bookmark.dto;

import com.virtukch.dongiveupbe.domain.bookmark.entity.Bookmark;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookmarkResponseDto {
    private Long bookmarkId;

    private Long memberId;

    private Long quizId;

    public BookmarkResponseDto(Bookmark bookmark) {
        this.bookmarkId = bookmark.getBookmarkId();
        this.memberId = bookmark.getMemberId();
        this.quizId = bookmark.getQuizId();
    }

}
