<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="sub">
        <p>추천분양 정보 게시판</p>
        <div class="boards">이번주 신규 매물정보를 한눈에 확인하실 수 있습니다.</div>
        <div class="info_board">
        <cr:forEach var="data" items="${result}">
          <ul>
            <li>제&nbsp;&nbsp;&nbsp;목</li>
            <li>${data.btitle }</li>
            <li>글쓴이</li>
            <li>${data.bwriter}</li>
            <li>등록일</li>
            <li>${data.bdate}</li>
            <li>조회수</li>
            <li>${data.bview}</li>
            <li class="litext">내&nbsp;&nbsp;&nbsp;용</li>
            <li class="litext">
                <div class="textarea">
                    ${data.btext}
                </div>
            </li>
          </ul>
         </cr:forEach>
        </div>
        <div class="board_btn">
            <input type="button" value="목&nbsp;&nbsp;&nbsp;록" class="btns" onclick="location.href='./md_board.do'">
        </div>
    </section>