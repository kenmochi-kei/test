<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />

	<title>パスワードを忘れた時の質問画面</title>
	<style type="text/css">
/* ========TAG LAYOUT======== */
	body {
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
		font-family:Verdana, Helvetica, sans-serif;
		font-size:12px;
		color:#333;
		background:#fff;
	}
	table {
		text-align:center;
		margin:0 auto;
	}
/* ========ID LAYOUT======== */
	#top {
		width:780px;
		margin:30px auto;
		border:1px solid #333;
	}
	#header {
		width: 100%;
		height: 80px;
		background-color: black;
	}
	#main {
		width: 100%;
		height: 500px;
		text-align: center;
	}
	#footer {
		width: 100%;
		height: 80px;
		background-color: black;
		clear:both;
	}
	</style>
</head>


<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
		<p>SecretQuestionConfirm</p>
		</div>
		<div>
			<table>
			<!-- "パスワード再設定画面へ"ボタンを押すと"PasswordSettingAction"へ -->
			<s:form action="PasswordSettingAction">
				<tr>
					<td>
						<label>ユーザーID(半角英数字)<font color="red">必須</font>:</label>
					<br><br></td>
					<td>
						<input type="text" name="loginUserId" pattern="^[0-9A-Za-z]+$" title="半角英数字でご入力ください。" required />
					<br><br></td>
				</tr>
				<tr>
					<td>
						<label>パスワードを忘れた時の質問<font color="red">必須</font>:</label>
					</td>
					<td>
						<select name="secretQuestion">
							<option value="質問を選んでください" selected="selected">質問を選んでください</option>
							<option value="好きな食べ物は？">好きな食べ物は？</option>
							<option value="小学校の名前は？">小学校の名前は？</option>
							<option value="母親の旧姓は？">母親の旧姓は？</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<label>答え(全角ひらがな)<font color="red">必須</font>:</label>
					<br><br>
					</td>
					<td>
						<!-- 答えの入力制限:全角ひらがな2文字以上、入力必須項目 -->
						<input type="text" name="secretAnswer" placeholder="最低2文字必要です" pattern="^[ぁ-ん]+$" title="全角ひらがな2文字以上でご入力ください。" required />
					<br><br>
					</td>
				</tr>
					<s:submit value="パスワード再設定へ"/>
			</s:form>
			</table>
			<br><br>
			<div>
				<span>ログイン画面に戻る場合は</span>
				<a href="http://localhost:8080/Yukazon/home.jsp">こちら</a>
			</div>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>