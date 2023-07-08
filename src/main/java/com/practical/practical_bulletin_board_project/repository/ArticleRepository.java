package com.practical.practical_bulletin_board_project.repository;

import com.practical.practical_bulletin_board_project.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}