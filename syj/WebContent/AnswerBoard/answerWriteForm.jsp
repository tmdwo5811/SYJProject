<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>답변게시판</title>
<script language="JavaScript" src="script.js"></script>
</head>
<body>
<center><h3>답변글 작성</h3>
<br>
  <!-- onsubmit이벤트 -->
<form method="post" name="writeform" action="/JspBoard2/writePro.do"
	onsubmit="return writeSave()">
	<!-- 입력하지 않고 매개변수로 전달해서 테이블에 저장 *(hidden) -->
	<input type="hidden" name="num" value="${num}">
	<input type="hidden" name="ref" value="${ref}">
	<input type="hidden" name="re_step" value="${re_step}">
	<input type="hidden" name="re_level" value="${re_level}">

<table width="400" border="1" cellspacing="0" cellpadding="0" align="center">
   <tr>
    <td align="right" colspan="2">
	    <button><a href="/JspBoard2/list.do"> 글목록</a></button>
   </td>
   </tr>
   <tr>
    <td  width="70" align="center">이 름</td>
    <td  width="330">
       <input type="text" size="10" maxlength="10" name="writer"></td>
  </tr>
  <tr>
    <td  width="70" align="center" >제 목</td>
    <td  width="330">
    	<c:if test="${num==0}">
		<input type="text" size="40" maxlength="50" name="subject">
		</c:if>
    	<c:if test="${num!=0}">
		<input type="text" size="40" maxlength="50" name="subject" value="[re]">
		</c:if>
    </td>
  </tr>
  <tr>
    <td  width="70" align="center">Email</td>
    <td  width="330">
       <input type="text" size="40" maxlength="30" name="email" ></td>
  </tr>
  <tr>
    <td  width="70" align="center" >내 용</td>
    <td  width="330" >
     <textarea name="content" rows="13" cols="40"></textarea> </td>
  </tr>
  <tr>
    <td  width="70" align="center" >비밀번호</td>
    <td  width="330" >
     <input type="password" size="8" maxlength="12" name="passwd">
	 </td>
  </tr>
<tr>
 <td colspan=2 align="center">
  <input type="submit" value="글쓰기" >
  <input type="reset" value="다시작성">
  <input type="button" value="목록보기" OnClick="window.location='/JspBoard2/list.do'">
</td>
</tr>
</table>
</form>
</body>
</html>
