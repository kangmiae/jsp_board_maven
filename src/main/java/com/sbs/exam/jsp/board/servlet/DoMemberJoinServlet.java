package com.sbs.exam.jsp.board.servlet;

import com.sbs.exam.jsp.board.Rq;
import com.sbs.exam.jsp.board.mysqlutil.MysqlUtil;
import com.sbs.exam.jsp.board.mysqlutil.SecSql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usr/member/doJoin")

public class DoMemberJoinServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=utf-8");

    //DB연결을 위해 반드시 있어야 한다.
    MysqlUtil.setDBInfo("localhost","root","password","jspboard_db");
    MysqlUtil.setDevMode(true);

    Rq rq = new Rq(req,resp);

    String loginId = rq.getParam("loginId","");
    String loginPw = rq.getParam("loginPw","");
    String name = rq.getParam("nm","");

    SecSql sql = new SecSql();
    sql.append("SELECT count(*) as cnt");
    sql.append("FROM member_t");
    sql.append("WHERE loginid = ?", loginId);

// 중복체크 이런방법도 있고
    int isCnt = MysqlUtil.selectRowIntValue(sql);
    if (isCnt != 0) {
      rq.appendBody("<script>alert('해당 아이디로 회원이 이미 존재합니다.'); history.back(); </script>");
    }

    sql = new SecSql();
    sql.append("INSERT INTO member_t");
    sql.append("SET regDate = NOW() ");
    sql.append("   ,updateDate = NOW() ");
    sql.append("   ,loginId = ?", loginId);
    sql.append("   ,loginPw = ?", loginPw);
    sql.append("   ,nm = ?", name);

//  검색데이터가 여러줄이면  Rows를 아니면 Row를 사용한다.
    int id = MysqlUtil.insert(sql);

//    rq.appendBody("<script>alert('%d번 글이 생성 되었습니다.'); location.replace('detail?id=%d'); </script>");
    rq.appendBody("<script>alert('회원이 생성 되었습니다.'); location.replace('/home/main'); </script>");

    MysqlUtil.closeConnection();

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
