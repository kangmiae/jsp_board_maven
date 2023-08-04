<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>JSP BOARD - 회원가입</title>
</head>
<body>

<script>
  let JoinFrom_submitDone = false;

  function JoinForm_submit(form) {
    if (JoinFrom_submitDone) {
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
    form.loginPwConfirm.value = form.loginPwConfirm.value.trim();
    if (form.loginPwConfirm.value.length == 0) {
      alert('로그인 비밀번호 확인 입력해주세요');
      form.loginPwConfirm.focus(); //해당 필드에 포커스가 간다.
      return;
    }

    if (form.loginPw.value != form.loginPwConfirm.value) {
      alert('로그인 비밀번호가 일치하지 않습니다. 다시 입력해주세요');
      form.loginPw.focus(); //해당 필드에 포커스가 간다.
      return;
    }

    form.name.value = form.name.value.trim();
    if (form.name.value.length == 0) {
      alert('로그인 이름을 입력해주세요');
      form.name.focus(); //해당 필드에 포커스가 간다.
      return;
    }

    form.submit();
    JoinFrom_submitDone = true;
  }
</script>

  <%--  테이블 이용하기 --%>
  <h1>회원가입 ver 5.0</h1>

<%--  reeturn false는 아무것도 하지 말라는것이다.--%>
  <h1>회원가입</h1>
  <a href="https://www.naver.com" onclick="alert('hi'); return false;">네이버로 이동 1</a>
<%--  확인은 ture 취소는 false--%>
  <a href="https://www.naver.com" onclick="if(confirm('정말 이동할래?') == false) return false;">네이버로 이동 2</a>

  <form action="doJoin" method="post" onsubmit="JoinForm_submit(this); return false;">
    <div>
      로그인 아이디 : <input autocomplete="off" type="text" name="loginId" placeholder="로그인 아이디를 입력해주세요.">
    </div>
    <div>
      로그인 비밀번호 : <input autocomplete="off" type="password" name="loginPw" placeholder="로그인 비밀번호를 입력해주세요.">
    </div>
    <div>
      로그인 비밀번호 확인: <input autocomplete="off" type="password" name="loginPwConfirm" placeholder="로그인 비밀번호 확인.">
    </div>
    <div>
      로그인 비밀번호 : <input autocomplete="off" type="text" name="name" placeholder="이름을 입력해주세요.">
    </div>

    <div>
<%--      <input type="button" value="작성">--%>
      <button type="submit">회원가입</button>
      <button type="button">
        <a href="/home/main">취소</a>
      </button>
    </div>
  </form>

</body>
</html>
