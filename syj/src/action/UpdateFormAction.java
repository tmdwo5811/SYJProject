package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//추가
import dao.*;
import vo.*;
public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse pesponse) throws Throwable {
		// TODO Auto-generated method stub

		//content.jsp->글수정버튼 클릭->updateForm.jsp?num=3&pageNum=1
		int no=Integer.parseInt(request.getParameter("no"));
		String pageNum=request.getParameter("pageNum");
		BoardDAO dbPro=new BoardDAO();
		Post article=dbPro.updateGetArticle(no);//조회수가 증가X
		
		//2.서버의 메모리 저장
		request.setAttribute("pageNum",pageNum);
		request.setAttribute("article",article);
		
		return "/updateForm.jsp";
	}

}
