package dao;

import java.sql.*;
import java.util.*;

import util.DBConnectionMgr;
import vo.*;

public class AnswersDAO {
	private DBConnectionMgr pool=null;//연결할 객체
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;//select
	private String sql="";//실행시킬 sql구문을 저장
	
	public void insertArticle(Answer article) {//~(MemberDTO mem)
		//1. article=> 신규글인지 답글인지 확인
		int no=article.getNo();//꺼내온 값이 0이라면 신규
		Post post=article.getPost();
		String content=article.getContent();
		Timestamp regdate=article.getRegdate();
		//테이블에 입력할 게시물번호를 저장할 변수
		int num=0;//데이터를 저장하기 위한 게시물번호
		System.out.println("insertArticle 메소드의 내부no=>"+no);//0=>신규 !=답글
		System.out.println("post=>"+post);
		System.out.println("content=>"+content);
		System.out.println("regdate=>"+regdate);
	      try{
	         con=pool.getConnection();
	         System.out.println("con=>"+con);//디버깅 코드
	         sql="select count(*) from answer";//최대값+1=실제 저장할 답변게시물번호
	         pstmt=con.prepareStatement(sql);
	         rs=pstmt.executeQuery();
	         if(rs.next()) {//보여주는 결과가 있다면
	            num = rs.getInt(1)+1; //변수명=rs.get자료형(필드명 또는 인덱스 번호)=> 필드명  X를 사용할수 없는경우
	         }else {//현재 테이블에 데이터가 한개라도 없는경우
	        	 num=1;
	         }
	         
	         sql = "INSERT INTO answers(post_no, user_no, content) VALUES(?, ?, ?)";

	         pstmt.setInt(1, article.getPost().getNo()); //일반게시물의 번호
	         pstmt.setString(2, article.getId().getId()); //답변게시물의 작성자
	         pstmt.setString(3, article.getContent()); //답변게시물의 글내용
	        
	         //12개 데이터->num,reg_date,readcount(생략) ->default | 작성날짜->regdate, now() <--mysql(? 대신에)
			
	         /*
			 * sql="insert into board(no,post,content,regdate)values(?,?,?,?)";
			 * pstmt=con.prepareStatement(sql); pstmt.setInt(1, article.getNo());//웹에선
			 * Setter Method를 메모리에 저장한다. pstmt.setPost()(2, article.getPost());
			 * pstmt.setString(3, article.getContent()); pstmt.setTimestamp(4,
			 * article.getRegdate());//?대신에 now()(웹상에서 계산하여 저장)
			 */
	         
	         sql = "INSERT INTO answers(post_no, user_no, content) VALUES(?, ?, ?)";

	         pstmt.setInt(1, article.getPost().getNo()); //일반게시물의 번호
	         pstmt.setString(2, article.getId().getId()); //답변게시물의 작성자
	         pstmt.setString(3, article.getContent()); //답변게시물의 글내용
	         
//	         //--------ref,re_step,re_level에 대한 계산이 적용된 상태에서 저장----------
//	         pstmt.setInt(6, ref);//pstmt.setInt(6, article.getRef()); (X)
//	         pstmt.setInt(7, re_step);
//	         pstmt.setInt(8, re_level);
//	         //--------------------------------------
	         
			/*
			 * pstmt.setString(9, article.getContent()); pstmt.setString(10,
			 * article.getIp());//request.getRemoteAddr() | jspf(writePro.jsp)
			 */
	         
	         int insert=pstmt.executeUpdate();
	         System.out.println("게시판의 글쓰기 성공유무(insert)=>"+insert);//1이면 성공 0 실패
	      }catch(Exception e) {
	         System.out.println("insertArticle() 메소드 에러유발"+e);
	      }finally {
	         pool.freeConnection(con,pstmt,rs);
	      }
		}
}
