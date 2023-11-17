package com.boblogservice.post.controller;

import com.boblogservice.post.dto.PostDto;
import com.boblogservice.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> writePost(@RequestBody @Valid PostDto postDto, BindingResult bindingResult) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "modify post - 글 수정", description = "")
    @PutMapping("")
    public ResponseEntity<Void> modifyPost(@RequestBody @Valid PostDto postDto, BindingResult bindingResult) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "delete post - 글 삭제", description = "")
    @DeleteMapping("")
    public ResponseEntity<Void> deletePost(@RequestParam String postId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "read post by id- 특정 글 조회", description = "")
    @GetMapping("")
    public ResponseEntity<Void> readPostById(@RequestParam String postId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "read post by member - 회원별 글 조회", description = "")
    @GetMapping("")
    public ResponseEntity<Void> readPostByMember(@RequestParam String nickname) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "read post by series - 시리즈 글 조회", description = "")
    @GetMapping("")
    public ResponseEntity<Void> readPostBySeries(@RequestParam String seriesId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
