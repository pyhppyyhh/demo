package com.example.demo2.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }

    /*코드 설명
    *
    * @RequestParam
    * :외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    *
    * @Getter
    * :선언된 모든 필드의 get메소드를 생성해 줍니다.
    *
    * @RequiredArgsConstructor
    * :선언된 모든 final 필드가 포함된 생성자를 생성해줍니다.
    * :final이 없는 필드는 생성자에 포함하지 않습니다.
    * */
}
