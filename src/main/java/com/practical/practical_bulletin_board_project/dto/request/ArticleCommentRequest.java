package com.practical.practical_bulletin_board_project.dto.request;


import com.practical.practical_bulletin_board_project.dto.ArticleCommentDto;
import com.practical.practical_bulletin_board_project.dto.UserAccountDto;

public record ArticleCommentRequest(Long articleId, String content) {

    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }

}
