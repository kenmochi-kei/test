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
<script type="text/javascript">
	history.forward();
</script>

<title>登録内容確認画面</title>

</head>
<body>

	<!-- ヘッダー -->

	<jsp:include page="include_header.jsp" />

	<!-- メイン -->

	<div id="main">
		<br>
		<br>
		<div class="title">登録情報確認</div>
		<br>
		<div class="register_box">
			<div class="member">
				<div class="touroku" align="center">以下の内容で登録します</div>
				<br>
				<div class="member_form">
					<s:form action="RegisterUserInfoAction" theme="simple">
						<div class="member-form-title">

							<br>名前　　　　　　:　
							<s:property value="familyName" />
							<s:hidden name="familyName" value="%{familyName}" />
							<s:property value="firstName" />
							<s:hidden name="firstName" value="%{firstName}" />

							<br>
							<br>
							<br>ふりがな　　　　:　
							<s:property value="familyNameKana" />
							<s:hidden name="familyNameKana" value="%{familyNameKana}" />
							<s:property value="firstNameKana" />
							<s:hidden name="firstNameKana" value="%{firstNameKana}" />

							<br>
							<br>
							<br>cherryID　　　　:　
							<s:property value="userId" />
							<s:hidden name="userId" value="%{userId}" />

							<br>
							<br>
							<br> パスワード　　　:　
							<s:property value="password" />
							<s:hidden name="password" value="%{password}" />

							<br>
							<br>
							<br> 性別　　　　　　:　
							<s:if test="sex==0">
								男性
							</s:if>
							<s:else>
								女性
							</s:else>
							<s:hidden name="sex" value="%{sex}" />

							<br>
							<br>
							<br> メールアドレス　:　
							<s:property value="email" />
							<s:hidden name="email" value="%{email}" />

							<br>
							<br>
							<br>
							<p>貴方はCherryの利用規約及び個人情報保護方針に同意しました</p>
							<br>

							<div class="member_btn">
								<button type="submit" class="">登 録 情 報 を 確 定</button>
							</div>
							<br>
							<br>

							<div class="modoru" style="padding-left: 23px;">
								<a href="/cherry/userRegister.jsp">戻 る</a>
							</div>
						</div>
					</s:form>
				</div>
			</div>
		</div>
	</div>

	<!-- フッター -->

	<jsp:include page="include_footer.jsp" />
</body>
</html>