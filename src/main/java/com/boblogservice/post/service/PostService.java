package com.boblogservice.post.service;

import com.boblogservice.post.dto.PostDto;

import java.util.List;
import java.util.Map;

public interface PostService {
    void write(PostDto postDto);

    void modify(PostDto postDto);

    void delete(String postId, String memId);

    PostDto getById(String postId);

    Map<String, List<PostDto>> getByNickname(String nickname);

    void writeTmp(PostDto postDto);

    List<PostDto> getByNicknameNotTmp(String nickname);

    List<PostDto> getByNicknameTmp(String nickname);
}
