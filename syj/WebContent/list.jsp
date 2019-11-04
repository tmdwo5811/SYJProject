<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- head태그 시작 -->
<%@ include file="templateFiles/headParts.jsp"%>
<!-- head태그 끝 -->

<body class="ss-bg-white">
	<!-- 사이드 메뉴 시작 -->
	<%@ include file="templateFiles/sideMenu.jsp"%>
	<!-- 사이드 메뉴 끝  -->

	<!-- site content
        ================================================== -->
	<c:if test="${pgList.count==0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
   <tr>
        <td align="center">게시판에 저장된 글이 없습니다.</td>
   </tr>
</table>
</c:if>
<c:if test="${pgList.count > 0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="#b0e0e6"> 
      <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >제   목</td> 
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td> 
      <td align="center"  width="50" >조 회</td> 
      <td align="center"  width="100" >IP</td>    
    </tr>
    <!-- 실질적으로 레코드를 출력시켜주는 부분 -->
    <c:set var="number" value="${pgList.number}"/>
    <c:forEach var="article" items="${articleList}">
   <tr height="30"  onmouseover="this.style.backgroundColor='white'" 
    	  onmouseout="this.style.backgroundColor='#e0ffff'" >
    	  <!-- 하나씩 감소하면서 출력하는 게시물번호 -->
    <td align="center"  width="50" >
          <c:out value="${number}" />
          <c:set var="number"  value="${number-1}" />
    </td>
    <td  width="250" ><!-- 커밋을 위한 수정 -->
	<!-- 답변글인 경우 먼저 답변이미지를 부착시키는 코드  -->
	
	 <c:if test="${article.re_level > 0}">
	  <img src="images/level.gif" width="${7*article.re_level}" height="16">
	  <img src="images/re.gif">
    </c:if><c:if test="${article.re_level==0}">
	  <img src="images/level.gif" width="${7*article.re_level}" height="16">
	    <!-- num(게시물번호),pageNum(페이지번호)  -->
	   </c:if>     
      <a href="/JspBoard2/content.do?num=${article.num}&pageNum=${currentPage}">
           ${article.subject}
           </a> 
         
         <c:if test="${article.readcount >=20}">
         <img src="images/hot.gif" border="0"  height="16">
         </c:if>
          </td>
    <td align="center"  width="100"> 
       <a href="mailto:${article.email}">${article.writer}</a></td>
    <td align="center"  width="150">
    <fmt:formatDate value="${article.reg_date}" timeStyle="medium" pattern="yy.MM.dd (hh:mm)"/> </td>
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
	   <c:if test="${pgList.currentPage==i}">
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
		<!-- footerParts 시작 -->
		<%@ include file="templateFiles/footerParts.jsp"%>
		<!-- footerParts 끝 -->
		<!-- Java Script
    ================================================== -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/plugins.js"></script>
		<script src="js/main.js"></script>
</body>
</html>