package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import vo.Page;
import vo.Post;

public interface BoardDAO {
	
	public boolean insertPost(Post post);
	
	public int selectTotal(
			@Param("locationNo") Integer locationNo,
			@Param("expired") Boolean expired,
			@Param("search") String search);
	
	public List<Post> selectPostList(
			@Param("page") Page page,
			@Param("locationNo") Integer locationNo,
			@Param("expired") Boolean expired,
			@Param("search") String search,
			@Param("order") String order);
	
} //interface BoardDAO;
