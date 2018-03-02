<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<!-- フォントの読み込み -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300'
	rel='stylesheet' type='text/css'>

<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Cancel completion</title>
<style type="text/css">
button.button4 {
	margin-top: 20px;
	margin-right: 10px;
	margin-left: 10px;
	border: 1px;
	border-color: white;
	/* 文字サイズを1.4emに指定 */
	font-size: 1.4em;
	/* 縦方向に10px、
    * 横方向に30pxの余白を指定 */
	padding: 10px 30px;
	/* 背景色を濃い青色に指定 */
	background-color: rgb(106, 12, 59);
	/* 文字色を白色に指定 */
	color: #fff;
	/* ボーダーをなくす */
	border-style: none;
}

button.button4:hover {
	/* 背景色を明るい青色に指定 */
	background-color: rgb(150, 17, 84);
	/* 文字色を白色に指定 */
	color: #fff;
}

</style>

<!--外部cssファイルの読み込み  -->
<link href="css/design.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>Cancel complete</h1>
	<hr class="head" color="#000000">
	<div class="contents">

		<p>予約をキャンセル致しました。</p>

		<div style="display: inline-flex">
			<s:form action="ReturnTopAction">

				<button class="button4">ReturnTop</button>
			</s:form>
			<s:form action="LogOutAction">

				<button class="button4">LogOut</button>
			</s:form>
			<s:form action="GoToMyPageAction">

				<button class="button4">Mypage</button>
			</s:form>
		</div>

	</div>
	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>