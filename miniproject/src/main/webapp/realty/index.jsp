<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>온라인 부동산 중개</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=5">
</head>
<body>
	<!-- top 시작 -->
	<%@ include file="./common/top.jsp" %>
	<!-- top 끝 -->
	<main>
		<!-- banner 시작 -->
		<%@ include file="./banner.jsp" %>
		<!-- banner 끝 -->
		
		<!-- quickmenu 시작 -->
		<%@ include file="./quickmenu.jsp" %>
		<!-- quickmenu 끝 -->
		
		<!--금주 분양 매물 정보 시작-->
		<%@ include file="./weekinfo.jsp" %>
		<!--금주 분양 매물 정보 끝-->
		
		<!--추천 분양 정보-->
		<%@ include file="./mdchoice.jsp" %>
		<!--추천 분양 정보 끝-->
	</main>
	<!-- 카피라이터 -->
	<footer>
		<%@ include file="./common/copyright.jsp" %>
	</footer>
</body>
</html>