package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.*;
import dao.*;
public class LoginAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		_Login login = new _Login();
		login.setId(request.getParameter("cId"));
		login.setPw(request.getParameter("cpassword"));
		UsersDAO dbPro = new UsersDAO();
		
		boolean loginCheck = dbPro.loginCheck(login.getId(), login.getPw());
		System.out.println("login.getPw() =>"+login.getPw());
		request.setAttribute("loginCheck", loginCheck);
		request.setAttribute("id", login.getId());
		request.setAttribute("loc",dbPro.locNum());
		
		System.out.println("loginCheck =>"+loginCheck + " getId =>" + login.getId() + " getLoc =>" + dbPro.locNum());
		System.out.println("board_no =>"+"status"+"subject"+"board_regdate"+"view"+"board_content");
		return "/index.jsp";
	}

}
