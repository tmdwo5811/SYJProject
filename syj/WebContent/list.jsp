<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
   pageEncoding="UTF-8"%>
=======
	pageEncoding="UTF-8"
	import="vo.*,java.util.*,java.text.SimpleDateFormat,dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
>>>>>>> branch 'master' of https://github.com/tmdwo5811/SYJProject.git
<!DOCTYPE html>
<html>
<<<<<<< HEAD
=======
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
>>>>>>> branch 'master' of https://github.com/tmdwo5811/SYJProject.git
<!-- head태그 시작 -->
<%@ include file="templateFiles/headParts.jsp"%>
<!-- head태그 끝 -->

<body class="ss-bg-white">
<<<<<<< HEAD
   <!-- 사이드 메뉴 시작 -->
   <%@ include file="templateFiles/sideMenu.jsp"%>
   <!-- 사이드 메뉴 끝  -->
=======
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
>>>>>>> branch 'master' of https://github.com/tmdwo5811/SYJProject.git

<<<<<<< HEAD
      <c:if test="${pgList.count==0}">
      <table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
         <tr>
              <td align="center">게시판에 저장된 글이 없습니다.</td>
         </tr>
      </table>
      </c:if>
      <c:if test="${pgList.count > 0}">        
        <div class="s-content content">
            <main class="row content__page">
                <div class="comments-wrap">
                    <div id="comments" class="column large-12">
                        <h3 class="h2">답변된 청원</h3>
                        <!-- START commentlist -->
                        <ol class="commentlist">
                            <li class="depth-1 comment" style="width:752px;">
                              <div class="comment__avatar">
                                <button class="answer_button">답변 1호</button>
                              </div>
                                <div class="comment__content">
                                    <div class="comment__info">
                                        <div class="post_no">원래의 게시글 번호 ${no}</div>
                                        <div class="comment__author">청원 게시글 제목</div>
                                        <div class="comment__meta">
                                            <div class="comment__time">April 26, 2019</div>
                                            <div class="comment__reply">
                                                <a class="comment-reply-link" href="#0">자세히 보기</a>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- comment__avatar -->
                            </li>  <!-- depth-1 comment -->
                        </ol>
                        <!-- END commentlist -->
                    </div> <!-- end comments -->
                 </div>
            </main>
            <!--여기  -->
      </div>
   </c:if>
        </div> <!-- end s-content -->
=======
				</main>
				<!--여기  -->
			</div>
			<% }%>
	<!-- end s-content -->
	<c:if test="${pgList.startPage > pgList.blockSize}">
		<a
			href="/syj/list.do?pageNum=${pgList.startPage-pgList.blockSize}&search=${search}&searchtext=${searchtext}">[이전]</a>
	</c:if>
>>>>>>> branch 'master' of https://github.com/tmdwo5811/SYJProject.git

<<<<<<< HEAD
      <!-- footerParts 시작 -->
      <%@ include file="templateFiles/footerParts.jsp"%>
      <!-- footerParts 끝 -->
      <!-- Java Script
=======
	<c:forEach var="i" begin="${pgList.startPage}" end="${pgList.endPage}">
		<a
			href="/syj/list.do?pageNum=${i}&search=${search}&searchtext=${searchtext}">
			<c:if test="${pgList.currentPage==i}">
				<font color="red"><b>[${i}]</b></font>
			</c:if> <c:if test="${pgList.currentPage!=i}">
	          ${i}
	   </c:if>
		</a>
	</c:forEach>

	<c:if test="${pgList.endPage < pgList.pageCount}">
		<a
			href="/syj/list.do?pageNum=${pgList.startPage+pgList.blockSize}&search=${search}&searchtext=${searchtext}">[다음]</a>
	</c:if>

	<p>
		<!-- 검색어 추가(자주 검색이 되는 항목을 잘 선택) 제목,작성자,제목+본문
       ex) search.do ->새로운 요청명령어를 이용해서 추가
             list.do->기존의 내용을 추가
  -->
		
	<form name="test" action="/syj/list.do">
		<select name="search">
      <option value="subject">제목</option>
      <option value="subject_content">제목+본문</option>
      <option value="writer">작성자</option>
   </select>
   <input type="text" size="15" name="searchtext">&nbsp;
   <input type="submit" value="검색">
	<!-- footerParts 시작 -->
		<%@ include file="templateFiles/footerParts.jsp"%>
		<!-- footerParts 끝 -->
		<!-- Java Script
>>>>>>> branch 'master' of https://github.com/tmdwo5811/SYJProject.git
    ================================================== -->
<<<<<<< HEAD
      <script src="js/jquery-3.2.1.min.js"></script>
      <script src="js/plugins.js"></script>
      <script src="js/main.js"></script>
=======
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/plugins.js"></script>
		<script src="js/main.js"></script>
	
>>>>>>> branch 'master' of https://github.com/tmdwo5811/SYJProject.git
</body>
</html>