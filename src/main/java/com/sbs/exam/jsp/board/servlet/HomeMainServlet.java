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

@WebServlet("/home/main")

public class HomeMainServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rq rq = new Rq(req,resp);

    req.setAttribute("age", 54); //나이가 54인것을 req에게 알려줌, main.jsp에서 받아서 사용 할수 있다.
    req.setAttribute("isLogined", true); //현재 로그인중인지 체크 할 수 있도록 셋팅 해 줌

    //DB연결을 위해 반드시 있어야 한다.
    MysqlUtil.setDBInfo("localhost","root","password","jspboard_db");
    MysqlUtil.setDevMode(true);

    SecSql sql = new SecSql();
    sql.append("SELECT A.*");
    sql.append("FROM article AS A");
    sql.append("ORDER BY A.id DESC");

    List<Map<String, Object>> articlesRows = MysqlUtil.selectRows(sql);

    req.setAttribute("articleRows",articlesRows);

// 이렇게 해도 되고
    rq.jsp("/home/main");
/* 이렇게 해도 되고
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home/main.jsp");
    requestDispatcher.forward(req,resp);
*/

    MysqlUtil.closeConnection();

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
