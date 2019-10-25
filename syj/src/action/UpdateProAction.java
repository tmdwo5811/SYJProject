package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 글쓰기폼(writeForm.jsp에서 글쓰기 버튼을 누른경우)
//추가
import vo.*;
import dao.*;
import java.sql.Timestamp;//추가할 부분(시간)

public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//값을 입력을 받아서 BoardDTO에 저장->테이블에 저장하는 구문
		
	     //한글처리
		request.setCharacterEncoding("utf-8");
		//추가
		String pageNum=request.getParameter("pageNum");
		
	     Post article=new Post();//데이터 담을 객체
	   
	     article.setNo(Integer.parseInt(request.getParameter("no")));
	     article.setContent(request.getParameter("Content"));
	     article.setNo(Integer.parseInt(request.getParameter("user")));
	     article.setSubject(request.getParameter("subject"));
	     article.setLocation(new Location(Integer.parseInt(request.getParameter("location"))));
	     
	      BoardDAO dbPro=new BoardDAO();
	      int check=dbPro.updateArticle(article);
	      //response.sendRedirect("http://localhost:8090/JspBoard2/list.do");
	      
	      //2개의 공유값이 필요
	      request.setAttribute("pageNum",pageNum);//수정할 페이지로 이동
	      request.setAttribute("check",check);//데이터 수정성공유무
	      
		return "/updatePro.jsp";
	}
}

