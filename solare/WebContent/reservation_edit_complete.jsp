<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<!--BootStrap読み込み-->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/bootstrap.min.js"></script>

<!-- フォントの読み込み -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300'
	rel='stylesheet' type='text/css'>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Reservation Complete</title>
<link rel="stylesheet" type="text/css" href="css/design.css">
<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">

<style>

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


.field {
	background-color: white
}

#btntable {
	margin-left: auto;
	margin-right: auto
}
</style>
</head>

<body>
	<h1>Reservation Complete</h1>
	<hr>
	<div class="contents">
		<p>下記の内容に変更致しました</p>
		<table class="table" style="color: white">
			<caption style="color: #ffffff;">
				reservation
				<s:property value="customerReservationNumber" />
			</caption>
			<tr>
				<th class="item">Reservation No.</th>
				<td><s:property value="customerReservationNumber" /></td>
			</tr>
			<tr>
				<th class="item">plan</th>
				<td><s:property value="courseString" /></td>
			</tr>
			<tr>
				<th class="item">day</th>
				<td><s:property value="reservationDate" /></td>
			</tr>

			<tr>
				<th class="item">visiting time</th>
				<td><s:property value="reservationTime" /></td>
			</tr>
			<tr>
				<th class="item">number of people</th>
				<td><s:property value="numberOfPeople" /> 人</td>
			</tr>
		</table>

		<table id="btntable">
			<tr>
				<td><s:form action="GoToMyPageAction">
						<button class="button4">MyPage</button>

					</s:form></td>

				<td><s:form action="LogOutAction">
						<button class="button4">LogOut</button>

					</s:form></td>
		</table>
	</div>
	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>