package com.sbs.exam.jsp.board.servlet;

import com.sbs.exam.jsp.board.Rq;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usr/article/write")

public class UsrArticleWriteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rq rq = new Rq(req,resp);

// 이렇게 해도 되고
    rq.jsp("/usr/article/write");
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
