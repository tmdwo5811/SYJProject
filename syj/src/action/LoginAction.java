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
		login.setPasswordWithEncrypt(request.getParameter("cpassword"));
		UsersDAO dbPro = new UsersDAO();
		boolean loginCheck = dbPro.loginCheck(login.getId(), login.getPw());
		System.out.println("login.getPw() =>"+login.getPw());
		request.setAttribute("loginCheck", loginCheck);
		request.setAttribute("id", login.getId());
		
		System.out.println("loginCheck =>"+loginCheck + " getId =>" + login.getId());
		
		return "/LoginProc.jsp";
	}

}
