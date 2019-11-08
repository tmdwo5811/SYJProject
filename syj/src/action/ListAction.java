package action;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import vo.Post;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse pesponse) throws Throwable {
		// TODO Auto-generated method stub
		String pageNum=request.getParameter("pageNum");
		//추가(검색분야,검색어)
		String search=request.getParameter("search");//검색분야
		String searchtext=request.getParameter("searchtext");
		System.out.println("ListAction의 매개변수확인");
		System.out.println("pageNum"+pageNum+" ,search"+search+" ,searchtext"+searchtext);
		int count=0;//총레코드수
		BoardDAO dbpro=new BoardDAO();
			//count=dbpro.getArticleSearchCount(search, searchtext);//sql구문에 따라라서 결과 달라짐
		
		count = dbpro.getArticleCount();
		Hashtable<String,Integer> pgList=dbpro.pageList(pageNum,count);
		int startRow = pgList.get("startRow");
		int endRow = pgList.get("endRow");
		List articleList=null;//화면에 출력할 레코드를 저장할변수
		System.out.println("현재검색된 레코드수(count)"+count);
		
	    if(count > 0){
	    	System.out.println("startRow =>"+startRow+","+"endRow =>"+endRow);
	    	articleList=dbpro.getArticles(startRow, endRow);//첫번째 레코드번호,불러올 갯수
	    }else {//count=0
	    	articleList=Collections.EMPTY_LIST;//아무것도 없는 빈 list객체 변환
	    	System.out.println("아무것도 없음");
	    }

		//2.처리한 결과를 공유(서버 메모리에 저장)->이동할 페이지에 공유해서 사용
		//request.setAttribute("currentPage"(키명))=>${키명}
	    request.setAttribute("search", search);//검색분야
	    request.setAttribute("searchtext", searchtext);//검색어
	    request.setAttribute("pgList", pgList);//페이징처리 10개 정보
	    request.setAttribute("articleList", articleList);//${articleList}
	    
		//3.공유해서 이동할 수있도록 페이지를 지정
	    
	    //4.DB에서 게시물에 대한 정보를 가져오는 구문
	    
		
		return "/list.jsp";// / board/list.jsp=>경로를 변경해서 지정할 수있다.
	}

}

