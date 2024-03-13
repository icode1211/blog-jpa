package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.model.Article;
import com.estsoft.blogjpa.service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonParseTestController {
    private final BlogService blogService;

    public JsonParseTestController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/api/test")
    public List<Article> test() {
        return blogService.saveBulkArticles();
    }
}
