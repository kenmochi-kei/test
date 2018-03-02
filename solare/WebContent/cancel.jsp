<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<!-- フォントの読み込み -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300'rel='stylesheet' type='text/css'>

<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Cancel</title>
<style type="text/css">

/*ボタンデザインのcss*/
button.button4 {
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

	<h1>Cancel confirmation</h1>
	<hr class="head">
	<div class="contents">

		<p>ご予約を取り消しますか？</p>
		<br>
		<s:iterator value="reservationList">
			<s:form action="DeleteReservationAction">
				<table class="table">
					<caption style="color: #ffffff;">ConfirmResister</caption>

					<tr>
						<th>day</th>
						<td><s:property value="date" /></td>
					</tr>

					<tr>
						<th>plan</th>
						<td><s:property value="cours" /> course</td>
					</tr>

					<tr>
						<th>visiting time</th>
						<td><s:property value="date" /></td>
					</tr>

					<tr>
						<th>number of people</th>
						<td><s:property value="ppl" /></td>
					</tr>
				</table>
				<br>

				<input type="hidden" name="reservation_num"
					value="<s:property value="reservation_num" />" />
				<button type="submit" data-icon="♛"
					class="button pink serif round glass">Cancel</button>


			</s:form>
		</s:iterator>
		<div style="display: inline-flex">
			<s:form action="GoToMyPageAction">

				<button class="button4">MyPage</button>
			</s:form>
			<s:form action="AllDeleteReservationAction">

				<button class="button4">AllCancel</button>
			</s:form>
		</div>
	</div>
	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>