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
import java.util.Map;

@WebServlet("/usr/article/modify")

public class UsrArticleModifyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=utf-8");
    Rq rq = new Rq(req,resp);

    int id = rq.getIntParam("id",0);

    if ( id == 0 ) {
      rq.appendBody("<script>alert('번호를 입력하십시오'); history.back();</script>");
      return;
    }

    //DB연결을 위해 반드시 있어야 한다.
    MysqlUtil.setDBInfo("localhost","root","password","jspboard_db");
    MysqlUtil.setDevMode(true);

    SecSql sql = new SecSql();
    sql.append("SELECT *");
    sql.append("FROM article");
    sql.append("WHERE id =?",id);

    Map<String, Object> articlesRow = MysqlUtil.selectRow(sql);

    req.setAttribute("articleRow",articlesRow);

//  이렇게 해도 되고
    rq.jsp("/usr/article/modify");
/*  이렇게 해도 되고
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/usr/article/modify.jsp");
    requestDispatcher.forward(req,resp);
*/

    MysqlUtil.closeConnection();

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}