<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>

<!-- フォントの読み込み -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300'
	rel='stylesheet' type='text/css'>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Confirm Reservation Edit</title>

<!--外部cssファイルの読み込み  -->
<link href="css/design.css" rel="stylesheet" type="text/css">

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


#center {
	margin-left: auto;
	margin-right: auto
}

.field {
	background-color: white
}
</style>
</head>

<body>
	<h1>Confirm the following</h1>
	<hr class="head">
	<div class="contents">
		<p>
			以下の通り予約情報を変更いたします。<br>よろしければ「Decide」ボタンを押してください。
		</p>
		<table class="table">
			<caption style="color: #ffffff;">
				Reservation Information
				<s:property value="customerReservationNumber" />
			</caption>
			<tr>
				<th class="item">Reservation No.</th>
				<td class="field"><font color="black"><s:property
							value="customerReservationNumber" /></font></td>
			</tr>
			<tr>
				<th class="item">date</th>
				<td class="field"><font color="black"><s:property
							value="reservationDate" /></font></td>
			</tr>

			<tr>
				<th class="item">plan</th>
				<td class="field"><font color="black"><s:property
							value="courseNumberString" /></font></td>
			</tr>

			<tr>
				<th class="item">visiting time</th>
				<td class="field"><font color="black"><s:property
							value="reservationTime" /></font></td>
			</tr>

			<tr>
				<th class="item">number of people</th>
				<td class="field"><font color="black"><s:property
							value="numberOfPeople" /></font></td>
			</tr>
		</table>
		<br>
		<table id="center">
			<tr>
				<th><s:form action="GoToReservationEditPageAction">
						<button class="button4">Return</button>

					</s:form></th>
				<td><s:form action="ReservationEditCompleteAction">
						<input type=hidden name="customerReservationNumber"
							value="<s:property value="customerReservationNumber" />">
						<input type=hidden name="reservationDate"
							value="<s:property value="reservationDate" />">
						<input type=hidden name="reservationDateString"
							value="<s:property value="reservationDateString" />">
						<input type=hidden name="courseString"
							value="<s:property value="courseString" />">
						<input type=hidden name="reservationTime"
							value="<s:property value="reservationTime" />">
						<input type=hidden name="numberOfPeople"
							value="<s:property value="numberOfPeople" />">
						<button class="button4">Decide</button>

					</s:form></td>
			</tr>
		</table>
	</div>
	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>