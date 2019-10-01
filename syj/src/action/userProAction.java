package action;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.*;
import dao.*;
public class userProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		User article = new User();
		
	     Enumeration<String> params = request.getParameterNames(); 
	        while(params.hasMoreElements()){
	         String paramName = params.nextElement();
	         System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
	        }
	        
		
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setPasswd(request.getParameter("passwd"));
		
		article.setReg_date(new Timestamp(System.currentTimeMillis())); //작성날짜
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		
		article.setContent(request.getParameter("content"));
		article.setIp(request.getRemoteAddr());
		
        Field[] fields = article.getClass().getDeclaredFields();
        for(int i=0; i <fields.length; i++){
        fields[i].setAccessible(true);
        System.out.println(fields[i].getName() + " : " +fields[i].get(article));
        }  
		
		// <jsp:setProperty name="article" property="*" />		
		
		/*
		 * //BoardDAO 객체 -> insertArticle(article) => 9개 -> 실제로는 10개 -> 테이블상으론 12개,
		 * 이유는(readcount(0),num) Timestamp temp = new
		 * Timestamp(System.currentTimeMillis());//컴퓨터의 날짜와 시간을 구하는것임
		 * article.setReg_date(temp); //오늘 날짜 계산
		 * article.setIp(request.getRemoteAddr());//원격ip주소저장
		 */
		UsersDAO dbPro = new UsersDAO();
		dbPro.insertUser(User,UserSub,_Login);
		//response.sendRedirect("http://localhost:8090/JspBoard2/list.do");
		
		return "/index.jsp";
	}
	
}