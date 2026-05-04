package com.back.domain.post.post.Repository;

import com.back.domain.post.post.enetity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
