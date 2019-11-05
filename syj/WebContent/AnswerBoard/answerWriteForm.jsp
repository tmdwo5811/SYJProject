<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>답변게시판</title>
<!-- ===== 검색폼-->
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<!-- ===== -->
<!-- 부트스트랩 -->
<!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
</head>
<html>
<head>
<title>답변게시판</title>
<script language="JavaScript" src="script.js"></script>
</head>
<body>
	<center>
		<h3>답변글 작성</h3>
	</center>
	<br>
	<div class="container">
		<form method="post" name="answerWriteForm" action="answerWritePro.jsp"
		onsubmit="return writeSave()">
			<!-- 입력하지 않고 매개변수로 전달해서 테이블에 저장 *(hidden) -->
			<input type="hidden" name="no" value="${answer.no}"> <input
				type="hidden" name="post" value="${answer.post}"> <input
				type="hidden" name="content" value="${answer.content}"> <input
				type="hidden" name="regdate" value="${answer.regdate}">
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control input-sm" id="content" name="content"
					rows="20"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">작성</button>
			<button class="btn btn-primary">목록으로 돌아가기<a href="/syj/answerList.do"></a></button>
		</form>										<!-- answerList.jsp -->
	</div>

	<%-- 
  <!-- onsubmit이벤트 -->
<form method="post" name="writeform" action="answerWritePro.jsp"
	onsubmit="return writeSave()">
	<!-- 입력하지 않고 매개변수로 전달해서 테이블에 저장 *(hidden) -->
	<input type="hidden" name="no" value="${answer.no}">
	<input type="hidden" name="post" value="${answer.post}">
	<input type="hidden" name="content" value="${answer.content}">
	<input type="hidden" name="regdate" value="${answer.regdate}">

<table width="400" border="1" cellspacing="0" cellpadding="0" align="center">
   <tr>
    <td align="right" colspan="2">
	    <button><a href="answerList.jsp"> 글목록</a></button>
   </td>
   </tr>
   --%>
   <tr>
    <td  width="70" align="center">이 름</td>
    <td  width="330">
       <input type="text" size="10" maxlength="10" name="writer"></td>
  </tr>
  <%--
  <tr>
    <td  width="70" align="center" >제 목</td>
    <td  width="330">
    	<c:if test="${no==0}">
		<input type="text" size="40" maxlength="50" name="subject">
		</c:if>
    	<c:if test="${no!=0}">
		<input type="text" size="40" maxlength="50" name="subject" value="[re]">
		</c:if>
    </td>
  </tr>
  <tr>
    <td  width="70" align="center" >내 용</td>
    <td  width="330" >
     <textarea name="content" rows="13" cols="40"></textarea> </td>
  </tr>
<tr>
 <td colspan=2 align="center">
  <input type="submit" value="글쓰기" >
  <input type="reset" value="다시작성">
  <input type="button" value="목록보기" OnClick="window.location='/JspBoard2/list.do'">
  										<!-- "answerList.jsp" -->
</td>
</tr>
</table>
</form> --%>

</body>
</html>