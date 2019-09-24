<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- HTTPS required. HTTP will give a 403 forbidden response -->
<script src="https://sdk.accountkit.com/en_US/sdk.js"></script>
<script src="https://kit.fontawesome.com/af09124883.js" crossorigin="anonymous"> //fontawesome import 링크
</script>
<script type="text/javascript" src="js/script.js">
</script>
<link rel="stylesheet" href="css/style.css">
<title>우리 동네 대나무 숲</title>
</head>
<body>
	<header>
	<div class="toptoptop">
			<div class="box">
			  <div class="container-1">
			      <span class="icon"><i class="fa fa-search"></i></span>
			      <input type="search" id="search" placeholder="Search..." />
			  </div>
			</div>
	</div>
</header>
<div class="sidebart">
	<h1>
		<div class="logo"><a href="#"><img src="img/logo.png" alt="ourforest" title="OF"></a></div>
	</h1>
	<ul>
		<li>
			<a href="#" class="login_button">
				<i class="fas fa-user"></i> <span>로그인</span>
			</a>

		</li>
		<li>
			<a href="#" class="join_button">
				<i class="fas fa-sign-in-alt"></i> <span>회원가입</span>
			</a>
		</li>
	</ul>
</div>
<div class="sidebarf">
	<form action="" class="l_form">
	<div class="cl_lj_div">
		<label for="id_l_textbox">아이디를 입력하세요.</label>
		<input id="id_l_textbox" class="l_textbox" type="text">
	</div>
	<div class="cl_lj_div">
		<label for="id_j_textbox">비밀번호를 입력하세요.</label>
		<input class="l_textbox" type="password" id="id_j_textbox"><br>
	</div>
		<input type="submit" value="로그인" class="l_button">
	</form>
	<form action="" class="j_form">
		<div class="cl_j_div">
			<label for="id_user_textbox">사용할 아이디를 입력하세요.</label>
			<input id="id_user_textbox" class="j_textbox" type="text"><br>
		</div>
		<div class="cl_j_div">
			<label for="id_j_pass1">사용할 비밀번호를 입력하세요.</label>
			<input id="id_j_pass1"class="j_textbox" type="password">
		</div>
		<div class="cl_j_div">
			<label for="id_j_pass2">비밀번호를 한번 더 입력하세요.</label>
			<input id="id_j_pass2"class="j_textbox" type="password">
		</div>
		<div class="cl_j_div">
			<label for="id_j_both">주민번호 앞 7자리 까지 입력하세요.</label>
			<input id="id_j_both" class="j_textbox" type="number" maxLength="7" oninput="maxLengthCheck(this)">
		</div>

		<!-- 성별 : <input type="radio" name="gender">남자 <input type="radio" name="gender">여자<br><br>
		생년월일 :<input class="j_both" type="date" value="생년월일 yyyy-mm-dd" style="width:173px;"><br><br> -->
		<div class="selectbox">
			<label for="select">지역 선택</label>
			<select id="select">
				<option selected>지역 선택</option>
				<option>서울시</option>
				<option>인천시</option>
				<option>대전시</option>
				<option>세종시</option>
				<option>경기도</option>
				<option>충청도</option>
				<option>강원도</option>
				<option>광주시</option>
				<option>부산시</option>
				<option>대구시</option>
				<option>울산시</option>
				<option>경상도</option>
				<option>전라도</option>
			</select>
	</div>
		<input type="submit" class="j_button" value="약관에 동의하며 회원가입" style="font-size:15px;text-align:left;padding-left:17px;margin-top:5px;">
	</form>
		<div class="j_menual">
		<a href="#">회원가입약관</a> / <a href="#">개인정보 취급 방침</a>
		</div>
<div class="sidebar_cate">
	<ul>
		<li><a href="#" class="loc_p_li"><i class="fas fa-comments"></i> <span>지역별 청원</span></a>
			<ul class="loc_s_li">
				<li><a href="#">서울시</a></li>
				<li><a href="#">인천시</a></li>
				<li><a href="#">대전시</a></li>
				<li><a href="#">세종시</a></li>
				<li><a href="#">경기도</a></li>
				<li><a href="#">충청도</a></li>
				<li><a href="#">강원도</a></li>
				<li><a href="#">광주시</a></li>
				<li><a href="#">부산시</a></li>
				<li><a href="#">대구시</a></li>
				<li><a href="#">울산시</a></li>
				<li><a href="#">경상도</a></li>
				<li><a href="#">전라도</a></li>
			</ul>
		</li>
		<li><a href="#"><i class="fas fa-gavel"></i> <span>답변된 청원</span></a>
			<ul>
				<li><a href="#">전체 보기</a></li>
				<li><a href="#">우리 동네 보기</a></li>
			</ul>
		</li>
		<li><a href="#"><i class="fas fa-paper-plane"></i> <span>청원 하기</span></a>
			<ul>
				<li><a href="#">지금 청원하기</a></li>
				<li><a href="#">내 청원보기</a></li>
			</ul>
		</li>
		<li><a href="#"><i class="fas fa-tree"></i> <span>대나무숲</span></a>
			<ul>
				<li><a href="#">사진 자료실</a></li>
				<li><a href="#">동영상 자료실</a></li>
				<li><a href="#">우리 동네 소식 보기</a></li>
				<li><a href="#">다른 동네 소식 보기</a></li>
			</ul>
		</li>
	</ul>
</div>

<div class="contents">
</div>
</body>
</html>
