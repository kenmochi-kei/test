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

	<title>秘密の質問エラー</title>
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
			<h3>IDと質問、答えが一致しません。</h3>
		</div>
			<br><br>
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
	<div id="footer">
	</div>
</body>
</html>