<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="a"></div>

<style>
  .a {
      width: 100px; height: 100px;
      background-color: red;
  }
</style>

<h1>5단</h1>

<div>5 * 1 = 5</div>
<div>5 * 2 = 10</div>
<div>5 * 3 = 15</div>

<%
//  int dan = 5;
//  int limit = 9;
int dan = Integer.parseInt(request.getParameter("dan"));
int limit = Integer.parseInt(request.getParameter("limit"));
%>

<h1><%=dan%>단</h1>
<% for(int i = 1; i <= limit; i++ ) { %>
  <div><%=dan%> * <%=i%> = <%=dan * i%></div>
<% } %>
