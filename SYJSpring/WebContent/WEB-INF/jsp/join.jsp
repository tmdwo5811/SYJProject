<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
</head>
<body>
	<form action="doJoin" method="post">
		<input name="id"> 아이디 <br>
		<input name="pw"> 비밀번호 <br>
		<label><input name="gender" type="radio" value="M">남자</label>
		<label><input name="gender" type="radio" value="F">여자</label>
		<br>
		<input name="both"> 생년월일 <br>
		<select name="location">
			<option value="1">서울특별시</option>
			<option value="2">부산광역시</option>
			<option value="3">대구광역시</option>
			<option value="4">인천광역시</option>
			<option value="5">광주광역시</option>
			<option value="6">대전광역시</option>
			<option value="7">울산광역시</option>
			<option value="8">세종특별자치시</option>
			<option value="9">경기도</option>
			<option value="10">강원도</option>
			<option value="11">충청북도</option>
			<option value="12">충청남도</option>
			<option value="13">전라북도</option>
			<option value="14">전라남도</option>
			<option value="15">경상북도</option>
			<option value="16">경상남도</option>
			<option value="17">제주특별자치도</option>
		</select> 지역 <br>
		<input name="addr"> 주소 <br>
		<input name="phone"> 전화번호 <br>
		<input name="email"> 이메일 <br>
		<button>회원가입</button>
	</form>
</body>
</html>