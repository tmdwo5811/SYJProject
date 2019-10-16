<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>대나무숲</title>
</head>
<body>
	<h1><a href="#">대나무숲</a></h1>
	<dl>
		<dt>대나무숲 입장</dt>
		<c:choose>
			<c:when test="${loginInfo eq null}">
				<dd><a href="login">로그인</a></dd>
				<dd><a href="join">회원가입</a></dd>
			</c:when>
			<c:otherwise>
				<dd><a href="doLogout">로그아웃</a></dd>
			</c:otherwise>
		</c:choose>
		<dt>대나무숲 청원</dt>
		<dd><a href="petition">실시간 청원</a></dd>
		<dd><a href="petition">지역별 청원</a></dd>
	<!--<dd><a href="petition/loc/4">지역별 청원</a></dd>-->
		<dd><a href="petition/expired">만료된 청원</a></dd>
		<dd><a href="answer">답변된 청원</a></dd>
		<dd><a href="faq">대나무숲 청원 FAQ</a></dd>
		<dt>청원 하기</dt>
		<dd><a href="petition/write">청원 하기</a></dd>
		<dt>대나무 숲</dt>
		<dd><a href="file/img">사진 자료실</a></dd>
		<dd><a href="file/video">동영상 자료실</a></dd>
		<dd><a href="#">지역별 소식 보기</a></dd>
		<dd><a href="#">청원 진행 과정</a></dd>
	</dl>
</body>
</html>