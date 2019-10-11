<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>청원하기</title>
</head>
<body>
	<h1><a href="../">대나무숲</a></h1>
	<form action="doWrite" method="post">
		<fieldset>
			<legend>청원하기</legend>
			<dl>
				<dt>제목</dt>
				<dd><input name="subject" required></dd>
				<dt>내용</dt>
				<dd><input name="content" required></dd>
				<dt>참고링크</dt>
				<dd><input name="link"></dd>
				<dt>사진</dt>
				<dd><input name="img" type="file"></dd>
				<dt>동영상</dt>
				<dd><input name="video"></dd>
			</dl>
			<div><button>청원</button></div>
		</fieldset>
	</form>
</body>
</html>