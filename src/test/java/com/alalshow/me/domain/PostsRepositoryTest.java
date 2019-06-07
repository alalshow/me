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
		���� �׽�Ʈ �ڵ忡 ������ ��ġ�� �ʱ� ����
		�׽�Ʈ �޼ҵ尡 ������ ���� respository ��ü ���� �ڵ�
		**/
		postsRepository.deleteAll();
	}
	
	@Test
	public void �Խñ�_����() {
		//given
		postsRepository.save(Posts.builder()
		.title("�׽�Ʈ �Խñ�")
		.content("�׽�Ʈ ����")
		.author("alalshow211@gmail.com")
		.build());
		
	}
	
	@Test
	public List<Posts> �Խñ�_�ҷ�����() {
//		�Խñ�����_�ҷ�����();
		System.out.println("---�Խñ�_�ҷ�����---");
		List<Posts> postsList = postsRepository.findAll();
		System.out.println("---�Խñ�_������:---" + postsList.size());
		postsList.stream().forEach((c) -> System.out.println(c.toString()));
		return postsList;
		
	}
	
	@Test
	public void �Խñ�����_�ҷ�����() {
		System.out.println("�Խñ�����_�ҷ�����");
		//given
		�Խñ�_����();
		//when
		List<Posts> postsList = �Խñ�_�ҷ�����();
		
		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("�׽�Ʈ �Խñ�"));
		assertThat(posts.getContent(), is("�׽�Ʈ ����"));
	}
}