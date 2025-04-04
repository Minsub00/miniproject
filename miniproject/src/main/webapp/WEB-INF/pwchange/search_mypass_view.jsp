<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<script>${msg}</script>
<form id="f" method="post" action="./passwd_changeok.do">
<section class="sub">
<div>
<ul>
<li>회원가입 정보에 따른 패스워드 변경</li>
</ul>
</div>
<div class="text1 repass">
<div><input type="password" placeholder="최소 10 ~ 16자 (영문,숫자,특수 문자 조합)로 입력해주세요." class="passin" autocomplete="none" id="pass1" name="mpass"></div>
<div><input type="password" placeholder="동일한 비밀번호를 입력하세요" class="passin" autocomplete="none" id="pass2"></div>
</div>
<div><input type="button" value="비밀번호 변경" class="search_submit" onclick="pwdchange()"></div>
</section>
</form>