<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/index.css?v=7">
<link rel="stylesheet" type="text/css" href="../css/member_join.css?v=4">
<style>
.box {
	width: 800px;
	height: 300px;
	border: 1px solid black;
	overflow: auto;
}
</style>
<title>회원 가입</title>
</head>
<body>
	<!-- top 시작 -->
	<%@ include file="../common/top.jsp"%>
	<!-- top 끝 -->

	<main>
		<%@ include file="./member_join_view.jsp"%>
	</main>

	<!-- 카피라이터 -->
	<footer>
		<%@ include file="../common/copyright.jsp"%>
	</footer>
</body>
<script src="../js/member_join.js"></script>
</html>