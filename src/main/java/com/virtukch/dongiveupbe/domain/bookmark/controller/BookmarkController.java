package com.virtukch.dongiveupbe.domain.bookmark.controller;

import com.virtukch.dongiveupbe.domain.bookmark.dto.BookmarkRequestDto;
import com.virtukch.dongiveupbe.domain.bookmark.dto.BookmarkResponseDto;
import com.virtukch.dongiveupbe.domain.bookmark.service.BookmarkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookmarks")
@Tag(name = "북마크 API", description = "북마크 생성, 조회, 삭제 API")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @PostMapping
    @Operation(summary = "북마크 생성", description = "주어진 퀴즈 ID와 멤버 ID를 통해 북마크를 생성합니다.")
    @ApiResponse(responseCode = "200", description = "북마크 생성 성공")
    public ResponseEntity<BookmarkResponseDto> createBookmark(@RequestBody BookmarkRequestDto requestDto) {
        BookmarkResponseDto responseDto = bookmarkService.save(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/member/{memberId}")
    @Operation(summary = "멤버별 북마크 조회", description = "특정 멤버 ID를 사용하여 북마크 리스트를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "멤버의 북마크 조회 성공")
    public ResponseEntity<List<BookmarkResponseDto>> getBookmarksByMemberId(@PathVariable Long memberId) {
        List<BookmarkResponseDto> bookmarks = bookmarkService.getBookmarksByMemberId(memberId);
        return ResponseEntity.ok(bookmarks);
    }

    @DeleteMapping("/{bookmarkId}")
    @Operation(summary = "북마크 삭제", description = "북마크 ID를 사용하여 특정 북마크를 삭제합니다.")
    @ApiResponse(responseCode = "200", description = "북마크 삭제 성공")
    public ResponseEntity<Void> deleteBookmark(@PathVariable Long bookmarkId) {
        bookmarkService.deleteBookmark(bookmarkId);
        return ResponseEntity.ok().build();
    }
}
