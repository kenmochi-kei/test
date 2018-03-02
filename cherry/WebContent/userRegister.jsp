<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/reset.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/onai_style.css">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mt_style.css">
<script type="text/javascript" src="script.js"></script>

<title>ユーザー情報入力画面</title>

</head>
<body>

	<!-- ヘッダー -->

	<jsp:include page="include_header.jsp" />

	<!-- メイン -->

	<div id="main">
		<br> <br>
		<div class="title">アカウント新規登録</div>
		<br>
		<div class="register_box">
			<div class="member">
				<div class="error" align="center">
					<s:iterator value="errorMessageList">
						<s:div>
							<s:property />
						</s:div>
					</s:iterator>
				</div>
				<br>
				<div class="member_form">

					<s:form action="CheckUserInfoAction" theme="simple"
						id="userRegister">

						<span class="member_form_title">姓</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:textfield type="text" name="familyName" value="%{familyName}" />
						</div>

						<br>
						<span class="member_form_title">名</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:textfield type="text" name="firstName" value="%{firstName}" />
							<br>
						</div>

						<br>
						<span class="member_form_title">姓ふりがな</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:textfield type="text" name="familyNameKana"
								value="%{familyNameKana}" />
							<br>
						</div>

						<br>
						<span class="member_form_title">名ふりがな</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:textfield type="text" name="firstNameKana"
								value="%{firstNameKana}" />
							<br>
						</div>

						<br>
						<span class="member_form_title">cherryID</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:textfield type="text" name="userId" value="%{userId}"
								placeholder="半角英数字" />
							<br>
						</div>

						<br>
						<span class="member_form_title">パスワード</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:password name="password" value="%{password}"
								placeholder="半角英数字" />
							<br>
						</div>

						<br>
						<span class="member_form_title">性別</span>
						<span class="hissu">必須</span>
						<div class="member_form_radio">
							<s:radio name="sex" list="#{'0': '男性　　', '1': '女性'}" value="0" />
							<br>
						</div>

						<br>
						<span class="member_form_title">メールアドレス</span>
						<span class="hissu">必須</span>
						<div class="member_form_text">
							<s:textfield type="text" name="email" value="%{email}" />
							<br>
						</div>

						<br>
						<span class="member_form_title">利用規約及び個人情報保護方針</span>
						<span class="hissu">必須</span>
						<br>
						<div class="kozin"
							style="width: 433px; height: 64px; overflow: auto; margin-top: 8px;">
							<p>─　利用規約　──────────────────────</p>
							<p>楽しんでお買い物してください！</p>
							<p>─　個人情報保護方針　──────────────────</p>
							<p>cherryは個人情報を絶対に守ります！</p>
							<p>cherryは個人情報を絶対に守ります！</p>
							<p>cherryは個人情報を絶対に守ります！</p>
							<p>cherryは個人情報を絶対に守ります！</p>
							<p>cherryは個人情報を絶対に守ります！</p>
							<p>cherryは個人情報を絶対に守ります！</p>
							<p>cherryは個人情報を絶対に守ります！</p>
						</div>
						<br>
						<s:checkbox name="kozin" value="true" />
							上記の利用規約及び個人情報保護方針に同意する
							<br>
						<br>


						<br>
						<br>
						<div class="member_btn">
							<button type="submit" class="">登 録 情 報 を 確 認</button>
						</div>
						<br>
					</s:form>
				</div>
			</div>
		</div>
	</div>

	<!-- フッター -->

	<jsp:include page="include_footer.jsp" />
</body>
</html>