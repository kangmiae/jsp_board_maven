<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>JSP BOARD - 로그인</title>
</head>
<body>

<script>
  let LoginFrom_submitDone = false;

  function LoginForm_submit(form) {
    if (LoginFrom_submitDone) {
      alert('처리중 입니다.');
      return;
    }
    //문자 공백제거
    form.loginId.value = form.loginId.value.trim();
    if (form.loginId.value.length == 0) {
      alert('로그인 아이디를 입력해주세요');
      form.loginId.focus(); //해당 필드에 포커스가 간다.
      return;
    }
    form.loginPw.value = form.loginPw.value.trim();
    if (form.loginPw.value.length == 0) {
      alert('로그인 비밀번호를 입력해주세요');
      form.loginPw.focus(); //해당 필드에 포커스가 간다.
      return;
    }

    form.submit();
    LoginFrom_submitDone = true;
  }
</script>

  <%--  테이블 이용하기 --%>
  <h1>로그인 ver 5.0</h1>

<%--  reeturn false는 아무것도 하지 말라는것이다.--%>
  <h1>로그인</h1>

  <form action="doLogin" method="POST" onsubmit="LoginForm_submit(this); return false;">
    <div>
      로그인 아이디 : <input autocomplete="off" type="text" name="loginId" placeholder="로그인 아이디를 입력해주세요.">
    </div>
    <div>
      로그인 비밀번호 : <input autocomplete="off" type="password" name="loginPw" placeholder="로그인 비밀번호를 입력해주세요.">
    </div>
<%--      <input type="button" value="작성">--%>
      <button type="submit">로그인</button>
      <button type="button">
        <a href="/home/main">취소</a>
      </button>
    </div>
  </form>

</body>
</html>
