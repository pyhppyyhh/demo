package com.example.demo2.web;

import com.example.demo2.domain.posts.PostsService;
import com.example.demo2.web.dto.PostsSaveRequstDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequstDto requstDto) {
        return postsService.save(requstDto);
    }
}
