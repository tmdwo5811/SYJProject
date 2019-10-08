package dao;

import java.util.List;

import vo.Page;
import vo.Post;

public interface BoardDAO {
	
	public boolean insertPost(Post post);
	
	public int selectTotal();
	public List<Post> selectPostList(Page page);
	
} //interface BoardDAO;
