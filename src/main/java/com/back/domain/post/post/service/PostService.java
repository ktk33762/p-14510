package com.back.domain.post.post.service;

import com.back.domain.member.member.entity.Member;
import com.back.domain.post.post.Repository.PostRepository;
import com.back.domain.post.post.enetity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        post.setTitle(title);
        post.setContent(content);

        // postRepository.save(post);
    }

    public Post write(Member author, String title, String content) {
        Post post = new Post(author, title, content);

        return postRepository.save(post);
    }
}
