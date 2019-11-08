<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="user_id" value="${sessionScope.idKey}"/>
<c:set var="user_loc" value="${sessionScope.locValue}"/>
<!DOCTYPE html>
<html>
<!-- head태그 시작 -->
<%@ include file="templateFiles/headParts.jsp"%>
<!-- head태그 끝 -->
<body onload="printClock()">
	<!-- 사이드 메뉴 시작 -->
	<%@ include file="templateFiles/sideMenu.jsp"%>
	<!-- 사이드 메뉴 끝  -->
	<div id="app000" class="container000">
		<a href="list.do"> <card data-image="images/seoul.jpg">
			<div class="h1text" slot="header" id="clock1234">실시간 청원</div>
			<div class="subtext111" slot="content">
				<br>우리동네 대나무숲에 오신것을<br>환영합니다.
			</div>
			</card>
		</a> <a href="loc_board.jsp"> <card data-image="images/second111.jpg">
			<div class="h1text" slot="header">지역별 모아보기</div>
			<div class="subtext111" slot="content">
				<br>지역별 청원 내용을 확인<br>할수있습니다.
			</div>
			</card>
		</a> <a href="faq.jsp"> <card data-image="images/third111.jpg">
			<div class="h1text" slot="header">대나무숲 이용방법</div>
			<div class="subtext111" slot="content">
				<br>대나무숲 서비스 관련<br>이용 방법을확인할수있습니다.
			</div>
			</card>
		</a> <a href="writeForm.jsp"> <card data-image="images/four.jpg">
			<div class="h1text" slot="header">지금 청원하기</div>
			<div class="subtext111" slot="content">
				<br>우리동네에 개선됬으면 하는<br>이야기를 작성해보세요.
			</div>
			</card>
		</a>
	</div>
	<script	src='https://cdnjs.cloudflare.com/ajax/libs/vue/2.0.1/vue.min.js'></script>
	<script src="js/vuescript.js"></script>
	<div class="s-content">
	<c:if test="${empty user_id}">
		<main class="row content__page">
		<div class="column large-12 comment-respond">
			<!-- START respond -->
			<div id="respond">

				<h3 class="h2">
					우리 동네 대나무숲<span> 접속 하기</span>
				</h3>

				<form name="contactForm" id="contactForm" method="post" action="loginProc.do"
					autocomplete="off">
					<fieldset>

						<div class="form-field">
							<input name="cId" id="cId" class="full-width"
								placeholder="아이디를 입력해주세요." type="text">
						</div>
						<div class="form-field">
							<input name="cpassword" id="cpassword" class="full-width"
								placeholder="비밀번호를 입력해주세요." value="" type="password">
						</div>

						<input name="submit" id="submit"
							class="btn btn--primary btn-wide btn--large full-width"
							value="로그인" type="submit">
						<div class="login_sub">
							<a href="join_test.jsp" style="color: #444444;">회원 가입</a> | <a
								href="#" style="color: #444444;">아이디/비밀번호 찾기</a>
						</div>
					</fieldset>
				</form>
				<!-- end form -->

			</div>
			<!-- END respond-->

		</div>
		<!-- end comment-respond -->
		</c:if><!-- 로그아웃일때 -->
		
		<c:if test="${!empty user_id || user_id eq 'admin'}">
		
		</c:if><!-- 관리자 계정 일때 -->
		
		<c:if test="${!empty user_id || !user_id eq 'admin'}">
		<div>
			${user_id} 님 일반계정으로 잘 들어오셨습니다.<p>
			${user_loc} 번 지역의 회원님입니다.
			
			
			
			
			
			<div id="comments" class="column large-12">
                        <h3 class="h2">우리 동네 실시간 청원</h3>
                        <div style="float:right;">
                          <button style="height:40px;line-height:40px;" onclick="location.href='write.html'">지금 청원하기</button>
                        </div>
                        <!-- START commentlist -->
                        <ol class="commentlist">

                            <li class="depth-1 comment">

                                <div class="comment__avatar">
                                    <img class="avatar" src="images/avatars/user-01.jpg" alt="" width="50" height="50">
                                </div>

                                <div class="comment__content">

                                    <div class="comment__info">
                                        <div class="post_no">게시글 번호 ${board_no} | 현상태 &lt;${status}&gt;</div>
                                        <div class="comment__author">${subject}</div>
                                        <div class="comment__meta">
                                            <div class="comment__time">${board_regdate}</div>
                                            <div class="comment__reply">
                                                <a class="comment-reply-link" href="#0">자세히 보기</a> | 조회수 ${view}
                                            </div>
                                        </div>
                                    </div>

                                    <div class="comment__text">
                                    <p>
                                    	${board_content}
                                    </p>
                                    </div>

                                </div>
                            </li> <!-- end comment level 1 -->
                        </ol>
                        <!-- END commentlist -->
                    </div> <!-- end comments -->
                    
                    
                    
                    
                    
		</div>
		
		</c:if><!-- 일반 계정 일때 -->
	</div>
	<!-- end comments-wrap -->
	</main>
	</div>
	<div style="clear: both"></div>
	<!-- end content -->
	<!-- footerParts 시작 -->
	<%@ include file="templateFiles/footerParts.jsp"%>
	<!-- footerParts 끝 -->
	<!-- Java Script
    ================================================== -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>

</body>