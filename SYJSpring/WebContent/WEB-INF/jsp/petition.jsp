<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>실시간 청원</title>
</head>
<body>
	<h1><a href="../">대나무숲</a></h1>
	<h2>눌눔른</h2>
	<h2><c:if test="${param.l ne null}">&l=${param.l}</c:if></h2>
	<a href="petition/write">청원하기</a>
	<ul>
		<c:if test="${page.start > 1}"><li><a href="?p=${page.start-1}">&lt;</a></li></c:if>
		<c:forEach var="i" begin="${page.start}" end="${page.end}">
			<li>
				<c:choose>
					<c:when test="${i ne page.current}"><a href="?p=${i}">${i}</a></c:when>
					<c:otherwise>${i}</c:otherwise>
				</c:choose>
			</li>
		</c:forEach>
		<c:if test="${page.next}"><li><a href="?p=${page.end+1}">&gt;</a></li></c:if>
	</ul>
	<dl>
		<c:forEach var="post" items="${postList}">
			<dt>청원${post.no}</dt>
			<dd>
				<dl>
					<dt>제목</dt>
					<dd>${post.subject}</dd>
					<dt>내용</dt>
					<dd>${post.content}</dd>
					<dt>지역</dt>
					<dd>${post.location.name}</dd>
					<dt>조회수</dt>
					<dd>${post.view}</dd>
					<dt>작성시간</dt>
					<dd data-moment="${post.regdate}"></dd>
				</dl>
			</dd>
		</c:forEach>
	</dl>
	<ul>
		<c:if test="${page.start > 1}"><li><a href="?p=${page.start-1}">&lt;</a></li></c:if>
		<c:forEach var="i" begin="${page.start}" end="${page.end}">
			<li>
				<c:choose>
					<c:when test="${i ne page.current}"><a href="?p=${i}">${i}</a></c:when>
					<c:otherwise>${i}</c:otherwise>
				</c:choose>
			</li>
		</c:forEach>
		<c:if test="${page.next}"><li><a href="?p=${page.end+1}">&gt;</a></li></c:if>
	</ul>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"
			integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="></script>
	<script src="https://momentjs.com/downloads/moment-with-locales.min.js"></script>
	<script>
		$dataMoment = $('[data-moment]');
		
		moment.locale('ko');
		function syncMoment() {
			$dataMoment.each(function() {
				let fromNow = moment(this.dataset.moment).fromNow();
				if($(this).text() !== fromNow) $(this).text(fromNow);
			})
		}
		
		syncMoment();
		setInterval(syncMoment, 1000);
	</script>
</body>
</html>