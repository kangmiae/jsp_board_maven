package com.sbs.exam.jsp.board.servlet;

import com.sbs.exam.jsp.board.mysqlutil.MysqlUtil;
import com.sbs.exam.jsp.board.mysqlutil.SecSql;

import java.util.List;
import java.util.Map;

public class DbConnTest {
  public static void main(String[] args ) {
    MysqlUtil.setDBInfo("localhost","root","password","jspboard_db");

    MysqlUtil.setDevMode(true);

    //selectRows : 검색 결과가 멀티 row일 경우
    List<Map<String,Object>> articleListMap = MysqlUtil.selectRows(new SecSql().append("SELECT * FROM article"));
    System.out.println("articleListMap : " +articleListMap);

    //selectRow : 검색 결과가 한 row일 경우
    Map<String,Object> articleMap = MysqlUtil.selectRow(new SecSql().append("SELECT * FROM article WHERE id = ?", 1));
    System.out.println("articleMap : " +articleMap);

    int id = MysqlUtil.selectRowIntValue(new SecSql().append("SELECT id FROM article WHERE id = ?", 1));
    System.out.println("articleId : " + id);

    boolean cnt = MysqlUtil.selectRowBooleanValue(new SecSql().append("SELECT count(*) FROM article WHERE id = ?", 4));
    System.out.println("cnt : " + cnt);

    String newTitle = "새제목";
    String newContent = "새내용";

    SecSql sql = new SecSql();
    sql.append("INSERT INTO article");
    sql.append("SET regDate = NOW()");
    sql.append("    ,updateDate = NOW()");
    //sql.append("    ,id = 4");
    sql.append("    ,title = ?",newTitle);
    sql.append("    ,content = ?", newContent);

    MysqlUtil.insert(sql);

    //DB연결 종료-반드시 해주어야 함
    MysqlUtil.closeConnection();

  }
}
