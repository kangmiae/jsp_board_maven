package servlet;

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
    req.setCharacterEncoding("UTF-8"); //들어오는 데이터를 UTF-8로 해석하겠다.
    resp.setCharacterEncoding("UTF-8"); //완성되는 HTML의 인코딩을 UTF-8로 하겠다.
    resp.setContentType("text/html; charset UTF-8"); //브라우저에게 우리가 만든 결과물이 UTF-8이라는 걸 알리는 의미

    int dan = Integer.parseInt(req.getParameter("dan")); //화면에서 입력값 받아준다.
    int limit = Integer.parseInt(req.getParameter("limit")); //화면에서 입력값 받아준다.
    //웹브라우저에서 부르는 방법 -- http://localhost:8081/gugudan?dan=5&limit=5

    int i = 1;
    int j = 1;

    resp.getWriter().append("<h1>구구단</h1>\n");

    resp.getWriter().append("=======\n");
    for ( i = 1; i <= limit; i++) {
      resp.getWriter().append(String.format("<div>%d * %d = %d</div>\n", dan, i, dan * i));
    }
    resp.getWriter().append("=======\n");

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
