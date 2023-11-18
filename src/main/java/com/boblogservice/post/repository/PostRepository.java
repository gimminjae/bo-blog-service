package com.boblogservice.post.repository;

import com.boblogservice.post.entity.Post;

import java.util.Optional;

public interface PostRepository {
    Post save(Post post);

    Optional<Post> findById(String postId);

    void delete(Post post);
}
