package com.back.global.intiData;

import com.back.domain.post.post.enetity.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Configuration
public class BaseInData {
    @Autowired
    private final PostService postService;
    private int callCount = 0;

    @Autowired
    @Lazy
    private BaseInData self;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {

            self.work1();
            self.work2();
            new Thread(() -> self.work3()).start();
            self.work4();
        };
    }

    @Transactional
    void work1() {
        if (postService.count() > 0) return;

        Post post1 = postService.write("제목 1", "내용 1");
        Post post2 = postService.write("제목 2", "내용 2");

        System.out.println("post1.getId() : " +  post1.getId());
        System.out.println("post2.getId() : " +  post2.getId());
    }

    @Transactional(readOnly = true)
    void work2() {
        Optional<Post> opPost = postService.findById(1);
        // SELECT * FROM post WHERE id = 1;
        Post post = opPost.get();

        System.out.println("post : " + post);
    }

    @Transactional
    void work3() {
        Optional<Post> opPost = postService.findById(1);
        Post post = opPost.get();

        postService.modify(post, "제목 1 수정", "내용 1 수정");

        Optional<Post> opPost2 = postService.findById(2);
        Post post2 = opPost2.get();

        postService.modify(post2, "제목 2 수정", "내용 2 수정");

    }

    @Transactional
    void work4() {
        Optional<Post> opPost1  = postService.findById(1);
        Post post1 = opPost1.get();

        postService.modify(post1, "제목 1 수정", "내용 1 수정");
    }
}
