package org.choongang.practice.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.practice.board.controllers.RequestPost;
import org.choongang.practice.board.entities.Post;
import org.choongang.practice.board.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostInfoService {

    private final PostRepository postRepository;

    // 게시글 목록 조회
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    // 게시글 1개 조회(엔티티)
    public Post getPost(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    // 게시글 1개 조회(커맨드객체)
    public RequestPost getForm(Long id) {
        Post post = getPost(id);
        RequestPost requestPost = new ModelMapper().map(post, RequestPost.class);

        return requestPost;
    }

}
