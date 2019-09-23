package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;

public class MainAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		UsersDAO usersDao = new UsersDAO();
		
//		테스트용 코드
//		usersDao.insertUser(null, null, null);
		usersDao.selectUser();
		
		return "/index.jsp";
		
	} //requestPro();
	
} //class MainAction;
