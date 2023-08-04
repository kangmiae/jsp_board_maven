package com.sbs.exam.jsp.board.servlet;

import com.sbs.exam.jsp.board.Rq;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usr/member/login")

public class UsrMemberLoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rq rq = new Rq(req,resp);

// 이렇게 해도 되고
    rq.jsp("/usr/member/login");
/* 이렇게 해도 되고
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/usr/article/write.jsp");
    requestDispatcher.forward(req,resp);
*/
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
