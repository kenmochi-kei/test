<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/reset.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mt_style.css">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/ochiai_style.css">

<title>決済完了画面</title>
</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="include_header.jsp" />
	<div class="header"></div>

	<div class="main">
		<div class="message">
			<br>
			<br>
			<br>
			<div class="heart">&#9829;</div>
			<a>購入が完了いたしました</a>
			<br>
			<br>
			<br>
		</div>
		<div class="submit">


			<div class="gh">
				<div class="btnn">
					<a href='<s:url action="GoHomeAction"/>' class="button">ホーム</a>
				</div>
			</div>

			<div class="ph">
				<div class="btnn">
					<a href='<s:url action="PurchaseHistoryAction"/>' class="button">購入履歴</a>
				</div>
			</div>
		</div>
	</div>

	<!-- フッター -->
	<jsp:include page="include_footer.jsp" />
	<div class="footer"></div>


</body>
</html>