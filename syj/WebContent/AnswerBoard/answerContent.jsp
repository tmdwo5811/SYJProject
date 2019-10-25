<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#fff">  
<center><b>글내용 보기</b>
<br>
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0"  bgcolor="#fff" align="center">  
  <tr height="30">
    <td align="center" width="125" bgcolor="gray">글번호</td>
    <td align="center" width="125" align="center">
	     ${article.num}</td>
    <td align="center" width="125" bgcolor="gray">조회수</td>
    <td align="center" width="125" align="center">
	     ${article.readcount}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125" bgcolor="gray">작성자</td>
    <td align="center" width="125" align="center">
	     ${article.writer}</td>
    <td align="center" width="125" bgcolor="gray" >작성일</td>
    <td align="center" width="125" align="center">
	     ${article.reg_date}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125" bgcolor="gray">글제목</td>
    <td align="center" width="375" align="center" colspan="3">
	    ${article.subject}</td>
  </tr>
  <tr>
    <td align="center" width="125" bgcolor="gray">글내용</td>
    <td align="left" width="375" colspan="3"><pre>${article.content}</pre></td>
  </tr>
  <tr height="30">      
    <td colspan="4" bgcolor="#gray" align="right" > 
	  <input type="button" value="글수정" 
       onclick="document.location.href='/syj/updateForm.do?num=${article.num}&pageNum=${pageNum}'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
	  <input type="button" value="글삭제" 
       onclick="document.location.href='/syj/deleteForm.do?num=${article.num}&pageNum=${pageNum}'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
       <input type="button" value="글목록"
       onclick="document.location.href='/syj/answerList.do?pageNum=${pageNum}'">
    </td>
  </tr>
</table>    
</form>      
</body>
</html>      
