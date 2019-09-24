<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>메인 페이지</title>
</head>
<body>
	<div>
		<form action="doLogin" method="post">
			<fieldset>
				<legend>로그인</legend>
				<dl>
					<dt>아이디</dt>
					<dd><input name="id"></dd>
					<dt>비밀번호</dt>
					<dd><input name="pw" type="password"></dd>
				</dl>
				<div><button>로그인</button></div>
			</fieldset>
		</form>
		<form action="doJoin" method="post">
			<fieldset>
				<legend>회원가입</legend>
				<dl>
					<dt>아이디</dt>
					<dd><input name="id" required></dd>
					<dt>비밀번호</dt>
					<dd><input name="pw" type="password" required></dd>
					<dt>비밀번호 확인</dt>
					<dd><input id="confirm" type="password" required></dd>
					<dt>주민등록번호</dt>
					<dd><input name="rrn1" maxlength="6" required> - <input name="rrn2" type="password" size="1" maxlength="1" required><span>●●●●●●</span></dd>
					<dt>지역</dt>
					<dd>
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
						</select>
					</dd>
					<dt>주소</dt>
					<dd><input name="addr"></dd>
					<dt>전화번호</dt>
					<dd><input name="phone" required></dd>
					<dt>E-Mail</dt>
					<dd><input name="email"></dd>
				</dl>
				<div><button>회원가입</button></div>
			</fieldset>
		</form>
	</div>
	${loginInfo}
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"
			integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="></script>
</body>
</html>