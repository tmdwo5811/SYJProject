
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<!-- head태그 시작 -->
	<%@ include file="templateFiles/headParts.jsp"%>
	<!-- head태그 끝 -->
<body onload="printClock()">
	<!-- 사이드 메뉴 시작 -->
	<%@ include file="templateFiles/sideMenu.jsp"%>
	<!-- 사이드 메뉴 끝  -->
	<div class="s-content">
		<div style="float:left">안녕하세요<br>안녕하세요<br>안녕하세요<br>안녕하세요<br>안녕하세요<br>안녕하세요<br>
		
		
		</div>
		<div id="app000" class="container000" style="float:right">
			<card data-image="images/seoul.jpg">
			<div class="h1text" slot="header" id="clock1234"></div>
			<div class="subtext111" slot="content"><br>우리동네 대나무숲에 오신것을<br>환영합니다.</div>
			</card>
		</div>
		<script
			src='https://cdnjs.cloudflare.com/ajax/libs/vue/2.0.1/vue.min.js'></script>
		<script src="js/vuescript.js"></script>
	</div>
	<div style="clear:both"></div>
	<!-- end content -->
	<!-- footerParts 시작 -->
	<%@ include file="templateFiles/footerParts.jsp"%>
	<!-- footerParts 끝 -->
	<!-- Java Script
    ================================================== -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>

</body>