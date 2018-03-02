<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String id = (String)session.getAttribute("userId");
%>


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>パスワード設定完了</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sato_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
</head>

<body class="home">

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />


<!-- メインコンテンツ -->
<div class="completetitle">
	<h1>パスワード変更</h1>
</div>

<div class=completemain>
	<s:form action="GoLoginAction">

			<div class="complete">
			<h1>パスワードを変更しました!</h1>
			</div>

<!-- ログインしていなければログイン画面へ -->
	<% if( id == null){ %>

		<div class="loginlink">
			<h2>ログインしてください</h2>
			<button>ログインへ</button>
		</div>

		<% }else{ %>

		<div class="toplink">
			<button formaction="TopAction">TOPページへ</button>
		</div>

	<% } %>


	</s:form>
</div>

	<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>