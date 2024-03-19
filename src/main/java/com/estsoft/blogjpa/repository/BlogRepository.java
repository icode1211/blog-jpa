package com.estsoft.blogjpa.repository;

import com.estsoft.blogjpa.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
    // JPQL = Java Persistence Query Language    id, title
    @Modifying
    @Query("update Article set title = :title where id = :id")
    void updateTitle(Long id, String title);
}
