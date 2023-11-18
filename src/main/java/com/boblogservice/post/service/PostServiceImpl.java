package com.boblogservice.post.service;

import com.boblogservice.common.util.ObjectUtil;
import com.boblogservice.member.service.MemberService;
import com.boblogservice.post.dto.PostDto;
import com.boblogservice.post.entity.Post;
import com.boblogservice.post.exception.AccessDeniedForUpdatePostException;
import com.boblogservice.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final MemberService memberService;

    private static final String AECCESS_DENIED_FOR_UPDATE_POST = "게시물 수정 대한 권한이 없습니다.";
    private static final String NOT_FOUND_POST = "게시물이 존재하지 않습니다.";

    @Override
    public void write(PostDto postDto) {
        Post post = Post.from(postDto, memberService.getById(postDto.getMemId()).toEntity());
        postRepository.save(post);
    }

    @Override
    public void modify(PostDto postDto) {
        Post post = ObjectUtil.isNullExceptionElseReturnObJect(postRepository.findById(postDto.getPostId()), "");
        if(!post.getMember().getMemId().equals(postDto.getMemId())) {
            throw new AccessDeniedForUpdatePostException(AECCESS_DENIED_FOR_UPDATE_POST);
        }
        post.updatePost(postDto);
        postRepository.save(post);
    }

    @Override
    public void delete(String postId, String memId) {
        Post post = ObjectUtil.isNullExceptionElseReturnObJect(postRepository.findById(postId), NOT_FOUND_POST);
        if(!post.getMember().getMemId().equals(memId)) {
            throw new AccessDeniedForUpdatePostException(AECCESS_DENIED_FOR_UPDATE_POST);
        }
        postRepository.delete(post);
    }
}
