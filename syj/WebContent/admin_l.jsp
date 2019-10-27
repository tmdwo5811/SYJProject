<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<!-- head태그 시작 -->
	<%@ include file="templateFiles/headParts.jsp"%>
	<!-- head태그 끝 -->
<body>

	<!-- 사이드 메뉴 시작 -->
	<%@ include file="templateFiles/sideMenu.jsp"%>
	<!-- 사이드 메뉴 끝  -->

          <div class="s-content"><!--컨텐츠 입력 시작 -->
            <div class="s-content content">
                <main class="row content__page">

                        <div class="column large-12 comment-respond">

                            <!-- START respond -->
                            <div id="respond">

                                <h3 class="h2">우리 동네 대나무숲<span>관리자 접속 하기</span></h3>

                                <form name="contactForm" id="contactForm" method="post" action="" autocomplete="off">
                                    <fieldset>

                                        <div class="form-field">
                                            <input name="cId" id="cId" class="full-width" placeholder="아이디를 입력해주세요." value="" type="text">
                                        </div>
                                        <div class="form-field">
                                            <input name="cpassword" id="cpassword" class="full-width" placeholder="비밀번호를 입력해주세요." value="" type="password">
                                        </div>

                                        <input name="submit" id="submit" class="btn btn--primary btn-wide btn--large full-width" value="로그인" type="submit">
                                        <div class="login_sub">
                                          <a href="join.html" style="color:#444444;">회원 가입</a> | <a href="" style="color:#444444;">아이디/비밀번호 찾기</a>
                                        </div>
                                    </fieldset>
                                </form> <!-- end form -->

                            </div>
                            <!-- END respond-->

                        </div> <!-- end comment-respond -->

                    </div> <!-- end comments-wrap -->
                </main>

            </div> <!-- end s-content -->

        </div> <!-- end s-content -->


	<!-- footerParts 시작 -->
	<%@ include file="templateFiles/footerParts.jsp"%>
	<!-- footerParts 끝 -->
    <!-- Java Script
    ================================================== -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/main.js"></script>

</body>
