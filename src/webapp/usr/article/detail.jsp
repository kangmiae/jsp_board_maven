<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ page import="com.sbs.exam.jsp.board.Rq"%>--%>

<%--꼭 해워야 한다. DB에서 검색한 데이터 받아오려면--%>
<%--<%@ page import="java.util.List" %> 필요 없음 list가 아니라서 map만 가져오면 되니까--%>
<%@ page import="java.util.Map" %>

<%
  Map<String,Object> articleRow = (Map<String,Object>) request.getAttribute("articleRow");
%>

<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>JSP BOARD - 게시물 상세보기</title>
</head>
<body>

  <%--  테이블 이용하기 --%>
  <h1>게시물 리스트 상세보기 ver 5.0</h1>
  <table border="1" style="border-collapse: collapse; text-align:center">
    <colgroup>
      <col width = "50px">
      <col width = "200px">
      <col width = "200px">
      <col width = "100px">
      <col width = "100px">
    </colgroup>
    <thead>
      <tr>
        <th>번호</th>
        <th>작성날짜</th>
        <th>수정날짜</th>
        <th>제목</th>
        <th>내용</th>
      </tr>
    </thead>
    <tbody>
<%--      <% for (Map<String, Object> articleRow : articleRows) {--%>
<%--      %>--%>
      <tr>
        <td><%= articleRow.get("id") %>번</td>
        <td><%= articleRow.get("regDate") %></td>
        <td><%= articleRow.get("updateDate") %></td>
        <td><%= articleRow.get("title") %></td>
        <td><%= articleRow.get("content") %></td>
<%--      <% } %>--%>
      </tr>
    </tbody>
  </table>

  <div>
    <a href="list">리스트로 이동</a>
  </div>


</body>
</html>
