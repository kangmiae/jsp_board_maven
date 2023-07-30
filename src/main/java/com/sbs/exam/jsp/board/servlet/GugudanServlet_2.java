package com.sbs.exam.jsp.board.servlet;

import com.sbs.exam.jsp.board.Rq;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gugudan2")

public class GugudanServlet_2 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rq rq = new Rq(req, resp);

    int dan = rq.getIntParam("dan", 9);
    int limit = rq.getIntParam("limit", 9);

    req.setAttribute("dan",dan);
    req.setAttribute("limit",limit);

    //request에 정보를 담는다.
    //gugudan_2에게 데이터 넘기면서 나머지 작업을 토스
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/gugudan_2.jsp");
    requestDispatcher.forward(req,resp);
  }
}
