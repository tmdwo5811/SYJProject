package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBConnectionMgr;
import vo.Location;
import vo.Post;

public class BoardDAO {
	private DBConnectionMgr pool=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;//select
	private String sql="";//실행시킬 SQL구문 저장
	
	//생상자
		public BoardDAO() {//
			try {
				pool=DBConnectionMgr.getInstance();
			}catch(Exception e) {
				System.out.println("DB접속 오류=>"+e);
			}
		}
		
		public int getArticleCount() {//페이징처리 전체 레코드수
			int x=0;
			try {
				con=pool.getConnection();
				System.out.println("con=>"+con);
				sql="select count(*) from board";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					x=rs.getInt(1);
				}
			}catch(Exception e) {
				System.out.println("getArticleCount()"+e);
			}finally {
				pool.freeConnection(con,pstmt,rs);
			}
			return x;
		}
		
		public int getArticleSearchCount(String search,String searchtext) {
			int x= 0;
			try {
				con=pool.getConnection();
				System.out.println("con=>"+con);
			if(search==null||search=="") {
				sql="select count(*) from board";
			}else {
				if(search.equals("subject_content")) {
					sql="select count(*) from board where subject like '%"+
							searchtext+"%' or content like '%"+searchtext+"%' ";
				}else {
					sql="select count(*) from board where"+search+" like '%"+
							searchtext+"%' ";
				}
			}
			}catch(Exception e) {
				System.out.println("getArticleSearchCount()"+e);
			}finally {
				pool.freeConnection(con,pstmt,rs);
			}
			return x;
		}
		
		//2.글목록보기에 대한 메서드구현->레코드가 한개이상->한 페이지당 10개씩 끊어서 보여준다.
		//1) 레코드의 시작번호   2) 불러올 레코드의 갯수
		public List getArticles(int start,int end) {//getMemberList(int start,int end)
			
			List articleList=null;//ArrayList articleList=null;
			
			try {
				con=pool.getConnection();
			    /*
			     *그룹번호가 가장 최신의 글을 중심으로 정렬하되,만약에 level이 같은 경우에는
			     *step값으로 오름차순을 통해서 몇번째 레코드번호를 기준해서 정렬할것인가? 
			     */
				sql="select * from board order by ref desc,re_step asc limit ?,?";//1,10
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, start-1);//mysql은 레코드순번이 내부적으로 0부터 시작
				pstmt.setInt(2, end);
				rs=pstmt.executeQuery();
				//글목록보기
				if(rs.next()) {//레코드가 최소 만족 1개이상 존재한다면
					articleList=new ArrayList(end);//10=>end갯수만큼 데이터를 담을 공간을 생성하라
					Location location = new Location();

					do {
						Post article=new Post();
						article.setNo(rs.getInt("no"));
						location.setNo(rs.getInt("location"));
						article.setLocation(location);
						article.setSubject(rs.getString("subject"));
						//article.setUser(rs.getUser("user")); 이거 우째함?
						article.setContent(rs.getString("content"));
						article.setView(rs.getInt("view"));
						article.setRegdate(rs.getTimestamp("regdate"));
						article.setStatus(rs.getByte("status"));
						
					}while(rs.next());
				}
			}catch(Exception e) {
				System.out.println("getArticles() 메서드 에러유발"+e);
			}finally {
				pool.freeConnection(con,pstmt,rs);
			}
			return articleList;
		}
		//-게시판의 글쓰기 및 답변글쓰기
		public void insertArticle(Post article) {
			List articleList=null;//ArrayList articleList=null
		}
}

