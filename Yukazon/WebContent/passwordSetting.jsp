<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta charset="utf-8">
<title>パスワード設定画面</title>
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
		   height: 550px;
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
	</div>
	<div id="main">
		<div id="top">
			<p>PasswoedSetting</p>
		</div>

		<div>
			<s:if test="errorMassage != ''">
				<font color="red" size="3px"><s:property value="errorMassage" escape="false" /></font>
			</s:if>
			<s:form action="PasswordSettingCompleteAction">
				<tr>
					<td>
						<label>新規パスワード(半角英数字)<font color="red">必須</font>:</label>
					</td>
					<td>
						<input type="password" name="loginPassword" placeholder="最低6文字必要です" pattern=".{6,}" title="半角英数字6文字以上でご入力ください。" required
						 value="<s:property value="session.loginUser.loginPassword"/>" />
					</td>
				</tr>
				<tr>
					<td>
						<label>確認パスワード<font color="red">必須</font>：</label>
					</td>
					<td>
						<input type="password" name="checkLoginPassword" placeholder="もう一度パスワードを入力" pattern=".{6,}" title="半角英数字6文字以上でご入力ください。" required
						value="<s:property value="session.loginUser.loginPassword"/>" />
					</td>
				</tr>

				<s:submit value="変更"/>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>