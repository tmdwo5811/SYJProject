<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<header class="s-header">

		<div class="header__top">
			<div class="header__logo">
				<a class="site-logo" href="index.jsp">
					<img src="images/logo1233.png" alt="Homepage">
				</a>
			</div>
			<div class="header__search">
				<form role="search" method="get" class="header__search-form"
					action="#">
					<label> <span class="hide-content">청원 검색 하기 :</span> <input
						type="search" class="header__search-field"
						placeholder="Type Keywords" value="" name="s" title="Search for:"
						autocomplete="off">
					</label> <input type="submit" class="header__search-submit" value="Search">
				</form>
				<a href="#0" title="Close Search" class="header__search-close">닫기</a>
			</div>
			<!-- end header__search -->

			<!-- toggles -->
			<a href="#0" class="header__search-trigger"></a> <a href="#0"
				class="header__menu-toggle"><span>Menu</span></a>

		</div>
		<!-- end header__top -->

		<nav class="header__nav-wrap">

			<ul class="header__nav">
				<li class="current has-children"><a href="index.jsp" title="">대나무숲
						입장 하기</a>
					<ul class="sub-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join_test.jsp">회원 가입</a></li>
					</ul></li>
				<li class="has-children"><a href="#0" title="">대나무숲 청원</a>
					<ul class="sub-menu">
						<li><a href="board.jsp">실시간 청원</a></li>
						<li><a href="loc_board.jsp">지역별 청원</a></li>
						<li><a href="exp_board.jsp">만료된 청원</a></li>
						<li><a href="answer_board.jsp">답변된 청원</a></li>
						<li><a href="faq.jsp">대나무숲 청원 FAQ</a></li>
					</ul></li>
				<li class="has-children"><a href="#0" title="">청원 하기</a>
					<ul class="sub-menu">
						<li><a href="writeForm.jsp">지금 청원 하기</a></li>
					</ul></li>
				<li class="has-children"><a href="page-about.html" title="">대나무
						숲</a>
					<ul class="sub-menu">
						<li><a href="img_storage.html">사진 자료실</a></li>
						<li><a href="video_storage.html">동영상 자료실</a></li>
						<li><a href="Advertising.html">지역별 소식 보기</a></li>
						<li><a href="status.html">청원 진행 과정</a></li>
					</ul></li>
			</ul>
			<!-- end header__nav -->

			<ul class="header__social">
				<li class="ss-facebook"><a href="https://facebook.com/"> <span
						class="screen-reader-text">Facebook</span>
				</a></li>
				<li class="ss-twitter"><a href="#0"> <span
						class="screen-reader-text">Twitter</span>
				</a></li>
				<li class="ss-dribbble"><a href="#0"> <span
						class="screen-reader-text">Dribbble</span>
				</a></li>
				<li class="ss-pinterest"><a href="#0"> <span
						class="screen-reader-text">Behance</span>
				</a></li>
			</ul>

		</nav>
		<!-- end header__nav-wrap -->
	</header>
	<!-- end s-header -->
	