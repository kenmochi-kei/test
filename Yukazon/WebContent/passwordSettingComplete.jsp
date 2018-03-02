<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
	<title>新パスワード登録完了画面</title>
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
		#box {
			border: 1px solid #000000;
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
			<p>PasswordSettingComplete</p>
		</div>
		<div>
			<h3>以下の内容で登録が完了しました。</h3>
			<table>
					<tr id="box">
						<td>
							<label>ユーザーID：</label>
						</td>
						<td>
							<s:property value="session.loginUserId" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>新パスワード：</label>
						</td>
						<td>
							<s:property value="session.loginPassword" escape="false" />
						</td>
					</tr>
			</table>
			<div>
				<h1><a href="http://localhost:8080/Yukazon/buyItem.jsp">商品ページへ</a></h1>
			</div>
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>