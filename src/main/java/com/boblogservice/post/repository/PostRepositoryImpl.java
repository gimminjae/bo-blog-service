package com.boblogservice.post.repository;

import com.boblogservice.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryImpl extends PostRepository, JpaRepository<Post, String> {
}
