package com.virtukch.dongiveupbe.domain.article.repository;

import com.virtukch.dongiveupbe.domain.article.entity.Article;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByArticleTitle(String articleTitle);

    List<Article> findByMemberId(Long memberId);
}