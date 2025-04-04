<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="weektails">
		<p>분양정보</p>
		<cr:forEach var="tail" items="${tails}">
		<div id="weektails">
			<p>${tail.bunyang_title}</p>
            <ul>
                <li>종류</li>
                <li>${tail.bunyang_part} | ${tail.bunyang_info} </li>
                <li>주소</li>
				<li>${tail.bunyang_addr}</li>
                <li>규모</li>
				<li>총 ${tail.bunyang_households}세대 | 총 ${tail.bunyang_bulidings}개동</li>
                <li>시기</li>
				<li>${tail.bunyang_date} | ${tail.bunyang_in}</li>
                <li>난방구조</li>
				<li>${tail.bunyang_str}</li>
                <li>건설사</li>
				<li>${tail.bunyang_company}</li>
                <li>사진정보</li>
				<li><img src="../room/room1.jpg"></li>
            </ul>
		</div>
		<cr:if test="${empty check }">
        <div><button class="btn_css" onclick="location.href='../reservation/reservation.do?title=${tail.bunyang_title}';">방문예약</button></div>
        </cr:if>
        <cr:if test="${not empty check}">
        <div><button class="btn_close" onclick="location.href='/realty/reservation/reservation_check.do?title=${tail.bunyang_title}';">방문예약완료</button></div>
        </cr:if>
		</cr:forEach>
	</div>