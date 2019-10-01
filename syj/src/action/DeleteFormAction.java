package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse pesponse) throws Throwable {
		// TODO Auto-generated method stub
		
		//conent.jsp->삭제버튼->deleteForm.jsp?num=@&pageNum=1->deletePro.jsp(deleteArticle)
		int no=Integer.parseInt(request.getParameter("no"));//메서드의 매개변수때문에 매개변수때문에
		String pageNum=request.getParameter("pageNum");//삭제된 게시물이 있는 페이지로 이동
		System.out.println("deleteForm.jsp의 num=>"+no+", pageNum=>"+pageNum);
		
		request.setAttribute("no",no);//삭제할 게시물번호
		request.setAttribute("pageNum",pageNum);
		
		return "/deleteForm.jsp";
	}

}
