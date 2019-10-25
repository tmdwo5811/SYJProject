<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
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

                                <h3 class="h2">대나무숲<span> 가입 하기</span></h3>

                                <form name="contactForm" id="contactForm" method="post" action="join_testPro.do" autocomplete="off">
                                    <input type="hidden" name="" value="">
                                    <fieldset>

                                        <div class="form-field">
                                            <input name="id" id="cName" class="full-width" placeholder="사용할 아이디를 입력해주세요." value="" type="text">
                                        </div>
                                        <div class="form-field">
                                            <input name="pw" id="cpassword1" class="full-width" placeholder="비밀번호를 입력해주세요." value="" type="password">
                                        </div>
                                        <div class="form-field">
                                            <input name="pw2" id="cpassword2" class="full-width" placeholder="비밀번호를 한번더 입력해주세요." value="" type="password">
                                        </div>

                                        <div class="form-field">
                                            <select name="location_no" id="caddress" class="full-width" placeholder="거주 지역을 선택해 주세요." value="">
                                              <option selected value="none">거주 지역을 선택해 주세요.</option>
                                              <option value="1">서울시</option>
                                              <option value="2">인천시</option>
                                              <option value="3">대전시</option>
                                              <option value="4">세종시</option>
                                              <option value="5">경기도</option>
                                              <option value="6">충청도</option>
                                              <option value="7">강원도</option>
                                              <option value="8">광주시</option>
                                              <option value="9">부산시</option>
                                              <option value="10">대구시</option>
                                              <option value="11">울산시</option>
                                              <option value="12">경상도</option>
                                              <option value="13">전라도</option>
                                            </select>
                                        </div>
                                        <div class="form-field">
                                            <input name="both" id="cBoth1" class="width45 both_input" placeholder="주민등록번호 앞 6자리를 입력해주세요." maxlength="6" oninput="maxLengthCheck(this)" value="" type="number">
                                            - <input name="gender" id="cBoth2" class="width45" placeholder="주민등록번호 뒤 1자리를 입력해주세요." maxlength="1" oninput="maxLengthCheck(this)" value="" type="number">
                                        </div>
                                        <div class="form-field">
                                            <input name="phone" id="cphone" class="full-width" placeholder="휴대폰 번호를 입력하세요." maxlength="11" oninput="maxLengthCheck(this)" value="" type="number">
                                        </div>
                                        <div style="text-align:center;">
                                        <input name="submit" id="submit" class="btn btn--primary btn-wide btn--large width48" value="가입 하기" type="submit">
                                        <input name="reset" id="reset" class="btn btn--default btn-wide btn--large width48" value="다시 작성" type="button">
                                      </div>
                                    </fieldset>
                                </form> <!-- end form -->

                            </div>
                            <!-- END respond-->

                        </div> <!-- end comment-respond -->

                    </div> <!-- end comments-wrap -->
                </main>

            </div> <!-- end s-content -->



          </div> <!-- end masonry-wrap -->

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
