package com.example.demo2.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        String hello = "Hello World";

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    public void helloDtoReturn() throws Exception {
        String name = "hello";
        int amount = 1000;

        mockMvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


    }

    /*
    * 코드 설명
    * @ExtendWith
    * : 책에서는 @RunWith로 알려주지만 이제 ExtendWith 또는 SpringBootTest 사용한다고 한다.
    *   기능은 별차이가 없다고 하며 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다고 한다.
    *   즉, 스프링 부트 테스트와 JUnit 사이에 연결 역할을 한다.
    *
    * @WebMvcTest
    * : Web(Spring MVC)에 집중할 수있는 어노테이션
    *
    * @Authwired
    * : 스프링이 관리하는 빈(bean)을 주입 받는 어노테이션
    *
    * private MockMvc mvc
    * : 이 클래스를 통해 HTTP GET,POST 등에 대한 API 테스트를 할수있음.
    *
    * mvc.perform(get("/hello"))
    * : MockMvc를 통해 /hello 주소로 HTTP GET요청을 수행함.
    *
    * .andExpect(status().isOK())
    * : mvc.perform의 결과를 검증. 해당소스에서는 HTTP header의 Status가 200인지 확인.
    *
    * .andExpect(content().string("Hello World"))
    * : Controller에서 "Hello World"를 리턴하며 해당 리턴값이 맞는지 검증하는 역활
    * */


}
