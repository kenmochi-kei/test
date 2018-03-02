<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- フォントの読み込み -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>

<meta name="viewport" content="width=device-width">
<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">
<title>MyPage</title>
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

#btntable {
	margin-left: auto;
	margin-right: auto;
	margin-top: 150px;


}
</style>

<!--外部cssファイルの読み込み  -->
<link href="css/design.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="h1Border">
	<h1>My Page</h1>
    </div>

	<div class="contents">
	<s:property value="message" />
		<h2>
			ようこそ
			<s:property value="#session.lastName" />
			さん
		</h2>
		<br>
		<p>お客様情報の編集はこちら</p>


		<p>予約情報の変更、キャンセルはこちら</p>

		<s:form action="GoToReservationEditPageAction">
		<button class="button4">Reservation Edit</button>
			<!--<button data-icon="♛" class="button pink serif round glass">Reservation
				Edit</button>-->
		</s:form>

		<s:property value="logOutMsg" />
		<table id="btntable">
			<tr>
				<td><s:form action="ReturnTopAction">
				<button class="button4">Top</button>
						<!--<button data-icon="♛" class="button pink serif round glass">Top</button>-->
					</s:form></td>

				<td><s:form action="LogOutAction">
				<button class="button4">LogOut</button>
						<!--<button data-icon="♛" class="button pink serif round glass">LogOut</button>-->
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