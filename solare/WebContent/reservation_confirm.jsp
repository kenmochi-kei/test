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
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>

<meta name="viewport" content="width=device-width">
<title>Reservation Confirm</title>

<!--外部cssファイルの読み込み  -->
<link rel="stylesheet" type="text/css" href="css/design.css">

<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">
<style type="text/css">


/*ボタンデザインのcss*/
button.button4 {
	margin-top:20px;
	margin-right:10px;
	margin-left:10px;

border-color:white;
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



div {
	text-align: center;
	margin: auto;
}

table {
width: 600px;
	text-align: center;
	/*margin: auto;*/
	margin-right:auto;
	margin-left:auto;
}
</style>
</head>
<body>
	<h1>Confirm the following</h1>
	<hr class="head">

	<div class="contents">
		<p>
			以下の内容でご予約を承ります。<br>お間違いないですか？
		</p>
		<div>
			<table class="table">
				<tr>
					<th class="item">Course Plan</th>
					<td><s:property value="courseString" /> Course</td>
				</tr>

				<tr>
					<th class="item">Number of people</th>
					<td><s:property value="numberOfPeople" />名様</td>
				</tr>

				<tr>
					<th class="item">Date</th>
					<td><s:property value="calendar" /></td>
				</tr>

				<tr>
					<th class="item">Visiting time</th>
					<td><s:property value="reservationTime" /></td>
				</tr>

				<tr>
					<th class="item">Payment of method</th>
					<td><s:property value="pay" /></td>
				</tr>
				<tr>

					<th class="item">Card</th>
					<td><s:property value="card" /></td>
				</tr>
			</table>
		</div>

		<div style="width:500px; margin-right:auto; margin-left:auto; text-align:center;">
			<p>上記の内容によろしいでしょうか？</p>
			<form action="ReservationCompleteAction">
							<input type=hidden name="calendar"
								value="<s:property value="calendar" />">
							<input type=hidden name="courseNumber"
								value="<s:property value="courseNumber" />">
							<input type=hidden name="reservationTime"
								value="<s:property value="reservationTime" />">
							<input type=hidden name="numberOfPeople"
								value="<s:property value="numberOfPeople" />">
							<input type=hidden name="courseString"
								value="<s:property value="courseString" />">
								<input type=hidden name="pay"
								value="<s:property value="pay" />">
								<button class="button4">Reservation</button>
						<!--<button data-icon="♛" class="button pink serif round glass">Reservation</button>-->
						</form>
			<form action="ReturnReservationPageAction">
							<button class="button4">Edit</button>
							<!--<button data-icon="♛" class="button pink serif round glass">Edit</button>-->
						</form>


		</div>
	</div>
	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>