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

@WebServlet("/usr/article/list")

public class UsrArticleListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Rq rq = new Rq(req,resp);

    //DB연결을 위해 반드시 있어야 한다.
    MysqlUtil.setDBInfo("localhost","root","password","jspboard_db");
    MysqlUtil.setDevMode(true);

    int page = rq.getIntParam("page", 1);
    int itemInAPage = 20;
    int itemInAFrom = (page -1) * itemInAPage;

    SecSql sql = new SecSql();
    sql.append("SELECT COUNT(*) AS cnt FROM article");
    int totalCount = MysqlUtil.selectRowIntValue(sql); //숫자를 반환한다.
    int totalPage = (int) Math.ceil((double) totalCount / itemInAPage);

    sql = new SecSql();
    sql.append("SELECT A.*");
    sql.append("FROM article AS A");
    sql.append("ORDER BY A.id DESC");
    sql.append("LIMIT ?, ?", itemInAFrom, itemInAPage);

    List<Map<String, Object>> articlesRows = MysqlUtil.selectRows(sql);

    req.setAttribute("articleRows",articlesRows);
    req.setAttribute("page",page);
    req.setAttribute("totalPage",totalPage);

    rq.jsp("/usr/article/list");

    MysqlUtil.closeConnection();

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
