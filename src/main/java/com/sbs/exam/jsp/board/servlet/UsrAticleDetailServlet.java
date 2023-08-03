package com.sbs.exam.jsp.board.servlet;

import com.sbs.exam.jsp.board.Rq;
import com.sbs.exam.jsp.board.mysqlutil.MysqlUtil;
import com.sbs.exam.jsp.board.mysqlutil.SecSql;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/usr/article/detail")

public class UsrAticleDetailServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rq rq = new Rq(req,resp);
    resp.setContentType("text/html; charset=utf-8");

    //DB연결을 위해 반드시 있어야 한다.
    MysqlUtil.setDBInfo("localhost","root","password","jspboard_db");
    MysqlUtil.setDevMode(true);

    int id = rq.getIntParam("id", 0);

    if(id == 0) {
      rq.appendbody("<script>alert('번호를 입력해 주세요.'); history.back(); </script>");
      return;
    }

    SecSql sql = new SecSql();
    sql.append("SELECT *");
    sql.append("FROM article");
    sql.append("WHERE id = ?", id);

//  검색데이터가 여러줄이면  Rows를 아니면 Row를 사용한다.
    Map<String, Object> articleRow = MysqlUtil.selectRow(sql);

    req.setAttribute("articleRow",articleRow);

//    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/usr/article/detail.jsp"); //이렇게 해도 되고 아래처럼 해도 되고
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("../article/detail.jsp");
    requestDispatcher.forward(req,resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
