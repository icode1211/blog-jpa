package com.estsoft.blogjpa.service;

import com.estsoft.blogjpa.dto.AddArticleRequest;
import com.estsoft.blogjpa.external.ExampleAPIClient;
import com.estsoft.blogjpa.domain.Article;
import com.estsoft.blogjpa.repository.BlogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final ExampleAPIClient apiClient;

    public BlogService(BlogRepository blogRepository, ExampleAPIClient apiClient) {
        this.blogRepository = blogRepository;
        this.apiClient = apiClient;
    }

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found id" + id));
//        return blogRepository.findById(id).orElse(new Article());
    }

    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    public Article update(Long id, AddArticleRequest request) {
        // begin transaction
        Article article = findById(id);
        article.update(request.getTitle(), request.getContent());
        // commit / rollback
        return article;
    }

    @Transactional
    public Article updateTitle(Long id, AddArticleRequest request) {
        Article article = findById(id);
        blogRepository.updateTitle(id, request.getTitle());
        return article;
    }

    public List<Article> saveBulkArticles() {
        List<Article> articles = parsedArticles();
        return blogRepository.saveAll(articles);
    }

    private List<Article> parsedArticles() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        String responseJson = apiClient.fetchDataFromApi(url);

        ObjectMapper objectMapper = new ObjectMapper();
        List<LinkedHashMap<String, String>> jsonMapList = new ArrayList<>();

        try {
            jsonMapList = objectMapper.readValue(responseJson, List.class);
        } catch (JsonProcessingException e) {
            log.error("Failed to parse json", e.getMessage());
        }

        return jsonMapList.stream()
                .map(hashMap -> new Article(hashMap.get("title"), hashMap.get("body")))
                .toList();
    }
}
