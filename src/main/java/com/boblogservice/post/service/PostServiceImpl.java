package com.boblogservice.post.service;

import com.boblogservice.common.util.ObjectUtil;
import com.boblogservice.member.dto.MemberDto;
import com.boblogservice.member.entity.Member;
import com.boblogservice.member.service.MemberService;
import com.boblogservice.post.dto.PostDto;
import com.boblogservice.post.entity.Post;
import com.boblogservice.post.exception.AccessDeniedForUpdatePostException;
import com.boblogservice.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final MemberService memberService;

    private static final String ACCESS_DENIED_FOR_UPDATE_POST = "게시물 수정 대한 권한이 없습니다.";
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
            throw new AccessDeniedForUpdatePostException(ACCESS_DENIED_FOR_UPDATE_POST);
        }
        post.updatePost(postDto);
        postRepository.save(post);
    }

    @Override
    public void delete(String postId, String memId) {
        Post post = ObjectUtil.isNullExceptionElseReturnObJect(postRepository.findById(postId), NOT_FOUND_POST);
        if(!post.getMember().getMemId().equals(memId)) {
            throw new AccessDeniedForUpdatePostException(ACCESS_DENIED_FOR_UPDATE_POST);
        }
        postRepository.delete(post);
    }

    @Override
    public PostDto getById(String postId) {
        return ObjectUtil.isNullExceptionElseReturnObJect(postRepository.findById(postId), NOT_FOUND_POST).toDto();
    }

    @Override
    public Map<String, List<PostDto>> getByNickname(String nickname) {
        return Map.of("notTmp", getByNicknameNotTmp(nickname), "tmp", getByNicknameTmp(nickname));
    }

    @Override
    public void writeTmp(PostDto postDto) {
        Post post;
        try {
            post = ObjectUtil.isNullExceptionElseReturnObJect(postRepository.findById(postDto.getPostId()), "");
            if(!post.getMember().getMemId().equals(postDto.getMemId())) {
                throw new AccessDeniedForUpdatePostException(ACCESS_DENIED_FOR_UPDATE_POST);
            }
        } catch(Exception e) {
            post = Post.from(postDto, memberService.getById(postDto.getMemId()).toEntity());
        }
        post.updatePostTmp(postDto);
        postRepository.save(post);
    }

    @Override
    public List<PostDto> getByNicknameNotTmp(String nickname) {
        return postRepository.findByMemberAndTmpYnIsFalse(memberService.getByNickname(nickname).toEntity()).stream().map(Post::toDto).toList();
    }

    @Override
    public List<PostDto> getByNicknameTmp(String nickname) {
        return postRepository.findByMemberAndTmpYnIsTrue(memberService.getByNickname(nickname).toEntity()).stream().map(Post::toDto).toList();
    }
}
