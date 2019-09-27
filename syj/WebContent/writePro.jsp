<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.Timestamp,dao.*,vo.*"%>
    <%
   	//한글처리
   	request.setCharacterEncoding("utf-8");
    //BoardDTO->Setter Method(5)+hidden(4)
    //BoardDTO article=new BoardDTO();
    //BoardDAO 객체필요->insertArticle호출
    %>
<jsp:useBean id="article" class="vo.Post"/>
<jsp:setProperty name="article" property="*"/>
<%
//BoardDAO객체->insertArticle(article)=>9개->10개->12개(readcount(0),num)
Timestamp temp=new Timestamp(System.currentTimeMillis());//컴퓨터의 날짜,시간
article.setRegdate(temp);//오늘 날짜계산


BoardDAO dbPro=new BoardDAO();
dbPro.insertArticle(article);
response.sendRedirect("list.jsp");//입력한후 다시 DB접속->새로 고침해서 화면에 새로운 글 반영
%>
