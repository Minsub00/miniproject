<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<section class="sub">
	<p>추천분양 정보 게시판</p>
	<div class="boards">이번주 신규 매물정보를 한눈에 확인하실 수 있습니다.</div>
	<div class="info_board">
		<ul>
			<li>NO</li>
			<li>제목</li>
			<li>글쓴이</li>
			<li>조회수</li>
			<li>등록일</li>
		</ul>
		<cr:set var="ino" value="${total-userpage}" />
		<cr:if test="${empty all}">
			<ul style="display: none;">
				<li class="nodata">등록된 게시물이 없습니다.</li>
			</ul>
		</cr:if>
		<cr:if test="${not empty all}">
			<cr:forEach var="post" items="${all}" varStatus="idx">
				<ul class="data_view" onclick="location.href='./md_board_view.do?title=${post.btitle}&index=${post.bidx }'">
					<li>${ino - idx.index}</li>
					<li style="text-align: left;">${post.btitle}</li>
					<li>${post.bwriter}</li>
					<li>${post.bview}</li>
					<li>${fn:substring(post.bdate, 0, 10)}</li>
				</ul>
			</cr:forEach>
		</cr:if>
	</div>
	<div class="info_pageing">
		<ol>
			<cr:set var="pageidx"
				value="${total / 10 + (1-((total/10) % 1)) %1 }" />
			<cr:forEach var="no" begin="1" end="${pageidx}" step="1">
				<li onclick="page('${no}', '${search}')">${no}</li> 
			</cr:forEach>
		</ol>
	</div>
	<form id="f" method="get" action="./md_board.do">
		<div class="info_search">
			<input type="text" class="search_text" placeholder="검색어를 입력하세요" name="search">
			<input type="button" value="검색" class="search_btn" onclick="board_search()">
		</div>
	</form>
</section>