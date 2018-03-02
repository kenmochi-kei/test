<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- フォントの読み込み -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300'
	rel='stylesheet' type='text/css'>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">
<title>CustomerEditComplete</title>
<link href="img/favicon.ico" rel="icon" type="img/ico" />
<style type="text/css">

/*ボタンデザインのcss*/
button.button4 {
	margin-top: 20px;
	margin-right: 10px;
	margin-left: 10px;
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

#text {
	text-align: center;
	margin: auto;
}

#topbtn {
	text-align: center
}

.field {
	background-color: white
}
</style>
<!--外部cssファイルの読み込み  -->
<link href="css/design.css" rel="stylesheet" type="text/css">

</head>
<body>
	<h1>Complete</h1>
	<hr>
	<div class="contents">
		<div id="text">
			<p>Edit Complete</p>
			<p>登録情報を下記の内容に変更致しました</p>
		</div>
		<table class="table">
			<caption style="color: #ffffff;">Member information</caption>
			<tr>
				<th class="item">name</th>
				<td class="field"><font color="black"><s:property
							value="newLastName" /> <s:property value="newFirstName" /></font></td>
			</tr>

			<tr>
				<th class="item">phone number</th>
				<td class="field"><s:property value="newUserTel" /></td>
			</tr>

			<tr>
				<th class="item">mail</th>
				<td class="field"><s:property value="newUserEmail" /></td>
			</tr>

			<tr>
				<th class="item">gender</th>
				<td class="field"><s:property value="newGenderStr" /></td>
			</tr>

			<tr>
				<th class="item">user_id</th>
				<td class="field"><s:property value="newUserID" /></td>
			</tr>

		</table>

		<div id="topbtn">
			<s:form action="ReturnTopAction">

				<button class="button4">Top</button>
			</s:form>
		</div>
	</div>

	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>