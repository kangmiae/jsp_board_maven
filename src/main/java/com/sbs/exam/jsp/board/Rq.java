package com.sbs.exam.jsp.board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {

  private final HttpServletRequest req;
  private final HttpServletResponse resp;

  public Rq(HttpServletRequest req, HttpServletResponse resp) {
    this.req = req;
    this.resp = resp;
//    try {
//      req.setCharacterEncoding("UTF-8"); //들어오는 데이터를 UTF-8로 해석하겠다.
//    } catch (UnsupportedEncodingException e) {
//      throw new RuntimeException();
//    }
//    resp.setCharacterEncoding("UTF-8"); //완성되는 HTML의 인코딩을 UTF-8로 하겠다.
//    resp.setContentType("text/html; charset UTF-8"); //브라우저에게 우리가 만든 결과물이 UTF-8이라는 걸 알리는 의미
  }

  public int getIntParam(String paramName, int defaultValue) {
    String value = req.getParameter(paramName);

    if (value == null) {
      return defaultValue;
    }

    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public void appendBody(String str) {
    try {
      resp.getWriter().append(str);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String getParam(String paramName, String defaultValue) {
    String value = req.getParameter(paramName);

    if (value == null) {
      return defaultValue;
    }

    return value;

  }

  public void jsp(String jspPath) {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher(jspPath+".jsp");
    try {
      requestDispatcher.forward(req, resp);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw  new RuntimeException(e);
    }
//이렇게 try catch해도 됨
/*    try {
      requestDispatcher.forward(req, resp);
    } catch (ServletException | IOException e) {
      throw new RuntimeException(e);
    }
*/
  }
}