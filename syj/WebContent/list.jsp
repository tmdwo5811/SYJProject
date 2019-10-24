<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>Video Post - Typerite</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- mobile specific metas
    ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/vendor.css">
    <link rel="stylesheet" href="css/main.css">

    <!-- script
    ================================================== -->
    <script src="js/modernizr.js"></script>

    <!-- favicons
    ================================================== -->
    <link rel="apple-touch-icon" sizes="180x180" href="apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png">
    <link rel="manifest" href="site.webmanifest">

</head>

<body class="ss-bg-white">

    <!-- preloader
    ================================================== -->
    <div id="preloader">
        <div id="loader" class="dots-fade">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>

    <div id="top" class="s-wrap site-wrapper">

        <!-- site header
        ================================================== -->
        <header class="s-header header">

            <div class="header__top">
                <div class="header__logo">
                    <a class="site-logo" href="index.html">
                        <img src="images/logo.svg" alt="Homepage">
                    </a>
                </div>

                <div class="header__search">

                    <form role="search" method="get" class="header__search-form" action="#">
                        <label>
                            <span class="hide-content">대나무숲 찾아보기:</span>
                            <input type="search" class="header__search-field" placeholder="검색어를 입력하세요." value="" name="s" title="Search for:" autocomplete="off">
                        </label>
                        <input type="submit" class="header__search-submit" value="Search">
                    </form>
                    <a href="#0" title="Close Search" class="header__search-close">Close</a>

                </div>  <!-- end header__search -->

                <!-- toggles -->
                <a href="#0" class="header__search-trigger"></a>
                <a href="#0" class="header__menu-toggle"><span>Menu</span></a>

            </div>

            <nav class="header__nav-wrap">

              <ul class="header__nav">
                  <li class="current has-children">
                      <a href="index.html" title="">대나무숲 입장 하기</a>
                      <ul class="sub-menu">
                      <li><a href="login.html">로그인</a></li>
                      <li><a href="join.html">회원 가입</a></li>
                      </ul>
                  </li>
                  <li class="has-children">
                      <a href="#0" title="">대나무숲 청원</a>
                      <ul class="sub-menu">
                      <li><a href="board.html">실시간 청원</a></li>
                      <li><a href="loc_board.html">지역별 청원</a></li>
                      <li><a href="exp_board.html">만료된 청원</a></li>
                      <li><a href="answer_board.html">답변된 청원</a></li>
                      <li><a href="faq.html">대나무숲 청원 FAQ</a></li>
                      </ul>
                  </li>
                  <li class="has-children">
                      <a href="#0" title="">청원 하기</a>
                      <ul class="sub-menu">
                      <li><a href="write.html">지금 청원 하기</a></li>
                      </ul>
                  </li>
                  <li class="has-children">
                      <a href="page-about.html" title="">대나무 숲</a>
                      <ul class="sub-menu">
                      <li><a href="img_storage.html">사진 자료실</a></li>
                      <li><a href="video_storage.html">동영상 자료실</a></li>
                      <li><a href="Advertising.html">지역별 소식 보기</a></li>
                      <li><a href="status.html">청원 진행 과정</a></li>
                      </ul>
                  </li>
              </ul> <!-- end header__nav -->

                <ul class="header__social">
                    <li class="ss-facebook">
                        <a href="https://facebook.com/">
                            <span class="screen-reader-text">Facebook</span>
                        </a>
                    </li>
                    <li class="ss-twitter">
                        <a href="#0">
                            <span class="screen-reader-text">Twitter</span>
                        </a>
                    </li>
                    <li class="ss-dribbble">
                        <a href="#0">
                            <span class="screen-reader-text">Instagram</span>
                        </a>
                    </li>
                    <li class="ss-behance">
                        <a href="#0">
                            <span class="screen-reader-text">Behance</span>
                        </a>
                    </li>
                </ul>

            </nav> <!-- end header__nav-wrap -->

        </header> <!-- end s-header -->


        <!-- site content
        ================================================== -->
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
                            <li class="depth-1 comment">
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
                                    <div class="comment__text">
                                    <p>Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem.</p>
                                    </div>

                                </div><!-- comment__avatar -->

                            </li>  <!-- depth-1 comment -->

                        </ol>
                        <!-- END commentlist -->

                    </div> <!-- end comments -->
					    <c:set var="number" value="${pgList.number}"/>
					    <c:forEach var="article" items="${articleList}">
					   <tr height="30"  onmouseover="this.style.backgroundColor='white'" 
					    	  onmouseout="this.style.backgroundColor='#e0ffff'" >
					    	  <!-- 하나씩 감소하면서 출력하는 게시물번호 -->
					    <td align="center"  width="50" >
					          <c:out value="${number}" />
					          <c:set var="number"  value="${number-1}" />
					    </td>
					    <td  width="250" >
						<!-- 답변글인 경우 먼저 답변이미지를 부착시키는 코드  -->
					
					   </c:forEach>
                 </div>
            </main>
            <!--여기  -->
		</div>
	</c:if>
        </div> <!-- end s-content -->


        <!-- footer
        ================================================== -->
<!--         <footer class="s-footer footer">
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

    </div> end s-wrap

 -->
    <!-- Java Script
    ================================================== -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/main.js"></script>

</body>
</html>