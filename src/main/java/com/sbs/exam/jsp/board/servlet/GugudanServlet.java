package com.sbs.exam.jsp.board.servlet;

import com.sbs.exam.jsp.board.Rq;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gugudan")

public class GugudanServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //Rq를 사용하지 않을때 웹브라우저에서 부르는 방법 -- http://localhost:8081/gugudan?dan=5&limit=5
    req.setCharacterEncoding("UTF-8"); //들어오는 데이터를 UTF-8로 해석하겠다.
    resp.setCharacterEncoding("UTF-8"); //완성되는 HTML의 인코딩을 UTF-8로 하겠다.
    resp.setContentType("text/html; charset UTF-8"); //브라우저에게 우리가 만든 결과물이 UTF-8이라는 걸 알리는 의미
//    int dan = Integer.parseInt(req.getParameter("dan")); //화면에서 입력값 받아준다.
//    int limit = Integer.parseInt(req.getParameter("limit")); //화면에서 입력값 받아준다.

//    웹브라우저에서 부르는 방법 -- http://localhost:8081/gugudan?dan=5&limit=5

    //Rq를 사용할때 웹브라우저에서 부르는 방법, 파라메터가 없으면 기본디폴트 9로 Rq에서 자동 셋팅
    // -- http://localhost:8081/gugudan?dan=5&limit=5
    // -- http://localhost:8081/gugudan?dan=5
    // -- http://localhost:8081/gugudan

    // Rq와 같은 servlet의 단점
    // html을 한눈에 볼수 없다는데 있다.
    // 그래서 이것을 webapp안에 jsp를 만들어 사용한다.
    Rq rq = new Rq(req, resp);
    int dan = rq.getIntParam("dan", 9);
    int limit = rq.getIntParam("limit", 9);

    int i = 1;
    int j = 1;

    resp.getWriter().append("<h1>구구단 만들기</h1>\n\n");
    rq.appendbody(String.format("<h2>%d 단</h2>\n",dan));

    //rq라는 class 만들어도 이용 한다 : 입출력을 이거 하나로 사용한다.
    resp.getWriter().append("=======\n");
    for ( i = 1; i <= limit; i++) {
      rq.appendbody(String.format("<div>%d * %d = %d</div>\n", dan, i, dan * i));
    }
    resp.getWriter().append("=======\n");

    //이건 하나의 단에 지정된 차수까지만 보이게 한다.
    resp.getWriter().append("=======\n");
    for ( i = 1; i <= limit; i++) {
      resp.getWriter().append(String.format("<div>%d * %d = %d</div>\n", dan, i, dan * i));
    }
    resp.getWriter().append("=======\n");


    //구구단 전체를 while문을 이용하여 보이게 한다.
    i = 1;
    while ( i <= 9) {
      if (i != 1) resp.getWriter().append("------------\n");
      while (j <= 9) {
        resp.getWriter().append(String.format("<div>%d * %d = %d</div>\n", i, j, i * j));
        j++;
      }
      i++;
      j = 1;
    }

    //구구단 전체를 for문을 이용하여 보이게 한다.
    resp.getWriter().append("=======\n");
    for ( i = 1; i <= 9; i++) {
      if (i != 1) resp.getWriter().append("------------\n");
      for ( j = 1; j <= 9; j++) {
        resp.getWriter().append(String.format("<div>%d * %d = %d</div>\n", i, j, i * j));
      }
      j = 1;
    }
    resp.getWriter().append("=======\n");
  }
}
