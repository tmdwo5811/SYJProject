package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDAO;
import vo.Page;
import vo.Post;

@Service
public class BoardService {
	
	public static final String
			ORDER_RECOMMEND = "view DESC, regdate",
			ORDER_COMMENT = "commentCount DESC, regdate DESC",
			ORDER_REGDATE = "regdate DESC";
	
	@Autowired
	private BoardDAO boardDAO;
	
	public boolean writePost(Post post) { return boardDAO.insertPost(post); }
	
	public List<Post> getPostList(Page page, Integer locationNo, Boolean expired, String search, String order) {
		page.initTotal(boardDAO.selectTotal(locationNo, expired, search));
		return boardDAO.selectPostList(page, locationNo, expired, search, order);
	}
	
} //class BoardService;
