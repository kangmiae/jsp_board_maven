package com.sbs.exam.jsp.board.servlet;

import com.sbs.exam.jsp.board.Rq;
import com.sbs.exam.jsp.board.mysqlutil.MysqlUtil;
import com.sbs.exam.jsp.board.mysqlutil.SecSql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/usr/member/doLogin")

public class DoMemberLoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=utf-8");

    //DB연결을 위해 반드시 있어야 한다.
    MysqlUtil.setDBInfo("localhost","root","password","jspboard_db");
    MysqlUtil.setDevMode(true);

    Rq rq = new Rq(req,resp);

    String loginId = rq.getParam("loginId","");
    String loginPw = rq.getParam("loginPw","");

// 로그인시 필요정보 가지고 오기
    SecSql sql = new SecSql();
    sql.append("SELECT id, loginId, loginPw, nm");
    sql.append("FROM member_t");
    sql.append("WHERE loginId = ?", loginId);

//  검색데이터가 여러줄이면  Rows를 아니면 Row를 사용한다.
    Map<String, Object> memberRow = MysqlUtil.selectRow(sql);

    if (memberRow.isEmpty()) {
      rq.appendBody("<script>alert('존재하지 않는 아이디입니다.'); history.back(); </script>");
      return;
    }

    if (((String) memberRow.get("loginPw")).equals(loginPw) == false) {
      rq.appendBody("<script>alert('로그인 비번이 틀렸습니다.'); history.back(); </script>");
      return;
    }

// servlet 내장객체...로그인을 하면 로그인 정보가 session에  남아 있게 된다.
    HttpSession session = req.getSession();
    session.setAttribute("loginedMemberId", memberRow.get("loginId"));
    session.setAttribute("loginedMemberNm", memberRow.get("nm"));

    rq.appendBody("<script>alert('로그인 되었습니다.'); location.replace('/home/main'); </script>");

    MysqlUtil.closeConnection();

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
