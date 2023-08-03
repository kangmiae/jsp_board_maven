<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ page import="com.sbs.exam.jsp.board.Rq"%>--%>

<%--꼭 해워야 한다. DB에서 검색한 데이터 받아오려면--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%
  List<Map<String,Object>> articleRows = (List<Map<String,Object>>) request.getAttribute("articleRows");
%>

<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>JSP BOARD - 리스트</title>
</head>
<body>

  <h1>게시물 리스트 ver 1.0</h1>
  <ul>
    <li>
      <%= articleRows.get(0).get("id") %>번
      <%= articleRows.get(0).get("regDate") %>
      <%= articleRows.get(0).get("updateDate") %>
      <%= articleRows.get(0).get("title") %>
      <%= articleRows.get(0).get("content") %>
  </li>
  </ul>

  <h1>게시물 리스트 ver 2.0</h1>
  <ul>
    <% for (int i = 0; i < 3; i++) { %>
      <li>
        <%= articleRows.get(i).get("id") %>번
        <%= articleRows.get(i).get("regDate") %>
        <%= articleRows.get(i).get("updateDate") %>
        <%= articleRows.get(i).get("title") %>
        <%= articleRows.get(i).get("content") %>
      </li>
    <% } %>
  </ul>

  <h1>게시물 리스트 ver 3.0</h1>
  <ul>
    <% for (int i = 0; i < 3; i++) {
      Map<String, Object> articleRow = articleRows.get(i);
    %>
    <li>
      <%= articleRow.get("id") %>번
      <%= articleRow.get("regDate") %>
      <%= articleRow.get("updateDate") %>
      <%= articleRow.get("title") %>
      <%= articleRow.get("content") %>
    </li>
    <% } %>
  </ul>

  <h1>게시물 리스트 ver 4.0</h1>
  <ul>
    <% for (int i = 0; i < articleRows.size(); i++) {
      Map<String, Object> articleRow = articleRows.get(i);
    %>
    <li>
      <%= articleRow.get("id") %>번
      <%= articleRow.get("regDate") %>
      <%= articleRow.get("updateDate") %>
      <%= articleRow.get("title") %>
      <%= articleRow.get("content") %>
    </li>
    <% } %>
  </ul>

<%--  제일 사용하기 편함 --%>
  <h1>게시물 리스트 ver 5.0</h1>
  <ul>
    <% for (Map<String, Object> articleRow : articleRows) {
    %>
    <li>
      <%= articleRow.get("id") %>번
      <%= articleRow.get("regDate") %>
      <%= articleRow.get("updateDate") %>
      <%= articleRow.get("title") %>
      <%= articleRow.get("content") %>
    </li>
    <% } %>
  </ul>

  <%--  테이블 이용하기 --%>
  <h1>게시물 리스트 ver 5.0</h1>
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
      <% for (Map<String, Object> articleRow : articleRows) {
      %>
      <tr>
        <td>
          <a href="detail?id=<%= (int)articleRow.get("id") %>">
            <%= articleRow.get("id") %>
          </a>
        </td>
        <td><%= articleRow.get("regDate") %></td>
        <td><%= articleRow.get("updateDate") %></td>
        <td><%= articleRow.get("title") %></td>
        <td><%= articleRow.get("content") %></td>
      <% } %>
      </tr>
    </tbody>
  </table>

</body>
</html>
