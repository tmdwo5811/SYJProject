<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>로그인</title>
</head>
<body>
	<h1><a href="./">대나무숲</a></h1>
	<form action="doLogin" method="post">
		<fieldset>
			<legend>로그인</legend>
			<dl>
				<dt>아이디</dt>
				<dd><input name="id" required></dd>
				<dt>비밀번호</dt>
				<dd><input name="pw" type="password" required></dd>
			</dl>
			<div><button>로그인</button></div>
		</fieldset>
	</form>
</body>
</html>