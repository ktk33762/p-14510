package com.back.global.intiData;

import com.back.domain.post.post.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

public class BaseInData {
    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {

            postRepository.count();
            // SELECT * FROM post;
        };
    }
}
