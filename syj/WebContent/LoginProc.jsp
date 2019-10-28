<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
          
<c:set var="loginCheck" value="${requestScope.loginCheck}"/>
  <c:choose>
    <c:when test="${loginCheck==true}">
    <c:set var="idKey" value="${requestScope.id}" scope="session"/>
    <meta http-equiv="Refresh" content="0;url=/syj/login.do">
	</c:when>
	<c:otherwise>
	<meta http-equiv="Refresh" content="0;url=/syj/LogError.do">
	</c:otherwise>
  </c:choose>