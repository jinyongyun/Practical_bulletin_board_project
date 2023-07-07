package com.practical.practical_bulletin_board_project.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;
    private Article article; //게시글 (ID)
    private String content; // 본문

    private LocalDateTime createAt; // 생성일시
    private String createBy; //생성자
    private LocalDateTime modifiedAt; //수정일시
    private String modifiedBy; //수정자

}