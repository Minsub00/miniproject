<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String memail = (String) session.getAttribute("memail");
String mname = (String) session.getAttribute("mname");
String mphone = (String) session.getAttribute("mphone");
%>
<header>
	<div class="top_banner"></div>
</header>
<nav>
	<div class="menus">
		<ul class="menus_ul">
			<li onclick="location.href='/realty/index.do';"><img
				src="/realty/logo/e_click_logo.png"></li>
			<li>일반매물</li>
			<li onclick="location.href='/realty/md_board/md_board.do';">추천매물</li>
			<li>중계의뢰</li>
			<li onclick="location.href='/realty/counsel/counsel.do';">상담신청</li>
			<li>업체의뢰</li>
			<li>의뢰현황</li>
			<li class="logins" onmouseleave="myinfo_menu(2)">
	        	<span title="회원정보" onclick="myinfo_menu(1)">
	        	<img src="/realty/ico/login.svg">
	        	<ul class="login_info" id="login_info" style="display: none;">
	            	<cr:if test="${mname == null && memail == null}">
            			<li><a href="/realty/login/login.do">로그인 / 회원가입</a></li>
            		</cr:if>
            		<cr:if test="${mname != null && memail != null}">
	            	<li>${mname }님 <a href="/realty/logout">[로그아웃]</a></li>
	            	</cr:if>
	        	</ul>
	        	</span>
	        <span title="모델 하우스 사전예약 리스트" onclick="reserve_page()"><img src="/realty/ico/reserve_list.svg"></span>
	      	</li>

		</ul>
	</div>
</nav>
<script>
	//해당 함수는 모델 하우스 사전 방문예약 확인 리스트 페이지로 이동 되도록 합니다.
	function reserve_page() {
		location.href="/realty/reservation/reservation_list.do";
	}
	function myinfo_menu(part) {
		var log_menu = document.getElementById("login_info");
		if (part == 1) {
			if (log_menu.style.display == "none") {
				log_menu.style.display = "block";
			} else {
				log_menu.style.display = "none";
			}
		} else {
			log_menu.style.display = "none";
		}
	}
</script>