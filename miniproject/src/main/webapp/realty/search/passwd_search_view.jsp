<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="f" method="post" action="./passwd_searchok.do">
<section class="sub">
<div>
<ul>
<li><a href="./email_search.do">이메일 찾기</a></li>
<li>비밀번호 찾기</li>
</ul>
</div>
<div class="text1">
<div><input type="text" placeholder="가입하신 이메일을 입력하세요" name="memail"></div>
<div><input type="text" placeholder="휴대폰 번호는 - 빼고 숫자만 입력하세요" maxlength=11 name="mphone" id="numberInput"></div>
</div>
<div><input type="button" value="비밀번호 찾기" onclick="passwd_search()"></div>
</section>
</form>