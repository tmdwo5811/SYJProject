package action;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.*;
import dao.*;
public class userProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		User User = new User();
		UserSub UserSub = new UserSub();
		_Login _Login = new _Login();
		
	     Enumeration<String> params = request.getParameterNames(); 
	        while(params.hasMoreElements()){
	         String paramName = params.nextElement();
	         System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
	        }
	    
	        
	    //주민번호 앞 자리를 추출     
		String bothData = String.valueOf(request.getParameter("both"));
		//"-" 해당 문자열을 숫자 사이사이에 삽입하여 DB에 데이터 입력시 DATE형으로 입력될수있도록 밑작업
		StringBuffer bothDataOrigin = new StringBuffer(bothData);
		
		bothDataOrigin.insert(2, "-");
		bothDataOrigin.insert(5,"-");
		bothDataOrigin.insert(0, "19");
		
		//입력된 값을 문자열로 형변환 과정 
		String bothString = bothDataOrigin.toString();
		
		System.out.println(bothString);
		
		//DATE 형으로 포맷
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date both = Date.valueOf(bothString);
		
		//location 객체 생성
		Location lo = new Location();
		lo.setNo(Integer.parseInt(request.getParameter("location_no")));
		lo.getNo();
		
		//gender 데이터 추출
		char GenData = 0;
		
		int GenInt = Integer.parseInt(request.getParameter("gender"));
		
		if(1==GenInt || 3 == GenInt) {
			GenData = 'M';
		}else {
			GenData = 'W';
		}
		
		User.setGender(GenData);
		User.setBoth(both); //util.Date => sql.Date 로 형변환후 데이터 전송[승재 추가]
		User.setLocation(lo);
		User.setCredential(false);
		
		UserSub.setRegdate(new Timestamp(System.currentTimeMillis())); //작성날짜
		UserSub.setPhone((String) request.getParameter("phone"));//숫자열을 문자열로 변환해야함
		
		
		//salt 생성
		_Login.setPasswordWithEncrypt(request.getParameter("pw"));
		_Login.setId(request.getParameter("id"));

        Field[] fields = User.getClass().getDeclaredFields();
        for(int i=0;i<fields.length;i++) {
            fields[i].setAccessible(true);
            System.out.println(fields[i].getName() + " : " +fields[i].get(User));
        }
        Field[] fields2 = UserSub.getClass().getDeclaredFields();
        for(int i=0;i<fields2.length;i++) {
            fields2[i].setAccessible(true);
            System.out.println(fields2[i].getName() + " : " +fields2[i].get(UserSub));
        }
        Field[] fields3 = _Login.getClass().getDeclaredFields();
        
        for(int i=0; i <fields3.length; i++){
        fields3[i].setAccessible(true);
        System.out.println(fields3[i].getName() + " : " +fields3[i].get(_Login));
        }
		
		/*
		 * //BoardDAO 객체 -> insertArticle(article) => 9개 -> 실제로는 10개 -> 테이블상으론 12개,
		 * 이유는(readcount(0),num) Timestamp temp = new
		 * Timestamp(System.currentTimeMillis());//컴퓨터의 날짜와 시간을 구하는것임
		 * article.setReg_date(temp); //오늘 날짜 계산
		 * article.setIp(request.getRemoteAddr());//원격ip주소저장
		 */
        
		UsersDAO dbPro = new UsersDAO();
		dbPro.insertUser(User,_Login,UserSub);
		//response.sendRedirect("http://localhost:8090/JspBoard2/list.do");
		
		return "/index.jsp";
	}
	
}