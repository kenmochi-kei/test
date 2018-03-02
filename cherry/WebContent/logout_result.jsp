<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cherry</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sato_style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />

<!-- メインコンテンツ -->

<div class="completetitle">
<h1>ログアウト</h1>
</div>

<div class="completemain">
	<s:form action="TopAction">

			<div class="completelogout">
			<h1>ログアウトしました</h1>
			</div>

			<div class="toplink">
			<button type="submit">
			<span>TOPページへ</span>
			</button>
			</div>

	</s:form>
</div>

<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>