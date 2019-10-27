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
		

        request.setCharacterEncoding("UTF-8");
		int num=Integer.parseInt(request.getParameter("num"));
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		String content = request.getParameter("content");
		String User = request.getParameter("User");

		//CommentForm commentForm=(CommentForm)form;
		Comment comment = new Comment();
		User user=new User();
		//PropertyUtils.copyProperties(comment,commentForm);
		//메서드 호출
	    comment.setNo(Integer.parseInt(request.getParameter("no")));
	    user.setNo(Integer.parseInt(request.getParameter("No")));
	    comment.setContent(request.getParameter("content"));
	    comment.setRegdate(new Timestamp(System.currentTimeMillis()));				
		BoardDAO manager= new BoardDAO();
		manager.addComment(comment);
	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();  
		out.println("<script language='javascript'>");  
		out.println("location.href = \"../board1/content.do?num="+num+"&pageNum="+pageNum+"\";");  
		out.println("</script>");  

		return "/comment.do";
	}
}
