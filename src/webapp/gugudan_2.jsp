<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--만들어 놓은 서블릿에서 셋팅한 parameter값 받아오기--%>
<%
  int dan = (int) request.getAttribute("dan");
  int limit = (int) request.getAttribute("limit");
%>
<h1><%=dan%>단</h1>
<% for(int i = 1; i <= limit; i++ ) { %>
<div><%=dan%> * <%=i%> = <%=dan * i%></div>
<% } %>
