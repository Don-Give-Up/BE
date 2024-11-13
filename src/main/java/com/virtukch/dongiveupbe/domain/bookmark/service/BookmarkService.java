package com.virtukch.dongiveupbe.domain.bookmark.service;

import com.virtukch.dongiveupbe.domain.bookmark.dto.BookmarkRequestDto;
import com.virtukch.dongiveupbe.domain.bookmark.dto.BookmarkResponseDto;
import com.virtukch.dongiveupbe.domain.bookmark.entity.Bookmark;
import com.virtukch.dongiveupbe.domain.bookmark.repository.BookmarkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Transactional
    public BookmarkResponseDto save(BookmarkRequestDto requestDto) {
        Bookmark bookmark = Bookmark.builder()
                .memberId(requestDto.getMemberId())
                .quizId(requestDto.getQuizId())
                .build();
        Bookmark saved = bookmarkRepository.save(bookmark);
        return new BookmarkResponseDto(saved);
    }

    @Transactional(readOnly = true)
    public List<BookmarkResponseDto> getBookmarksByMemberId(Long memberId) {
        List<Bookmark> bookmarks = bookmarkRepository.findByMemberId(memberId);
        return bookmarks.stream()
                .map(BookmarkResponseDto::new)
                .toList();
    }

    @Transactional
    public void deleteBookmark(Long bookmarkId) {
        bookmarkRepository.deleteById(bookmarkId);
    }
}
