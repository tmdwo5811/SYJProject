package action;

import javax.servlet.http.*;
import java.sql.*;

import vo.Answer;
import vo.Post;

public class AnswerWriteFormAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
//		int no = 0;
//		Post post = new Post();
//		String content;
//		Timestamp regdate;
		
		Answer answer = new Answer();
		answer.setPost(new Post());
		
		if(request.getParameter("no")!=null) {
			answer.setNo(Integer.parseInt(request.getParameter("no")));
			answer.getPost().setNo(Integer.parseInt(request.getParameter("post")));
			answer.setContent(request.getParameter("content"));
		}
		request.setAttribute("answer", answer);
		
		//${answer.post.no}
		
		return null;
	}
}
