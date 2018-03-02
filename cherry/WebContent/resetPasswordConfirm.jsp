<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>パスワード確認</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sato_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>

<body class="home">

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />


<!-- メインコンテンツ -->
<div class="outbox">
	<div class="main">
	  <div class="sectionHeader">
			<h1>確認画面</h1>
	  </div>
	  <br>
		<div class="contBody">
			<h3>登録する内容は以下でよろしいですか。</h3>

				<s:form action="ResetPasswordCompleteAction">
				<table>
					<tr id="box">
						<th>
							<label>cherryID</label>
						</th>
						<td>
							<s:property value="session.newUserId" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<th>
							<label>パスワード</label>
						</th>
						<td>
							<s:property value="s" escape="false" />
						</td>
					</tr>
				</table>
					<div class="btnn">
						<button type="submit">
							<span>送信<i class="fa fa-upload" aria-hidden="true"></i></span>
						</button>
					</div>
				</s:form>

		</div>
	</div>
</div>
<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>