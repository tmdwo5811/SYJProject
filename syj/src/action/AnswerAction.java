package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.*;
import dao.*;
import java.util.*;

public class AnswerAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum");
		
		//검색분야,검색어
		String search = request.getParameter("search"); //분야
		String searchtext = request.getParameter("searchtext"); //검색어
		System.out.println("AnswerAction에서의 매개변수 확인");
		System.out.println("pageNum=>"+pageNum);
		System.out.println("search=>"+search);
		System.out.println("searchtext=>"+searchtext);
		
		int count = 0; //총 레코드 수 *********
		List ansList = null; //화면에 출력할 레코드를 저장할 변수
		
		BoardDAO dbPro = new BoardDAO();
		count = dbPro.getArticleSearchCount(search, searchtext);//sql구문에 따라 결과가 달라진다고함
		System.out.println("현재 검색된 레코드 갯수(count)=>"+count);
		
		
		
		
		return null;
	}
//DAO ������ ��������
//view�� �����ֱ�
}
