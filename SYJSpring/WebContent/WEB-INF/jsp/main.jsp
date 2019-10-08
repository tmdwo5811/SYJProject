<%@page import="vo.Location"%>
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
				<c:choose>
					<c:when test="${loginInfo eq null}">
						<legend>로그인</legend>
						<dl>
							<dt>아이디</dt>
							<dd><input name="id"></dd>
							<dt>비밀번호</dt>
							<dd><input name="pw" type="password"></dd>
						</dl>
						<div><button>로그인</button></div>
					</c:when>
					<c:otherwise>
						<dl>
							<dt>회원번호</dt>
							<dd>${loginInfo.no}</dd>
							<dt>성별</dt>
							<dd>${loginInfo.gender}</dd>
							<dt>생년월일</dt>
							<dd>${loginInfo.both}</dd>
							<dt>지역</dt>
							<dd>${loginInfo.location.no}</dd>
							<dt>credential</dt>
							<dd>${loginInfo.credential ne null}</dd>
						</dl>
					</c:otherwise>
				</c:choose>
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
						<select name="loc">
							<c:forEach varStatus="status" var="loc" items="<%=Location.getArray()%>">
								<option value="${status.count}">${loc}</option>
							</c:forEach>
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
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"
			integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="></script>
</body>
</html>