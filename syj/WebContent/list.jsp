<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="vo.*,java.util.*,java.text.SimpleDateFormat,dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<!-- head태그 시작 -->
<%@ include file="templateFiles/headParts.jsp"%>
<!-- head태그 끝 -->

<body class="ss-bg-white">
	<!-- 사이드 메뉴 시작 -->
	<%@ include file="templateFiles/sideMenu.jsp"%>
	<!-- 사이드 메뉴 끝  -->
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
										<div class="post_no">게시글 번호 ${article.no}</div>
										<div class="comment__author">${article.subject}</div>
										<div class="comment__meta">
											<div class="comment__time">${article.regdate}</div>
											<div class="comment__reply">
												<a class="comment-reply-link" href="/syj/comment.jsp?no=${article.no}&pageNum=${pgList.currentPage}">자세히보기</a>
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
	<!-- end s-content -->
	<c:if test="${pgList.startPage > pgList.blockSize}">
		<a href="/syj/list.do?pageNum=${pgList.startPage-pgList.blockSize}&search=${search}&searchtext=${searchtext}">[이전]</a>
	</c:if>

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
		
	<form name="test" action="/syj/list.do" class="listForm">
		<select name="search" class="searchBoardSelect">
      <option value="subject">제목</option>
      <option value="subject_content">제목+본문</option>
   </select>
   <input type="text" class="searchBoardBar">&nbsp;
   <input type="submit" value="검색" class="searchBoardButton">
   </form>
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