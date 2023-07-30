<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sbs.exam.jsp.board.Rq"%>

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

<%--만들어 놓은 서블릿을 이용하여 parameter값 받아오기--%>
<%
  Rq rq = new Rq(request, response);
  int start_1 = rq.getIntParam("dan",9);
  int end_1 = rq.getIntParam("limit",5);
%>
<h1><%=start_1%>단</h1>
<% for(int i = 1; i <= end_1; i++ ) { %>
<div><%=start_1%> * <%=i%> = <%=start_1 * i%></div>
<% } %>

<%--바로 parameter값 받아오기--%>
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

<%
  int a = 10;
  out.println(a); //  reponse.getWriter().append(a); 와 동일하다.
%>

<%--출력 방식 1--%>
<h2><% out.println(a);%> </h2>
<h2><% out.println("HI");%> </h2>
<h2><% out.println("<h2>정말일까?</h2>");%> </h2>
<%--출력 방식 2--%>
<h3> <%=a%> </h3>
<h3> <%="HI"%> </h3>
<h3> <%="<h2>정말일까?</h2>"%> </h3>
<%--출력방식 3--%>
<h1>정말일까?\n</h1>
<%--콘솔창에 출력이 된다.--%>
<h2><% System.out.println(a);%> </h2>
