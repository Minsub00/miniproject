<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
	<div class="weekdays">
		<p>
			금주분양 매물정보<br>
			<em>이번주 신규 매물정보!</em>
		</p>
		<cr:forEach var="data" items="${data}">
		<div class="week_estates">
			<ul>
				<li>
				<a href="/realty/week_tails/week_tails.do?index=${data.bunyang_index}">
				<span>${data.bunyang_status }</span>
					<div>${data.bunyang_title }</div>
					<aside>${data.bunyang_addr}</aside> <span>${data.bunyang_part} | ${data.bunyang_info}</span> 
					<label>${data.bunyang_date} | ${data.bunyang_in}</label>
					<div>
						<img src="./room/${data.bunyang_img}">
					</div>
				</a>
				</li>
			</ul>
		</div>
		
		</cr:forEach>
	</div>
</section>