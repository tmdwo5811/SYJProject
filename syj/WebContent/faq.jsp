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
		<h2>청원 F A Q</h2>
		<div class="line"></div>
		<hr>
		<div class="faq-content">
			<div class="faq-question">
				<input id="q1" type="checkbox" class="panel"> 
				<label for="q1" class="panel-title">Q. 국민청원 어떻게 참여하나요?</label>
				<div class="panel-content">
					<ul>
						<li>누구라도 트위터, 페이스북, 네이버, 카카오 중 보유 계정으로 소셜로그인을 통해 직접 청원글을
							작성하거나, 진행 중인 청원에 동의하실 수 있습니다. 한 번 작성하거나 동의한 청원에 대해서는 삭제나 철회하실 수
							없습니다.</li>
						<li>홈페이지에 공개된 청원은 누구나 자유롭게 열람할 수 있습니다.</li>
					</ul>
				</div>
			</div>

			<div class="faq-question">
				<input id="q2" type="checkbox" class="panel">
				<label for="q2" class="panel-title">Q. 국민청원 게시글 어떻게 작성하나요?</label>
				<div class="panel-content">
					<ul>
						<li>새 청원글 작성 전, 진행 중인 청원을 먼저 검색하시면 유사한 청원이 게시되었는지 확인하실 수
							있습니다. 새로운 청원글을 작성하는 대신 기존유사 청원에 동참하시면 국민의 뜻을 한 곳으로 모으는데 도움이 됩니다.</li>
						<li>새 청원글 작성 시, 내용을 대표하는 제목 및 관련 분야를 선택하신 후 내용을 입력해주시면 됩니다.</li>
						<li>청원 내용과 관련 있는 웹사이트 또는 영상 URL이 있다면 첨부해주시기 바랍니다.</li>
						<li>청원 내용의 주요 키워드를 태그란에 입력해주시면 다른 참여자들이 여러분들의 청원을 쉽게 찾는 데 도움이
							됩니다.</li>
						<li>마지막으로, 입력하신 모든 내용을 신중하게 검토한 뒤 청원을 등록해주시기 바랍니다. 한번 작성된 청원은
							수정 및 삭제가 불가능합니다. 최초 청원 취지와 다른 내용으로 변경되는 것을 방지하기 위한 것이니 신중한 작성
							부탁드립니다.</li>
					</ul>
				</div>
			</div>

			<div class="faq-question">
				<input id="q3" type="checkbox" class="panel"> 
				<label for="q3" class="panel-title">Q. 국민청원 게시판에 공개되기 위해서는 '100명의
					사전동의'가 필요합니다.</label>
				<div class="panel-content">
					<ul>
						<li>청원글 작성 완료 시, 여러분에게 ‘사전동의 링크(URL)’가 부여됩니다.</li>
						<li>30일 이내에 여러분의 청원을 지지하는 100명의 사전 동의를 받으셔야 청원게시판에 청원 내용이
							공개되어 더 많은 국민께서 청원에 동참하실 수 있게 됩니다.</li>
						<li>‘사전동의 링크(URL)’를 SNS 등에 공유해 사전 동의를 받아주세요. 사전 동의는 제공된 ‘사전동의
							링크(URL)’를 통해서만 가능합니다. 100명의 사전 동의를 받은 청원은 관리자의 검토를 거쳐 청원게시판에
							공개됩니다. 단, 국민청원 요건에 맞지 않는 청원은 100명의 동의를 받더라도 게시판에 공개되지 않거나 관리자에 의해
							일부 내용이 '숨김' 처리될 수 있습니다.</li>
						<li>‘사전동의 링크(URL)’를 잊으셨거나 등록한 청원 동의 수가 궁금하시다면 청와대 홈페이지 > 국민청원
							> 내 청원 보기를 통해 확인하실 수 있습니다.</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- footerParts 시작 -->
	<%@ include file="templateFiles/footerParts.jsp"%>
	<!-- footerParts 끝 -->
	<!-- Java Script
    ================================================== -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
</body>