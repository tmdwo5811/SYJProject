package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.CommandAction;
import vo.*;
import java.io.*;
import java.util.Collections;
import java.util.List; 
import java.sql.Timestamp;
import dao.BoardDAO;

//실제로 삭제를 해주면서 deletePro.jsp
public class CommentProAction implements CommandAction {

   @Override
   public String requestPro(HttpServletRequest request,
         HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		// 값을 입력을 받아서 BoardDTO에 저장->테이블에 저장하는 구문

		// 한글처리
		request.setCharacterEncoding("utf-8");
		Post article = new Post();
		Location lo = new Location();
		User user= new User();
		lo.setNo(Integer.parseInt(request.getParameter("location")));
		lo.getNo();
//		article.setNo(Integer.parseInt(request.getParameter("no")));
		article.setLocation(lo);
		article.setContent(request.getParameter("content"));
//		article.setView(Integer.parseInt(request.getParameter("view")));
		article.setSubject(request.getParameter("subject"));
		//article.setStatus((byte) Integer.parseInt(request.getParameter("status")));
		//byte setStatus = (byte) Integer.parseInt(request.getParameter("status"));
		article.setRegdate(new Timestamp(System.currentTimeMillis()));// 작성날짜
		
		article.setUser(User.LOGIN_INFO);
		
		/*
		 * user.setNo(Integer.parseInt(request.getParameter("no"))); user.getNo();
		 * lo.setName(request.getParameter("name")); lo.getName();
		 */
		 
		//article.setContent(request.getParameter("content"));
		BoardDAO dbPro = new BoardDAO();
		dbPro.insertArticle(article);
		System.out.println(article);
		// response.sendRedirect("http://localhost:8090/JspBoard2/list.do");
		return "/commentPro.jsp";
   }
}