package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.dto.ArticleViewResponse;
import com.estsoft.blogjpa.model.Article;
import com.estsoft.blogjpa.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class BlogPageController {
    private final BlogService blogService;

    public BlogPageController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<Article> articles = blogService.findAll();
        model.addAttribute("articles", articles);
        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String showArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", article.toViewResponse());
        return "article";
    }

    @GetMapping("/new-article")  // /new-articles?id={id} (수정)   /new-articles  (등록)
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        log.info("id={}", id);
        if (id == null) {  // 등록
            model.addAttribute("article", new ArticleViewResponse());
        } else {  // 수정
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }
}
