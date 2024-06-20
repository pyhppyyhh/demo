package com.example.demo2.domain.posts;

import com.example.demo2.web.dto.PostsSaveRequstDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequstDto requstDto) {
        return postsRepository.save(requstDto.toEntity()).getId();
    }
}

/*
* Lombok 기능
* @RequiredArgsConstructor
* : final로 선언된 모든 필드를 인자값으로 하는 생성자를 생성해줍니다.
* */
