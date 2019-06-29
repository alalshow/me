package com.alalshow.me.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alalshow.me.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {
	
    private PostsService postsService;
    
    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }
    
    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "posts";
    }
}