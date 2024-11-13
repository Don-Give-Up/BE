package com.virtukch.dongiveupbe.domain.bookmark.repository;

import com.virtukch.dongiveupbe.domain.bookmark.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    List<Bookmark> findByMemberId(Long memberId);

}
