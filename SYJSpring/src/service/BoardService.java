package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDAO;
import vo.Page;
import vo.Post;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public boolean writePost(Post post) { return boardDAO.insertPost(post); }
	
	public List<Post> getPostList(Page page) {
		page.initTotal(boardDAO.selectTotal());
		return boardDAO.selectPostList(page);
	} //getPostList();
	
} //class BoardService;
