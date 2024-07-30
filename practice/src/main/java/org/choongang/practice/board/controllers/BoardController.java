package org.choongang.practice.board.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.practice.board.entities.Post;
import org.choongang.practice.board.repositories.PostRepository;
import org.choongang.practice.board.services.PostInfoService;
import org.choongang.practice.board.services.PostSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final PostInfoService postInfoService;
    private final PostSaveService postSaveService;

    // 게시글 목록 조회
    @GetMapping("/list")
    public String list(Model model) {
        List<Post> posts =  postInfoService.getPosts();
        model.addAttribute("posts", posts);

        return "board/list";
    }

    // 게시글 1개 조회
    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable("id") Long id, Model model) {
        Post post =  postInfoService.getPost(id);
        model.addAttribute("post", post);

        return "board/post";
    }

    // 게시글 작성
    @GetMapping("/write")
    public String writePost(Model model) {
        model.addAttribute("post", new Post());

        return "board/write";
    }

    // 게시글 수정
    @GetMapping("/update/{id}")
    public String editPost(@PathVariable("id") Long id, Model model) {

        return "board/update";
    }


    // 게시글 저장✨
    @PostMapping("/save")
    public String savePost(@ModelAttribute Post post) {
        postSaveService.save(post);

        return "redirect:/board/list";
    }
}
