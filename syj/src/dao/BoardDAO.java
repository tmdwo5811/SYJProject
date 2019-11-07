
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.catalina.User;

import com.mysql.cj.jdbc.Blob;

import util.DBConnectionMgr;
import vo.*;




public class BoardDAO {
	private DBConnectionMgr pool = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;// select
	private String sql = "";// 실행시킬 SQL구문 저장

	// 생상자
	public BoardDAO() {//
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			System.out.println("DB접속 오류=>" + e);
		}
	}

	public int getArticleCount() {// 페이징처리 전체 레코드수
		int x = 0;
		try {
			con = pool.getConnection();
			System.out.println("con=>" + con);
			sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getArticleCount()" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;	
	}

	public int getArticleSearchCount(String search, String searchtext) {
		int x = 0;
		try {
			con = pool.getConnection();
			System.out.println("con=>" + con);
			if (search == null || search == "") {
				sql = "select count(*) from board";
			} else {
				if (search.equals("subject_content")) {
					sql = "select count(*) from board where subject like '%" + searchtext + "%' or content like '%"
							+ searchtext + "%' ";
				} else {
					sql = "select count(*) from board where" + search + " like '%" + searchtext + "%' ";
				}
			}
		} catch (Exception e) {
			System.out.println("getArticleSearchCount()" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}
public Hashtable pageList(String pageNum,int count) {
    	
    	//1.페이징 처리결과를 저장할 hashtable객체를 선언
    	Hashtable<String,Integer> pgList=new Hashtable<String,Integer>();
    	//ListAction에서의 복잡한 페이징처리를 대신 처리
	     int pageSize=5;//numPerPage->페이지당 보여주는 게시물수(=레코드수) 10
	     int blockSize=3;//pagePerBlock->블럭당 보여주는 페이지수 10
	     
	    //게시판을 맨 처음 실행시키면 무조건 1페이지부터 출력
	    if(pageNum==null){
	    	pageNum="1";//default(무조건 1페이지는 선택하지 않아도 보여줘야 하기때문에),가장 최근의 글
	    }
	    int currentPage=Integer.parseInt(pageNum);//"1"->1 현재페이지(=nowPage)
	    //메서드 호출->시작 레코드번호
	    //                  (1-1)*10+1=1,(2-1)*10+1=11,(3-1)*10+1=21)
	    int startRow=(currentPage-1)*pageSize+1; //시작 레코드 번호
	    int endRow=currentPage*pageSize;//1*10=10,2*10=20,3*10=30 ->마지막 레코드번호
	    int number=0;//beginPerPage->페이지별로 시작하는 맨 처음에 나오는 게시물번호
	    System.out.println("현재 레코드수(count)=>"+count);
	    //            122-(1-1)*10=122,122-(2-1)*10=112
	    number=count-(currentPage-1)*pageSize;
	    System.out.println("페이지별 number=>"+number);
	    
	    //총페이지수,시작,종료페이지 계산
	    //                      122/10=12 .2+1=>12.2+1.0=13.2=13페이지
	       int pageCount=count/pageSize+(count%pageSize==0?0:1);
	    //블럭당 페이지수 계산->10->10배수,3->3배수
	       int startPage=0;//1,2,3,,,,10 [다음 블럭 10]->11,12,,,,20
	       if(currentPage%blockSize!=0){//1~9,11~19,21~29
	    	   startPage=currentPage/blockSize*blockSize+1;
	       }else{ //10%10=0,(10,20,30)
	    		               //((10/10)-1)*10+1
	    	   startPage=((currentPage/blockSize)-1)*blockSize+1;
	       }
	       int endPage=startPage+blockSize-1;//1+10-1=10
	       System.out.println("startPage="+startPage+",endPage="+endPage);
	       if(endPage > pageCount)
	    	   endPage=pageCount;//마지막페이지=총페이지수
	       //페이징처리에 대한 계산결과->Hashtable,HashMap->ListAction전달->메모리에 저장->list.jsp
	       pgList.put("pageSize", pageSize);//<->pgList.get(키명)("pageSize")
	       pgList.put("blockSize", blockSize);
	       pgList.put("currentPage", currentPage);
	       pgList.put("startRow", startRow);
	       pgList.put("endRow", endRow);
	       pgList.put("count", count);
	       pgList.put("number", number);
	       pgList.put("startPage", startPage);
	       pgList.put("endPage", endPage);
	       pgList.put("pageCount", pageCount);
	       
	       return pgList;
    }
//2019 11 04 수정 검색

public List getBoardArticles(int start,int end,String search,String searchtext) {
	
	List articleList=null;//ArrayList articleList=null;
	
	try {
		con=pool.getConnection();
	    //---------------------------------------------------------------------------
		if(search==null || search=="") {
			sql="select * from board order by no asc limit ?,?";//1,10
			
		}else { //제목+본문
			if(search.equals("subject_content")) { //제목+본문
				sql="select * from board where subject like '%"+
			           searchtext+"%' or content like '%"+searchtext+"%' order by no desc limit ?,?";
			}else { //제목,작성자->매개변수를 이용해서 하나의 sql통합
				sql="select * from board where "+search+" like '%"+
			           searchtext+"%' order by ref desc,re_step asc limit ?,?";
			}
		}
		System.out.println("getBoardArticles()의 sql=>"+sql);
		//-----------------------------------------------------------------------------
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, start-1);//mysql은 레코드순번이 내부적으로 0부터 시작
		pstmt.setInt(2, end);
		rs=pstmt.executeQuery();
		//글목록보기
		if(rs.next()) {//레코드가 최소 만족 1개이상 존재한다면
			articleList=new ArrayList(end);//10=>end갯수만큼 데이터를 담을 공간을 생성하라
			
			do {
				Post article=new Post();
				Location lo=new Location(rs.getInt("location_no"));

				article.setNo(rs.getInt("no"));
				article.setLocation(lo);
				//System.out.println(lo);
				article.setSubject(rs.getString("subject"));
				article.setContent(rs.getString("content"));
				article.setView(rs.getInt("view"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setStatus(rs.getByte("status"));
				
				
				//추가
				articleList.add(article);
			}while(rs.next());
		}
	}catch(Exception e) {
		System.out.println("getBoardArticles() 메서드 에러유발"+e);
	}finally {
		pool.freeConnection(con,pstmt,rs);
	}
	return articleList;
}

	// 2.글목록보기에 대한 메서드구현->레코드가 한개이상->한 페이지당 10개씩 끊어서 보여준다.
	// 1) 레코드의 시작번호 2) 불러올 레코드의 갯수
public List getArticles(int start, int end) {// getMemberList(int start,int end)

	List articleList = null;// ArrayList articleList=null;


	try {
		con = pool.getConnection();
		/*
		 * 그룹번호가 가장 최신의 글을 중심으로 정렬하되,만약에 level이 같은 경우에는 step값으로 오름차순을 통해서 몇번째 레코드번호를
		 * 기준해서 정렬할것인가?
		 */
		sql="select * from board order by no asc limit ?,?";//1,10
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, start - 1);// mysql은 레코드순번이 내부적으로 0부터 시작
		pstmt.setInt(2, end);
		rs = pstmt.executeQuery();
		// 글목록보기
		if (rs.next()) {// 레코드가 최소 만족 1개이상 존재한다면
			articleList = new ArrayList(end);// 10=>end갯수만큼 데이터를 담을 공간을 생성하라
			
			do {
				//Post article = (Post) new Post().setByResultSet(rs);
				//Location user content view regdate status
				Post article =new Post();
				Location lo=new Location(rs.getInt("location_no"));
				article.setNo(rs.getInt("no"));
				article.setLocation(lo);
				//article.setLocation(rs.getLocation("location"));
				article.setSubject(rs.getString("subject"));
				article.setContent(rs.getString("content"));
				article.setView(rs.getInt("view"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setStatus(rs.getByte("status"));
				
				articleList.add(article);
			} while (rs.next());

		}
	} catch (Exception e) {
		System.out.println("getArticles() 메서드 에러유발" + e);
	} finally {
		pool.freeConnection(con, pstmt, rs);
	}

	return articleList;
}
private Post makeArticleFromResult() throws Exception {
	Post article=new Post();
	Location lo=new Location(rs.getInt("location_no"));
	article.setNo(rs.getInt("no"));
	article.setLocation(lo);
	article.setSubject(rs.getString("subject"));
	article.setContent(rs.getString("content"));
	article.setView(rs.getInt("view"));
	article.setRegdate(rs.getTimestamp("regdate"));//오늘날짜->코딩 ->now()
	article.setStatus(rs.getByte("status"));
	return article;
}


	// -게시판의 글쓰기 (일단 만들어두긴하는데 써야할듯)
	public void insertArticle(Post article) {
		int view = article.getView();
		int no = article.getNo();
		int number = 0;// 데이터를 저장하기위한 게시물번호
		try {
			con = pool.getConnection();
			sql = "select max(no) from board"; // 최대값+1=실제 저장할 게시물번호
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 보여주는 결과가 있다면 ->rs.last()->rs.getRow();(X)
				number = rs.getInt(1) + 1; // 변수명=rs.get자료형(필드명 또는 인덱스번호)=>필드명X을 사용할 수 없는 경우에 사용
			} else {// 현재 테이블에 데이터가 한개라도 없는 경우
				number = 1;
			}
			 sql = "insert into board(no,location_no,subject,user_no,content,view,regdate,status";
	         sql += ") values(?,?,?,?,?,?,?,?)";
	         pstmt = con.prepareStatement(sql);
	         pstmt.setInt(1, article.getNo());
	         pstmt.setInt(2, article.getLocation().getNo());
	         pstmt.setString(3, article.getSubject());
	         pstmt.setInt(4, article.getUser().getNo());
	         pstmt.setString(5, article.getContent());
	         pstmt.setInt(6, article.getView());
	         pstmt.setTimestamp(7, article.getRegdate());
	         pstmt.setByte(8, article.getStatus());
	         int insert = pstmt.executeUpdate();
	         System.out.println("게시판의 글쓰기 성공유무(insert)=>" + insert);// 1 or 0실패
	      } catch (Exception e) {
	         System.out.println("insertArticle()메서드 에러유발" + e);
	      } finally {
	         pool.freeConnection(con, pstmt, rs);
	      }
	   }

	// 글상세보기
	public Post getArticle(int num) {
		Post article = null;
		try {
			con = pool.getConnection();
			sql = "update board set readcount=readcount+1 where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			int update = pstmt.executeUpdate();
			System.out.println("조회수 증가유무(update)=>" + update);
			sql = "select * from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			// 글목록보기
			if (rs.next()) {
				article = (Post) new Post().setByResultSet(rs);
			}
		} catch (Exception e) {
			System.out.println("getArticle 메서드에러" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return article;
	}

	// 글수정
	public Post updateGetArticle(int no) {
		Post article = null;

		try {
			con = pool.getConnection();

			sql = "select Post * from board where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article = (Post) new Post().setByResultSet(rs);
			}
		} catch (Exception e) {
			System.out.println("updateGetArticle() 메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return article;
	}

	// session.getAttribute("loginInfo/*(vo.User)*/").getNo();
	public int updateArticle(Post article) {
		String no = null;

		int x = -1;// 게시물의 수정성공유무
		try {
			con = pool.getConnection();
			sql = "select user from board where no=?"; // 최대값+1=실제 저장할 게시물번호
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {// 보여주는 결과가 있다면 ->rs.last()->rs.getRow();(X)
				no = rs.getString("no");
				System.out.println("no=>" + no);// 확인한뒤에 나중에 삭제

				if (no.equals(article.getNo())) {
					sql = "update board set writer=?,subject=?";
					sql += " where no=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, article.getContent());// 웹에서는 Setter Method를 메모리에 저장
					pstmt.setString(2, article.getSubject());
					pstmt.setInt(6, article.getNo());
					int update = pstmt.executeUpdate();
					System.out.println("게시판의 글수정 성공유무(update)=>" + update);// 1 or 0실패
					x = 1;// 수정성공 표시
				} else {// 암호가 틀린경우
					x = 0;// 수정 실패
				}
			} else { // if(rs.next())
				x = -1; // 찾은 데이터가 없는 경우(생략가능)
			}
		} catch (Exception e) {
			System.out.println("updateArticle()메서드" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}

//글삭제 고치는중
	/*
	public int deleteArticle(int no, String user) {
		String dbuser = null;
		int dbno=0;
		int x = -1;// 게시물의 삭제성공유무

		try {
			con = pool.getConnection();
			sql = "select no user from board where no=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, user_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbno=rs.getInt("no");//Integer.parseInt(request.getParameter("no")
				dbuser = rs.getString("user");
				System.out.println("dbuser" + dbuser+",dbno"+dbno);
				if (dbuser.contentEquals("user")) {
					sql = "delete from board where no=? and user=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, no);
					pstmt.setString(2, user);
					int delete = pstmt.executeUpdate();
					System.out.println("게시판의 글삭제 성공유무(delete)=>" + delete);
					x = 1;
				} else {
					x = 0;
				}
			}
		} catch (Exception e) {
			System.out.println("deleteArticle()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}
	*/

	
	public boolean deleteArticle(int no, int user) {
		int dbuser = 0;
		int dbno=0;
		boolean x=false;// 게시물의 삭제성공유무
		try {			
			if (rs.next()) {
				dbno=rs.getInt("no");//Integer.parseInt(request.getParameter("no")
				dbuser = rs.getInt("user");
				System.out.println("dbuser" + dbuser+",dbno"+dbno);
				if (dbuser==user && dbno==no) {
					sql = "delete from board where no=? and user=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, no);
					pstmt.setInt(2, user);
					int delete = pstmt.executeUpdate();
					x = true;
					System.out.println("게시판의 글삭제 성공유무(delete)=>" + delete);
				} else {
					x = false;
				}
			}
		} catch (Exception e) {
			System.out.println("deleteArticle()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return x;
	}

	// 댓글 작성
	public void addComment(Comment comment) {
		// 1.DB연결
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		// db작업
		try {
			con = pool.getConnection();
			System.out.println("comment.getUser()=" + comment.getUser());
			/* System.out.println("comment.getReg_date()="+comment.getReg_date()); */
			System.out.println("comment.getcontent()=" + comment.getContent());
			System.out.println("comment.getNo()=" + comment.getNo());
			// 데이터 추가하는 코딩
			sql = "insert into reply_board1 values";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, comment.getUser().getNo());
			// pstmt.setTimestamp (2,comment.getReg_date());
			pstmt.setString(3, comment.getContent());
			pstmt.setInt(4, comment.getNo());
		} catch (Exception e) {
			System.out.println("addComment()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}

	}

	// 댓글
	public List<Comment> CommentDetail(int num) {
		// DB 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println("sql:" + sql);
		ResultSet rs = null;
		List<Comment> commentList = null;

		try {
			con = pool.getConnection();
			String sql = "SELECT no, post_no `post.no`, user_no `user.no`, content, regdate FROM comments WHERE post_no = ?";
			pstmt = con.prepareStatement(sql);
			System.out.println("sql:");
			rs = pstmt.executeQuery();

			commentList = new ArrayList<>();
			while (rs.next())
				commentList.add((Comment) new Comment().setByResultSet(rs));
		} catch (Exception e) {
			System.out.println("CommentDetail()메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return commentList;
	}

	// 댓글 삭제
	public int deleteComment(int no) {
		int result = 0;
		// 1. DB 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		int x = -1;// 데이터 삭제 유무
		String sql = "";// sql 기억
		// 2. DB 작업
		try {
			con = pool.getConnection();
			con.setAutoCommit(false);
			sql = "DELETE FROM comments WHERE no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}


