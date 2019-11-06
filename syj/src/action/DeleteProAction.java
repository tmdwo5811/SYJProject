package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.Post;
import dao.BoardDAO;
public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse pesponse) throws Throwable {
		// TODO Auto-generated method stub
		
	    
	      String pageNum=request.getParameter("pageNum");//BoardDTO의 멤버변수가 아니기에
	      //추가
	      int passwd=Integer.parseInt(request.getParameter("passwd"));
	      int num=Integer.parseInt(request.getParameter("num"));
	      System.out.println("deletePro.do의 num=>"
	                                   +num+",passwd=>"+passwd+",pageNum=>"+pageNum);
	      
	      BoardDAO dbPro=new BoardDAO();
	      //select passwd from board where num=?
	      boolean check=dbPro.deleteArticle(num,passwd);//암호찾고->웹상의 암호체크
	      
	      //공유
	      request.setAttribute("pageNum",pageNum);
	      request.setAttribute("check",check);//삭제 
	      
		return "/deletePro.jsp";
	}

}
