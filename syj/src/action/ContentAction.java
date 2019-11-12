package action;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

import vo.Post;


public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse pesponse) throws Throwable {
		int no=Integer.parseInt(request.getParameter("no"));
		String pageNum=request.getParameter("pageNum");

		//추가(검색분야,검색어)
		
		List articleList=null;//화면에 출력할 레코드를 저장할변수
		BoardDAO dbPro=new BoardDAO();
		Post article=dbPro.getArticle(no);
		
		System.out.println("게시글 번호 받아오는지 체크! =>" + no);
		
		//2.처리한 결과를 공유(서버 메모리에 저장)->이동할 페이지에 공유해서 사용
		//request.setAttribute("currentPage"(키명))=>${키명}
		request.setAttribute("no", no);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		
	    
		//3.공유해서 이동할 수있도록 페이지를 지정
		return "/comment.jsp";
	}

}
