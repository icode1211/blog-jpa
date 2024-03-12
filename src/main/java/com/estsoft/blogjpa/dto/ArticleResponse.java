package com.estsoft.blogjpa.dto;

import com.estsoft.blogjpa.model.Article;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponse {
    private String title;
    private String content;

    public ArticleResponse(Article article) {
        title = article.getTitle();
        content = article.getContent();
    }
}
