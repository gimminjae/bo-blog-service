package com.boblogservice.post.repository;

import com.boblogservice.member.entity.Member;
import com.boblogservice.post.entity.Post;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);

    Optional<Post> findById(String postId);

    void delete(Post post);

    List<Post> findByMember(Member member);
}
