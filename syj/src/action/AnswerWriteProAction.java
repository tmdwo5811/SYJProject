package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import vo.*;
import java.util.*;
import java.sql.*;

public class AnswerWriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//테이블에 저장
		//한글처리
		
		request.setCharacterEncoding("utf-8");
		Answer ans = new Answer();
		Post post = new Post();
		_Login _loguser = new _Login();
		
		post.setNo(Integer.parseInt(request.getParameter("no")));
		_loguser.setId(request.getParameter("id"));
		
		ans.setNo(Integer.parseInt(request.getParameter("no")));
		ans.setPost(post);
		ans.setId(_loguser);
		ans.setContent(request.getParameter("content"));
		ans.setRegdate();
		return null;
	
}
}
