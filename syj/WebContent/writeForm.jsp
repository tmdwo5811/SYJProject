<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

                    <div class="column large-12 comment-respond">

                        <!-- START respond -->
                        <div id="respond">

                            <h3 class="h2">우리 동네에 <span>청원 하기</span></h3>

                            <form method="post"  name="writeform" id="writeform" action="/syj/writePro.do" autocomplete="off"  onsubmit="return writeSave()">
                            
		                            <input type="hidden" name="no" value="${no}">
		   							<input type="hidden" name="view" value="${view}">
                                <fieldset>
								<div class="form-field">
                                        <input name="subject" id="subject" class="full-width" placeholder="청원제목을 입력해주세요." value="" type="text">
                                    </div>
                                    <div class="message form-field">
                                        <textarea name="content" id="content" class="full-width" placeholder="청원 내용을 작성해 주세요."></textarea>
                                    </div>
                                    <div class="form-field">
                                        <input name="cimg" id="cimg" class="full-width" placeholder="사진을 업로드 해주세요. (선택항목)" value="" type="text">
                                    </div>
                                    <div class="form-field">
                                        <input name="cvideo" id="cvideo" class="full-width" placeholder="동영상을 업로드 해주세요. (선택항목)" value="" type="text">
                                    </div>

                                    <input name="submit" id="submit" class="btn btn--primary btn-wide btn--large full-width" value="작성 완료" type="submit">

                                </fieldset>
                            </form> <!-- end form -->

                        </div>
                        <!-- END respond-->

                    </div> <!-- end comment-respond -->

                </div> <!-- end comments-wrap -->
            </main>

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
