<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
  <section>
    <div class="recommend">
      <p>추천분양정보<br><em>실시간 추천 분양정보를 한곳에!</em></p>
      <div class="md_estates">
        <ul>
	  	<cr:forEach var="data2" items="${data2}">
	  	<a href="${data2.mimg_addr }">
          <li>
            <div><img src="./md_room/${data2.mimg }"></div>
            <span>${data2.mtitle }</span>
            <div>${data2.mtext }</div>
          </li>
	     </a>
	  	</cr:forEach>
        </ul>
      </div>
    </div>
  </section>