<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ page import="com.sbs.exam.jsp.board.Rq"%>--%>

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

</body>
</html>
