package com.practical.practical_bulletin_board_project.dto.request;


import com.practical.practical_bulletin_board_project.dto.ArticleDto;
import com.practical.practical_bulletin_board_project.dto.HashtagDto;
import com.practical.practical_bulletin_board_project.dto.UserAccountDto;

import java.util.Set;

public record ArticleRequest(
        String title,
        String content
) {

    public static ArticleRequest of(String title, String content) {
        return new ArticleRequest(title, content);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto) {
        return toDto(userAccountDto, null);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto, Set<HashtagDto> hashtagDtos) {
        return ArticleDto.of(
                userAccountDto,
                title,
                content,
                hashtagDtos
        );
    }

}
