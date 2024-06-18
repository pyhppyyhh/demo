package com.example.demo2.web.dto;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void test() {

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

        /*코드 설명
        *
        * assertThat
        * :assertj라는 테스트 점증 라이브러리의 검증메소드
        * :검증하려는 대상의 메소드를 인자로 받음
        *
        * isEqualTo
        * :assertj의 동등 비교 메소드
        * :assertThat에 있는 값과 isEqualTo의 값을 비교해 같을떄만 성공
        * */

    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
