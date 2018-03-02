<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/onai_style.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mt_style.css">

<title>新規登録完了画面</title>
</head>
<body>

	<!-- ヘッダー -->

	<jsp:include page="include_header.jsp" />

	<!-- メイン -->

	<div id="main" align="center">
		<br>
		<br>
		<br>
		<br>
		<div class="heart">&#9829;</div>
		<br>
		<p>Cherryアカウントの新規登録が完了しました</p>
		<br>
		<br>
		<br>
		<br>
		<div class="nomember_btn">
			<a href='<s:url action="GoHomeAction"/>'>H O M E</a> <br>
			<br> <a href='<s:url action="GoCartAction"/>'>C A R T</a>
		</div>

	</div>
	<br>
	<br>

	<!-- フッター -->

	<jsp:include page="include_footer.jsp" />

</body>
</html>