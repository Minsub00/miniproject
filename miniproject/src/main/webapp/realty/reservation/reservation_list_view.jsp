<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>${msg }</script>
<section class="sub">
        <p>모델 하우스 방문 예약 리스트</p>
        <div class="boards">모델 하우스 방문 예약한 정보를 한눈에 확인 하실 수 있습니다.</div>
        <div class="info_board">
          <ul>
            <li>NO</li>
            <li>아파트명</li>
            <li>방문일자</li>
            <li>방문시간</li>
            <li>인원수</li>
            <li>취소</li>
          </ul>
          <cr:if test="${empty result}">
          <ul style="display: block;"><li class="nodata">등록된 방문 예약이 없습니다.</li></ul>
          </cr:if>
          <cr:forEach var="data" items="${result}" varStatus="idx">
          <ul class="data_view">
            <li>${idx.index + 1}</li>
            <li style="text-align: left;">${data.rtitle}</li>
            <li>${data.rdate}</li>
            <li>${fn:substring(data.rtime,0,5)}</li>
            <li>${data.rpeople}</li>
            
            <li>
            	<form>
            		<input type="button" value="취소" class="cancel_btn" onclick="cancel(${data.ridx})">
            	</form>
            </li>
            
          </ul>
          </cr:forEach>
        </div>
    </section>