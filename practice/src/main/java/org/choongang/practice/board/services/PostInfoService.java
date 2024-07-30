package org.choongang.practice.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.practice.board.entities.Post;
import org.choongang.practice.board.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostInfoService {

    private final PostRepository postRepository;

    // 게시글 목록 조회
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    // 게시글 1개 조회
    public Post getPost(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}
