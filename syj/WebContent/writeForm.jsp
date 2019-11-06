<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<script language="JavaScript" src="script.js"></script>
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
					<a class="site-logo" href="index.html"> <img
						src="images/logo.svg" alt="Homepage">
					</a>
				</div>

				<div class="header__search">

					<form role="search" method="get" class="header__search-form"
						action="#">
						<label> <span class="hide-content">Search for:</span> <input
							type="search" class="header__search-field"
							placeholder="Type Keywords" value="" name="s" title="Search for:"
							autocomplete="off">
						</label> <input type="submit" class="header__search-submit" value="Search">
					</form>

					<a href="#0" title="Close Search" class="header__search-close">Close</a>

				</div>
				<!-- end header__search -->

				<!-- toggles -->
				<a href="#0" class="header__search-trigger"></a> <a href="#0"
					class="header__menu-toggle"><span>Menu</span></a>

			</div>

			<nav class="header__nav-wrap">

				<ul class="header__nav">
					<li class="current has-children"><a href="index.html" title="">대나무숲
							입장 하기</a>
						<ul class="sub-menu">
							<li><a href="login.html">로그인</a></li>
							<li><a href="join.html">회원 가입</a></li>
						</ul></li>
					<li class="has-children"><a href="#0" title="">대나무숲 청원</a>
						<ul class="sub-menu">
							<li><a href="board.html">실시간 청원</a></li>
							<li><a href="loc_board.html">지역별 청원</a></li>
							<li><a href="exp_board.html">만료된 청원</a></li>
							<li><a href="answer_board.html">답변된 청원</a></li>
							<li><a href="faq.html">대나무숲 청원 FAQ</a></li>
						</ul></li>
					<li class="has-children"><a href="#0" title="">청원 하기</a>
						<ul class="sub-menu">
							<li><a href="write.html">지금 청원 하기</a></li>
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
							class="screen-reader-text">Instagram</span>
					</a></li>
					<li class="ss-behance"><a href="#0"> <span
							class="screen-reader-text">Behance</span>
					</a></li>
				</ul>

			</nav>
			<!-- end header__nav-wrap -->

		</header>
		<!-- end s-header -->


		<!-- site content
        ================================================== -->

		<div class="s-content content">
			<main class="row content__page">

			<div class="column large-12 comment-respond">

				<!-- START respond -->
				<div id="respond">

					<h3 class="h2">
						우리 동네에 <span>청원 하기</span>
					</h3>

					<form method="post" name="writeform" id="writeform"
						action="writePro.do" autocomplete="off"
						onsubmit="return writeSave()">

						<input type="hidden" name="no" value="${no}"> <input
							type="hidden" name="view" value="${view}">
						<fieldset>
							<div class="form-field">
								<input name="subject" id="subject" class="full-width"
									placeholder="청원제목을 입력해주세요." value="" type="text">
							</div>
							<div class="form-field">
								<select name="location" id="location" class="full-width"
									placeholder="지역을 선택해 주세요." value="${location}">
									<option selected>지역을 선택해 주세요.</option>
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


							<div class="message form-field">
								<textarea name="content" id="content" class="full-width"
									placeholder="청원 내용을 작성해 주세요."></textarea>
							</div>
							<div class="form-field">
								<input name="cimg" id="cimg" class="full-width"
									placeholder="사진을 업로드 해주세요. (선택항목)" value="" type="text">
							</div>
							<div class="form-field">
								<input name="cvideo" id="cvideo" class="full-width"
									placeholder="동영상을 업로드 해주세요. (선택항목)" value="" type="text">
							</div>

							<input name="submit" id="submit"
								class="btn btn--primary btn-wide btn--large full-width"
								value="작성 완료" type="submit">

						</fieldset>
					</form>
					<!-- end form -->

				</div>
				<!-- END respond-->

			</div>
			<!-- end comment-respond -->
		</div>
		<!-- end comments-wrap -->
		</main>

	</div>
	<!-- end s-content -->


	<!-- footer
        ================================================== -->
	<footer class="s-footer footer">
		<div class="row">
			<div class="column large-full footer__content">
				<div class="footer__copyright">
					<span>© Copyright Typerite 2019</span> <span>Design by <a
						href="https://www.styleshout.com/">StyleShout</a></span>
				</div>
			</div>
		</div>

		<div class="go-top">
			<a class="smoothscroll" title="Back to Top" href="#top"></a>
		</div>
	</footer>

	</div>
	<!-- end s-wrap -->


	<!-- Java Script
    ================================================== -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>

</body>
</html>
