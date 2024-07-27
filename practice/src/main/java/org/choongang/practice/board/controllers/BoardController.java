package org.choongang.practice.board.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.practice.board.entities.Post;
import org.choongang.practice.board.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final PostRepository postRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);

        return "board/list";
    }

    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable("id") Long id, Model model) {
        postRepository.findById(id).ifPresent(post -> model.addAttribute("post", post));
        //postRepository.findById(id);
        //model.addAttribute("post", postRepository.findById(id));

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
        postRepository.save(post);

        return "redirect:/board/list";
    }
}
