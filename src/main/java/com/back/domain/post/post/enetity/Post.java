package com.back.domain.post.post.enetity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // 아래 구조대로 DB 테이블(컬럼)을 만들어야 한다.
public class Post {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private int id; // INT
    private String title; // VARCHAR(255)
}
