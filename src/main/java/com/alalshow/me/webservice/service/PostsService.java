package com.alalshow.me.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.alalshow.me.domain.posts.PostsRepository;
import com.alalshow.me.dto.posts.PostsMainResponseDto;
import com.alalshow.me.dto.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
    
    @Transactional
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
//        return postsRepository.findAllDesc()
//        		.map(posts -> new PostsMainResponseDto(posts))
//                .collect(Collectors.toList());
        
    }
}