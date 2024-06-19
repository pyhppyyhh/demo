package com.example.demo2.domain.posts;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void load() {
        String title = "TEST";
        String content ="TEST1111";



        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("123@123")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    /*코드설명
    * @AfterEach
    * : 기존의 @After 어노테이션과 동일한 기능을 하며, Junit에서 단위 테스트가 끝날때마다 수행되는 메소드를 지정해준다
    *
    * postsRepository.save
    * : 테이블 posts에 insert/update 쿼리를 실행해준다.
    *   id값이 있다면 update 없다면 insert 쿼리를 실행한다.
    *
    * postsRepository.findAll()
    * : 테이블의 모든 데이터를 조회해오는 메소드
    *
    *
    *
    * */
}
