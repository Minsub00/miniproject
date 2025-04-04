<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천분양 정보 게시판</title>
<link rel="stylesheet" type="text/css" href="../css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="../css/md_board.css?v=5">
<style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}

</style>
</head>
<body>
<%@ include file="../common/top.jsp" %>
<main>
<%@ include file="./board_section.jsp" %>
</main>

<!-- 카피라이터 -->
 <footer>
	<%@ include file="../common/copyright.jsp" %>
 </footer>
</body>
<script  src="../js/md_board.js?v=3"></script>
</html>