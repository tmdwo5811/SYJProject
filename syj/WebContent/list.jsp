<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="vo.*,java.util.*,java.text.SimpleDateFormat,dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<%!
     int pageSize=10;//numPerPage->페이지당 보여주는 게시물수(=레코드수) 10
     int blockSize=10;//pagePerBlock->블럭당 보여주는 페이지수 10
     //작성날짜->우리나라 스타일 년-월-일 시분초->SimpleDateFormat
     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<%
    //게시판을 맨 처음 실행시키면 무조건 1페이지부터 출력
    String pageNum=request.getParameter("pageNum");
    if(pageNum==null){
    	pageNum="1";//default(무조건 1페이지는 선택하지 않아도 보여줘야 하기때문에),가장 최근의 글
    }
    int currentPage=Integer.parseInt(pageNum);//"1"->1 현재페이지(=nowPage)
    //메서드 호출->시작 레코드번호
    //                  (1-1)*10+1=1,(2-1)*10+1=11,(3-1)*10+1=21)
    int startRow=(currentPage-1)*pageSize+1; //시작 레코드 번호
    int endRow=currentPage*pageSize;//1*10=10,2*10=20,3*10=30 ->마지막 레코드번호
    int count=0;//총레코드수 	
    int number=0;//beginPerPage->페이지별로 시작하는 맨 처음에 나오는 게시물번호
    List articleList=null;//화면에 출력할 레코드를 저장할 변수
    
    BoardDAO dbPro=new BoardDAO();
    count=dbPro.getArticleCount();//select count(*) from board->member
    System.out.println("현재 레코드수(count)=>"+count);
    if(count > 0){
    	articleList=dbPro.getArticles(startRow, pageSize);//첫번째 레코드번호,불러올 갯수
    }
    //            122-(1-1)*10=122,121,120,119,118,117,116~
    //            122-(2-1)*10=122-10=?
    number=count-(currentPage-1)*pageSize;
    System.out.println("페이지별 number=>"+number);
%>
<!-- head태그 시작 -->
<%@ include file="templateFiles/headParts.jsp"%>
<!-- head태그 끝 -->

<body class="ss-bg-white">
	<!-- 사이드 메뉴 시작 -->
	<%@ include file="templateFiles/sideMenu.jsp"%>
	<!-- 사이드 메뉴 끝  -->
	<%
    if(count==0){
%>
	<table border="1" width="700" cellpadding="0" cellspacing="0"
		align="center">
		<tr>
			<td align="center">게시판에 저장된 글이 없습니다.</td>
		</tr>
	</table>
	<% }else  { %>
	<div class="s-content content">
				<main class="row content__page">
				<div class="comments-wrap">
				<c:set var="number" value="${pgList.number}" />
						<c:forEach var="article" items="${articleList}">
					<div id="comments" class="column large-12">
						<h3 class="h2">답변된 청원</h3>
						<!-- START commentlist -->
						
						<ol class="commentlist">
							<li class="depth-1 comment" style="width: 752px;">
								<div class="comment__avatar">
									<button class="answer_button">답변 ${article.no}</button>
								</div>
								<div class="comment__content">
									<div class="comment__info">
										<div class="post_no">원래의 게시글 번호 ${article.no}</div>
										<div class="comment__author">${article.subject}</div>
										<div class="comment__meta">
											<div class="comment__time">${article.regdate}</div>
											<div class="comment__reply">
												<a class="comment-reply-link" href="/syj/content.jsp?no=${article.no}&pageNum=${pgList.currentPage}">자세히보기</a>
												</div>
										</div>
									</div>
								</div>
								<!-- comment__avatar -->
							</li>
							<!-- depth-1 comment -->
						</ol>
						<!-- END commentlist -->
					</div></c:forEach>
					<!-- end comments -->
				</div>

				</main>
				<!--여기  -->
			</div>
			<% }%>
	<!-- end s-content -->

	<!-- footerParts 시작 -->
	<%@ include file="templateFiles/footerParts.jsp"%>
	<!-- footerParts 끝 -->
	<!-- Java Script
    ================================================== -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
</body>
</html>