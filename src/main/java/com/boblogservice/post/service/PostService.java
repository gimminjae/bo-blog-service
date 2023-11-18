package com.boblogservice.post.service;

import com.boblogservice.post.dto.PostDto;

public interface PostService {
    void write(PostDto postDto);

    void modify(PostDto postDto);

    void delete(String postId, String memId);
}
