package com.back.domain.post.post.enetity;

import com.back.global.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@EntityListeners(AuditingEntityListener.class) // Auditing 기능 활성화
@Getter
@Setter
@Entity
@NoArgsConstructor// 아래 구조대로 DB 테이블(컬럼)을 만들어야 한다.
public class Post extends BaseEntity {
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
