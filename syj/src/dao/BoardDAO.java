package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBConnectionMgr;
import vo.Location;
import vo.Post;
import vo.User;
import vo.Comment;

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
			sql = "select * from board";// 1,10
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start - 1);// mysql은 레코드순번이 내부적으로 0부터 시작
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			// 글목록보기
			if (rs.next()) {// 레코드가 최소 만족 1개이상 존재한다면
				articleList = new ArrayList(end);// 10=>end갯수만큼 데이터를 담을 공간을 생성하라
				Location location = new Location();

				do {
					Post article = (Post) new Post().setByResultSet(rs);

				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("getArticles() 메서드 에러유발" + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return articleList;
	}

	// -게시판의 글쓰기 (일단 만들어두긴하는데 써야할듯)
	public void insertArticle(Post article) {

		int view = article.getView();
		int no = article.getNo();
		int number = 0;// 데이터를 저장하기위한 게시물번호
		System.out.println("insertArticle 메서드의 내부 no=>" + no);// 0신규글
		System.out.println("view=>" + view + "no=>" + no);
		try {
			con = pool.getConnection();
			sql = "select max(num) from board"; // 최대값+1=실제 저장할 게시물번호
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 보여주는 결과가 있다면 ->rs.last()->rs.getRow();(X)
				number = rs.getInt(1) + 1; // 변수명=rs.get자료형(필드명 또는 인덱스번호)=>필드명X을 사용할 수 없는 경우에 사용
			} else {// 현재 테이블에 데이터가 한개라도 없는 경우
				number = 1;
			}
			sql = "insert into board(no,location,subject,user,content,view,regdate,status";
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

//글삭제=>암호비교
	public int deleteArticle(int num, String passwd) {
		String dbpasswd = null;
		int x = -1;// 게시물의 삭제성공유무

		try {
			con = pool.getConnection();
			sql = "select passwd from board where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbpasswd = rs.getString("passwd");
				System.out.println("dbpasswd" + dbpasswd);
				if (dbpasswd.contentEquals(passwd)) {
					sql = "delete from board where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
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