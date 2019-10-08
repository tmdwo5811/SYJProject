package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// /writeForm.do
public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
	       //list.jsp(글쓰기)->신규글 ,content.jsp(글상세보기)->글쓰기->답변글
	       int no=0,ref=1,re_step=0,view=0;//writePro.jsp(신규글)
	       
	       //content.do에서 매개변수가 전달
	       if(request.getParameter("no")!=null){ //0은 아니고, 음수X ->양수 1이상
	    	   no=Integer.parseInt(request.getParameter("no"));//"3"->3
	    	   view=Integer.parseInt(request.getParameter("view"));
	    	   System.out.println("content.jsp에서 넘어온 매개변수 확인");
	    	   System.out.println("no=>"+no+",view="+view);
	       }
	      //실행결과->서버의 메모리에 저장
	       request.setAttribute("no", no);
	       request.setAttribute("view", view);	
	  
		return "/writeForm.jsp";

	}

}