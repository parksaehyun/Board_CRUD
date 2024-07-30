package org.choongang.practice.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.practice.board.controllers.RequestPost;
import org.choongang.practice.board.entities.Post;
import org.choongang.practice.board.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostSaveService {
    private final PostRepository postRepository;

    // 게시글 저장
    public Post save(RequestPost form) {
        Post post = new ModelMapper().map(form, Post.class);

        return postRepository.save(post);
    }
}
