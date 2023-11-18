package com.boblogservice.post.service;

import com.boblogservice.post.dto.PostDto;

import java.util.List;

public interface PostService {
    void write(PostDto postDto);

    void modify(PostDto postDto);

    void delete(String postId, String memId);

    PostDto getById(String postId);

    List<PostDto> getByNickname(String nickname);
}
