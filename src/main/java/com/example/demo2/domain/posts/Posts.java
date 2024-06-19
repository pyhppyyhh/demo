package com.example.demo2.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Length;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /*코드설명
     * @Entity
     * :테이블과 링크될 클래스임을 나타냅니다. (기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블이름을 매핑)
     *
     * @Id
     * :해당 테이블의 PK필드를 나타냅니다.
     *
     * @GeneratedValue
     * :PK생성 규칙을 나타냅니다.
     *
     * @Column
     * :테이블의 컬럼을 나타내며 굳이 선언하지않아도 해당 클래스의 필드는 모두 컬럼이 됩니다.
     *
     * @
     * */
}


