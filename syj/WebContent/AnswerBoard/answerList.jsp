<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>답변게시판</title>
</head>
<body>
<center><h2>답변게시판(전체 글:${pgList.count})</h2>
<table width="700">

<!-- <tr>
    <td align="right">
    <button><a href="answerWriteForm.jsp">글쓰기</a></button>
    </td>
</tr> -->

</table>
<!-- 데이터의 유무  -->

<c:if test="${pgList.count==0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
   <tr>
        <td align="center">게시판에 저장된 글이 없습니다.</td>
   </tr>
</table>
</c:if>
<c:if test="${pgList.count > 0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
    <tr height="30">
      <td align="center"  width="50">No.</td>
      <td align="center"  width="250">제   목</td>
      <td align="center"  width="100">작성자</td>
      <td align="center"  width="150">작성일</td>
      <td align="center"  width="50">조회수</td>
      <td align="center"  width="100">IP</td>
    </tr>

    <!-- 실질적으로 레코드를 출력시켜주는 부분 -->

    <c:set var="number" value="${pgList.number}"/>
    <c:forEach var="article" items="${articleList}">
   <tr height="30" onmouseover="this.style.backgroundColor='lightgray'"
   				   onmouseout="this.style.backgroundColor='white'"><!-- 하나씩 감소하면서 출력하는 게시물번호 -->
    <td align="center"  width="50" >
          <c:out value="${number}" />
          <c:set var="number"  value="${number-1}" />
    </td>
    <td  width="250" >

	  <!-- 답변글인 경우 먼저 답변이미지를 부착시키는 코드  -->

	 <c:if test="${article.re_level > 0}"/>
   <c:if test="${article.re_level==0}"/>

	  <!-- num(게시물번호),pageNum(페이지번호)  -->

      <a href="/JspBoard2/content.do?num=${article.num}&pageNum=${pgList.currentPage}">
           ${article.subject}
           </a>

         <c:if test="${article.readcount >=20}"/>
          </td>
    <td align="center"  width="100">
       <a href="mailto:${article.email}">${article.writer}</a></td>
    <td align="center"  width="150"><%-- ${article.reg_date} --%>
    	<fmt:formatDate value="${article.reg_date}" timeStyle="medium"
    					pattern="yy-MM-dd(hh:mm)"/>
    </td>
    <td align="center"  width="50">${article.readcount}</td>
    <td align="center" width="100" >${article.ip}</td>
  </tr>
   </c:forEach>
</table>
</c:if>

<!-- 페이징 처리  -->

    <c:if test="${pgList.startPage > pgList.blockSize}">
    	<a href="/JspBoard2/list.do?pageNum=${pgList.startPage-pgList.blockSize}&search=${search}&searchtext=${searchtext}">[이전]</a>
    </c:if>
    <c:forEach var="i" begin="${pgList.startPage}" end="${pgList.endPage}">
    	<a href="/JspBoard2/list.do?pageNum=${i}&search=${search}&searchtext=${searchtext}">
    	<c:if test="${pgList.currentPage==i}"> <%-- [${i}] --%>
    		<font color="red"><b>[${i}]</b></font>
    	</c:if>
    	<c:if test="${pgList.currentPage!=i}">
    		${i}
    	</c:if>
    	</a>
    </c:forEach>
    <c:if test="${pgList.endPage < pgList.pageCount}">
    	<a href="/JspBoard2/list.do?pageNum=${pgList.startPage+pgList.blockSize}&search=${search}&searchtext=${searchtext}">[다음]</a>
    </c:if>
	<p>
	<!-- 검색어 추가(자주검색이 되는 항목을 잘 선택) 제목, 작성자, 제목+본문
		ex)search.do->새로운 요청명령어를 이용하여 추가
			list.do->기존의 내용을 추가 -->
	<form name="test" action="/JspBoard2/list.do">
		<select name="search">
			<option value="subject">제목</option>
			<option value="subject_content">제목+본문</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" size="15" name="searchtext">&nbsp;
		<input type="submit" value="Search">
	</form>
</center>
</body>
</html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

</body>
</html>
