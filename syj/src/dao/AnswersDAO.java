package dao;

import vo.*;

public class AnswersDAO {
	public void insertArticle(Answer article) {//~(MemberDTO mem)
		//1. article=> 신규글인지 답글인지 확인
		int no=article.getNo();//꺼내온 값이 0이라면 신규글 아니라면 답글
		Post post=article.getPost();
		int re_step=article.getRe_step();
		int re_level=article.getRe_level();
		//테이블에 입력할 게시물번호를 저장할 변수
		int number=0;//데이터를 저장하기 위한 게시물번호 
		System.out.println("insertArticle 메소드의 내부num=>"+num);//0=>신규 !=답글
		System.out.println("ref=>"+ref);
		System.out.println("re_step=>"+re_step);
		System.out.println("re_level=>"+re_level);
	      try{
	         con=pool.getConnection();
	         System.out.println("con=>"+con);//디버깅 코드
	         sql="select count(*) from board";//최대값+1=실제 저장할 게시물번호
	         pstmt=con.prepareStatement(sql);
	         rs=pstmt.executeQuery();
	         if(rs.next()) {//보여주는 결과가 있다면
	            number = rs.getInt(1)+1; //변수명=rs.get자료형(필드명 또는 인덱스 번호)=> 필드명  X를 사용할수 없는경우
	         }else {//현재 테이블에 데이터가 한개라도 없는경우
	        	 number=1;
	         }
	         //답글이라면
	         if(num!=0) {//양수명서 1이상
	        	 //같은 그룹번호를 가지고 있으면서 나보다 step값이 큰놈을 찾아서, 그 step값을 하나 증가시킨다.
	        	 sql="update board set re_step=re_step+1 where ref=? and re_step > ?";
	        	 pstmt=con.prepareStatement(sql);
	        	 pstmt.setInt(1, ref);
	        	 pstmt.setInt(2, re_step);
	        	 int update=pstmt.executeUpdate();
	        	 System.out.println("댓글수정 유무(update)=>"+update);//1이면 성공
	        	 
	        	 re_step=re_step+1;
	        	 re_level=re_level+1;
	         }else {//신규글이라면 => num=0
	        	 ref=number;//1
	        	 re_step=0;
	        	 re_level=0;
	         }
	         //12개 데이터->num,reg_date,readcount(생략) ->default | 작성날짜->sysdate, now() <--mysql(? 대신에)
	         sql="insert into board(writer,email,subject,passwd,reg_date,ref,re_step,re_level,content,ip)values(?,?,?,?,?,?,?,?,?,?)";
	         pstmt=con.prepareStatement(sql);
	         pstmt.setString(1, article.getWriter());//웹에선 Setter Method를 메모리에 저장한다.
	         pstmt.setString(2, article.getEmail());
	         pstmt.setString(3, article.getSubject());
	         pstmt.setString(4, article.getPasswd());
	         pstmt.setTimestamp(5, article.getReg_date());//?대신에 now()(웹상에서 계산하여 저장)
	         //--------ref,re_step,re_level에 대한 계산이 적용된 상태에서 저장----------
	         pstmt.setInt(6, ref);//pstmt.setInt(6, article.getRef()); (X)
	         pstmt.setInt(7, re_step);
	         pstmt.setInt(8, re_level);
	         //--------------------------------------
	         pstmt.setString(9, article.getContent());
	         pstmt.setString(10, article.getIp());//request.getRemoteAddr() | jspf(writePro.jsp)
	         int insert=pstmt.executeUpdate();
	         System.out.println("게시판의 글쓰기 성공유무(insert)=>"+insert);//1이면 성공 0 실패
	      }catch(Exception e) {
	         System.out.println("insertArticle() 메소드 에러유발"+e);
	      }finally {
	         pool.freeConnection(con,pstmt,rs);
	      }
		}
}
