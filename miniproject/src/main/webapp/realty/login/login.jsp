<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="../css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="../css/login.css?v=3">
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
	<%@ include file="../common/top.jsp"%>
<main>
<%@ include file="./login_view.jsp" %>
</main>

<!-- 카피라이터 -->
 <footer>
	<%@ include file="../common/copyright.jsp"%>
 </footer>
</body>
<script src="../js/login.js"></script>
</html>