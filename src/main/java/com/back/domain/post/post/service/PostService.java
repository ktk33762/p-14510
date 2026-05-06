package com.back.domain.post.post.service;

import com.back.domain.post.post.Repository.PostRepository;
import com.back.domain.post.post.enetity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    @Autowired
    private final PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public long count() {
        return postRepository.count();
    }

    public void modify(Post post, String title, String content) {
        boolean isChanged = false;

        if (!post.getTitle().equals(title)) {
            post.setTitle(title);
            isChanged = true;
        }

        if (!post.getContent().equals(content)) {
            post.setContent(content);
            isChanged = true;
        }

        if (isChanged) post.setModifyDate(LocalDateTime.now());

        postRepository.save(post);
    }

    public Post write(String title, String content) {
        Post post = new Post(title, content);

        return postRepository.save(post);
    }
}
