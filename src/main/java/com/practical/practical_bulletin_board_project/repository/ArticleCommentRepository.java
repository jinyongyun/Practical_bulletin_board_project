package com.practical.practical_bulletin_board_project.repository;

import com.practical.practical_bulletin_board_project.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}
