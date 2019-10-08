package controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.BoardService;
import vo.Page;
import vo.Post;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostConstruct
	public void constructor() {
		
		for(int i = 1; i <= 15; i++) {
			
			Page page = new Page(i, 5, 6);
			List<Post> postList = boardService.getPostList(page);
			
			System.out.println("Page" + i);
			System.out.println(page);
			
			for(Post post : postList)
				System.out.println(post);
			System.out.println();
			
		}
		
	} //constructor();
	
} //class BoardController;
