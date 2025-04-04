<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="f" method="post" action="./loginok.do">
	<aside class="login_pg">	
		<p>이메일로 시작하기</p>
		<div><input type="text" placeholder="이메일 주소" name="memail"></div>
		<div><input type="password" placeholder="비밀번호" name="mpass"></div>
		<div><input type="button" value="로그인" onclick="logincheck()"></div>
		<div><input type="button" value="카카오로그인" class="kakao_btn"></div>
		<div>
			<span><a href="/realty/join/member_join.do">회원가입</a></span>
			<span><a href="/realty/search/email_search.do">이메일 찾기</a></span>
			<span><a href="/realty/search/passwd_search.do">비밀번호 찾기</a></span>
		</div>
	</aside>
</form>