<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/onai_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/kudo_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">

<title>購入情報確認画面</title>
</head>
<body>

<!-- ここからヘッダー -->
	<jsp:include page="include_header.jsp" />
<!-- ヘッダーここまで -->


<!-- ここからメイン -->
<br><br>
<h2 class="title">宛先情報確認</h2>
<br><br>
<s:form action="DestinationRegisterCompleteAction" >
					<div class="touroku" align="center">以下の内容で登録します</div>
					<br>
					<div class="member_form">
						<div class="member-form-title">
							<br>名前　　　　　　:
							<s:property value="familyName" />
							<s:hidden name="familyName" value="%{familyName}" />
							<s:property value="firstName" />
							<s:hidden name="firstName" value="%{firstName}" />
							<br><br><br>ふりがな　　　　:
							<s:property value="familyNameKana" />
							<s:hidden name="familyNameKana" value="%{familyNameKana}" />
							<s:property value="firstNameKana" />
							<s:hidden name="firstNameKana" value="%{firstNameKana}" />
							<br><br><br>メールアドレス　:
							<s:property value="email" />
							<s:hidden name="email" value="%{email}" />
							<br><br><br>電話番号　　　　:
							<s:property value="telNumber" />
							<s:hidden name="telNumber" value="%{telNumber}" />
							<br><br><br>住所　　　　　　:
							<s:property value="userAddress" />
							<s:hidden name="userAddress" value="%{userAddress}" />
							<br><br><br><br>
							<div class="member_btn">
								<button type="submit" class="">登 録 情 報 を 確 定</button>
							</div>
						</div>
						<br><br>
						<div class="modoru" style="padding-left: 23px;"><a href="/cherry/destinationRegister.jsp">戻 る</a></div>
					</div>

					</s:form>
<!-- メインここまで -->

<!-- フッター -->
	<span><jsp:include page="include_footer.jsp" /></span>
<!-- フッターここまで -->

</body>
</html>