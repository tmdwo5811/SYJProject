<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- head태그 시작 -->
<%@ include file="templateFiles/headParts.jsp"%>
<!-- head태그 끝 -->

<body class="ss-bg-white">
   <!-- 사이드 메뉴 시작 -->
   <%@ include file="templateFiles/sideMenu.jsp"%>
   <!-- 사이드 메뉴 끝  -->

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