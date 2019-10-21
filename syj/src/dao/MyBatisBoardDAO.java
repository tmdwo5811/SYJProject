package dao;

import vo.User;

public interface MyBatisBoardDAO {
	
	/***************************************************************
	 * try(SqlSession session = SessionUtil.getSession()) {        *
	 *		BoardDAO boardDAO = session.getMapper(BoardDAO.class); *
	 *		boardDAO.selectUser(1);                                *
	 *	}                                                          *
	 ***************************************************************/
	
	public User selectUser(int no);
	
} //interface BoardDAO;
