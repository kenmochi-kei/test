<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<!-- フォントの読み込み -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>

<meta name="viewport" content="width=device-width">
<title>Complete New User</title>

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

}


div {
	text-align: center;
	margin: auto;
}

table {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<div>
		<h1>Complete</h1>
		<hr class="head">
		<div class="contents">
			<h2>Thank you for registering your informaition</h2>
			<p>ご登録ありがとうございます</p>
			<p>「Login」からログインし、予約手続きを進めてください。</p>
			<br>
			<table>
				<tr>
					<td><s:form action="ReturnTopAction">
					<button class="button4">Top</button>
							<!--<button data-icon="♛" class="button pink serif round glass">Top</button>-->
						</s:form></td>
					<td><s:form action="GoToReservationPageAction">
							<input type=hidden name="reservationDate"
								value="<s:property value="reservationDate" />">
							<input type=hidden name="courseNumber"
								value="<s:property value="courseNumber" />">
							<input type=hidden name="reservationTime"
								value="<s:property value="reservationTime" />">
							<input type=hidden name="numberOfPeople"
								value="<s:property value="numberOfPeople" />">
							<input type=hidden name="courseString"
								value="<s:property value="courseString" />">
							<input type=hidden name="userRequest"
								value="<s:property value="userRequest" />">
								<button class="button4">Login</button>
							<!--<button data-icon="♛" class="button pink serif round glass">Reservation</button> -->
						</s:form></td>
				</tr>
			</table>
		</div>
	</div>
	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>