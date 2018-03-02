<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />

	<title>ログインエラー</title>
	<style type="text/css">
		body {
			/* 要素の外側の余白を指定 */
		   margin:0;
			/*要素の内側の余白を指定 */
		   padding:0;
			/*行の高さを指定 */
		   line-height:1.6;
			/*文字の間隔を指定 */
		   letter-spacing:1px;
			/*フォントの種類を指定*/
		   font-family:Verdana, Helvetica, sans-serif;
			/*文字の大きさ・色 */
		   font-size:12px;
		   color:#333;
			/*背景に関する属性をまとめて設定 */
		   background:#fff;
		}

		table {
			/*横位置の揃え方を設定 */
			text-align:center;
			margin:0 auto;
		}

/* ========TEMPLATE LAYOUT======== */
		#top {
			/* ボックス領域の幅を設定 */
		   width:780px;
		   margin:30px auto;
			/* 要素の周囲に枠線を設定 */
		   border:1px solid #333;
		}

		#header {
		   width: 100%;
			/*要素の高さを設定 */
		   height: 80px;
			/*背景色を設定 */
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
			/*要素の回り込み(float)を解除 */
			clear:both;
		}

		#error{
			color:red;
		}

		#text-center {
			/*要素の表示形式を設定、インラインレベルのブロックコンテナを生成 */
			display: inline-block;
			text-align: center;
		}
	</style>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>Error</p>
		</div>

		<div id="error">
			<h3>IDかパスワードが違います。</h3>
		</div>
			<!-- ログインID,PASS入力ボックス、ログインボタンを押すと"LoginAction"へ -->
			<s:form action="LoginAction">
				<tr>
					<td>
						ユーザーID(半角英数字)：
					</td>
					<td>
						<input type="text" name="loginUserId"/>
					</td>
				</tr>
				<tr>
					<td>
						パスワード(半角英数字)：
					</td>
					<td>
						<input type="password" name="loginPassword" placeholder="最低6文字必要です"/>
					</td>
				</tr>
				<s:submit value="ログイン"/>
			</s:form>

			<br><br>
			<div>
				<!-- ”こちら”を押すと"passwordSetting"へ -->
				<span>パスワードを忘れた方は<a href='<s:url action="SecretQuestionConfirmAction" />'>こちら</a>
				</span>
			</div>
			<br><br>

			<div>
				<!-- ”こちら”を押すと"UserCreateAction"へ -->
				<span>新規ユーザー登録は<a href='<s:url action="UserCreateAction" />'>こちら</a>
				</span>
			</div>
		</div>
	<div id="footer">
	</div>
</body>
</html>