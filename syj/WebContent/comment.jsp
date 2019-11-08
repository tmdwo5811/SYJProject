<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
	<!-- head태그 시작 -->
	<%@ include file="templateFiles/headParts.jsp"%>
	<!-- head태그 끝 -->
<body class="ss-bg-white">
	<!-- 사이드 메뉴 시작 -->
	<%@ include file="templateFiles/sideMenu.jsp"%>
	<!-- 사이드 메뉴 끝  -->


        <!-- site content
        ================================================== -->
        <div class="s-content content">
            <main class="row content__page">

                <div class="comments-wrap">

                    <div id="comments" class="column large-12">

                        <h3 class="h2">청원 전체 목록 [최신순]</h3>
                        <div style="float:right;">
                        </div>
                        <!-- START commentlist -->
                        <ol class="commentlist">

                            <li class="depth-1 comment">

                                <div class="comment__avatar">
                                    <img class="avatar" src="images/avatars/user-01.jpg" alt="" width="50" height="50">
                                </div>

                                <div class="comment__content">

                                    <div class="comment__info">
                                        <div class="post_no">게시글 번호 5</div>
                                        <div class="comment__author">작성자 이름 예시</div>
                                        <div class="comment__meta">
                                            <div class="comment__time">April 30, 2019</div>
                                            <div class="comment__reply">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="comment__text">
                                    <p>
                                    Adhuc quaerendum est ne, vis ut harum tantas noluisse, id suas iisque mei. Nec te inani ponderum vulputate,
                                    facilisi expetenda has et. Iudico dictas scriptorem an vim, ei alia mentitum est, ne has voluptua praesent.
                                    </p>
                                    </div>
                                    <!-- 댓글 위치 -->
                                    <form method="post" name="add_form" action="comment.do">
	                                  <table width="500" cellspacing="0" cellpadding="0" align="center" bgcolor="ffffff">
	                                    <tr>
	                                    	<td style=padding:10;><align=absmiddle>
	                                    		<input type="hidden" name="writer" size="20" value="테스트김">&nbsp;테스트김
	                                    	</td>
	                                    	<td style=padding:10;>
	                                    	<textarea name="content" rows="1" cols="60"></textarea>
	                                    	<input type="hidden" name="num" value="11111">
											<input type="hidden" name="pageNum" value="">
											<input type="hidden" name="writer_id" value="테스트김">
											<input type="hidden" name="content" value="content" placeholder="내용을 입력해 주세요.">
	                                    	</td>
	                                    	<td style=padding:5;>
	                                    	<input type="submit" value="작성">
	                                    	</td>
	                                    	
	                                    </tr>
	                                  </table>
	                                </form>
                                    </div>
                                </div>

                            </li> <!-- end comment level 1 -->

                        </ol>
                        <!-- END commentlist -->

                    </div> <!-- end comments -->
            </main>

        </div> <!-- end s-content -->


        <!-- footer
        ================================================== -->
        <footer class="s-footer footer">
            <div class="row">
                <div class="column large-full footer__content">
                    <div class="footer__copyright">
                        <span>© Copyright Typerite 2019</span>
                        <span>Design by <a href="https://www.styleshout.com/">StyleShout</a></span>
                    </div>
                </div>
            </div>

            <div class="go-top">
                <a class="smoothscroll" title="Back to Top" href="#top"></a>
            </div>
        </footer>
			
    </div> <!-- end s-wrap -->
	

    <!-- Java Script
    ================================================== -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/main.js"></script>

</body>