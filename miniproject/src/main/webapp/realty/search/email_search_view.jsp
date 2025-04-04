<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="f" method="post" action="./email_searchok.do">
<section class="sub">
<div>
<ul>
<li>이메일 찾기</li>
<li><a href="./passwd_search.do">비밀번호 찾기</a></li>
</ul>
</div>
<div class="text1">
<div><input type="text" placeholder="이름을 입력하세요" name="mname"></div>
<div><input type="text" placeholder="휴대폰 번호는 - 빼고 숫자만 입력하세요" maxlength="11" id="numberInput" name="mphone"></div>
</div>
<div><input type="button" value="이메일 찾기" onclick="email_search()"></div>
</section>
</form>