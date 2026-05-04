package com.back.domain.post.post.service;

import com.back.domain.post.post.Repository.PostRepository;
import com.back.domain.post.post.enetity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public long count() {
        return postRepository.count();
    }
}
