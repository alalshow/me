package com.alalshow.me.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		/**
		이후 테스트 코드에 영향을 끼치지 않기 위해
		테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
		**/
		postsRepository.deleteAll();
	}
	
	@Test
	public void 게시글_저장() {
		//given
		postsRepository.save(Posts.builder()
		.title("테스트 게시글")
		.content("테스트 본문")
		.author("alalshow211@gmail.com")
		.build());
		
	}
	
	@Test
	public List<Posts> 게시글_불러오기() {
//		게시글저장_불러오기();
		System.out.println("---게시글_불러오기---");
		List<Posts> postsList = postsRepository.findAll();
		System.out.println("---게시글_사이즈:---" + postsList.size());
		postsList.stream().forEach((c) -> System.out.println(c.toString()));
		return postsList;
		
	}
	
	@Test
	public void 게시글저장_불러오기() {
		System.out.println("게시글저장_불러오기");
		//given
		게시글_저장();
		//when
		List<Posts> postsList = 게시글_불러오기();
		
		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("테스트 게시글"));
		assertThat(posts.getContent(), is("테스트 본문"));
	}
}