package com.alalshow.me.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alalshow.me.dto.posts.PostsSaveRequestDto;
import com.alalshow.me.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MeRestController {

    private PostsService postsService;

	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
	
	@GetMapping("/helloBk")
	public String helloBk() {
		return "helloBk";
	}

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }
}
