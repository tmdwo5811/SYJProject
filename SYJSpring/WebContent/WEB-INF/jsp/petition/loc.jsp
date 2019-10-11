<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="vo.Location"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>지역선택</title>
</head>
<body>
	<ul>
		<c:forEach var="location" varStatus="status" items="<%=Location.getArray()%>">
			<li><a href="loc/${status.count}">${location}</a></li>
		</c:forEach>
	</ul>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"
			integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="></script>
</body>
</html>