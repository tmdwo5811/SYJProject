package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.*;
import dao.*;

public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse pesponse) throws Throwable {
		// TODO Auto-generated method stub
		//1.content.jsp가 처리해야할 내용을 대신 처리
		
		//글상세보기=>상품의 정보를 자세히(SangDetail.jsp)
		int no=Integer.parseInt(request.getParameter("no"));
		String pageNum=request.getParameter("pageNum");
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		BoardDAO dbPro=new BoardDAO();
		Post article=dbPro.getArticle(no);//select * from board where no=?
		
		int view=article.getView();

		System.out.println("content.do의 매개변수확인");
		System.out.println("view"+view);

		//2.처리결과를 메모리에 저장
		request.setAttribute("no", no);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		
		
		return "/content.jsp";
	}

}
