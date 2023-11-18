package com.boblogservice.post.controller;

import com.boblogservice.common.validation.ValidationUtil;
import com.boblogservice.member.entity.AuthUser;
import com.boblogservice.post.dto.PostDto;
import com.boblogservice.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Tag(name = "PostController API", description = "post")
@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    @Operation(summary = "create post - 글 작성", description = "")
    @PostMapping("")
    @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<Void> writePost(@AuthenticationPrincipal AuthUser authUser, @RequestBody @Valid PostDto postDto, BindingResult bindingResult) {
        ValidationUtil.confirmError(bindingResult);

        postDto.setMemId(authUser.getMemId());
        postDto.setMemName(authUser.getNickname());
        postService.write(postDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "modify post - 글 수정", description = "")
    @PutMapping("")
    @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<Void> modifyPost(@AuthenticationPrincipal AuthUser authUser, @RequestBody @Valid PostDto postDto, BindingResult bindingResult) {
        ValidationUtil.confirmError(bindingResult);

        postDto.setMemId(authUser.getMemId());
        postDto.setMemName(authUser.getNickname());
        postService.modify(postDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "delete post - 글 삭제", description = "")
    @DeleteMapping("")
    @PreAuthorize("hasAnyAuthority('MEMBER')")
    public ResponseEntity<Void> deletePost(@AuthenticationPrincipal AuthUser authUser, @RequestParam String postId) {
        postService.delete(postId, authUser.getMemId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "read post by id- 특정 글 조회", description = "")
    @GetMapping("/{postId}")
    public ResponseEntity<Void> readPostById(@PathVariable String postId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "read post by member - 회원별 글 조회", description = "")
    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<Void> readPostByMember(@RequestParam String nickname) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "read post by series - 시리즈 글 조회", description = "")
    @GetMapping("")
    public ResponseEntity<Void> readPostBySeries(@RequestParam String seriesId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
