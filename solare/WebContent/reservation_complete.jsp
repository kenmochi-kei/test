<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Reservation Complete</title>
<link rel="stylesheet" type="text/css" href="css/design.css">
<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">
<style>


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
.position {
	display: block;
}

#btns {
	width: 50%;
	display: box;
	display: -webkit-box;
	display: -moz-box;
	display: -o-box;
	display: -ms-box;
	box-pack: justify;
	-moz-box-pack: justify;
	-webkit-box-pack: justify;
	-o-box-pack: justify;
	-ms-box-pack: justify;
	margin: 0 auto;
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
		<table class="table" style="color:white">
            <caption style="color:#ffffff;">Reservation</caption>

			<tr>
				<th class="item">Date</th>
				<td class="field"><font color="black"><s:property value="calendar" /></font></td>
			</tr>

			<tr>
				<th class="item">Plan</th>
				<td class="field"><font color="black"><s:property value="courseNumber" /></font></td>
			</tr>

			<tr>
				<th class="item">Visiting time</th>
				<td class="field"><font color="black"><s:property value="reservationTime" /></font></td>
			</tr>

			<tr>
				<th class="item">NumberOfPeople</th>
				<td class="field"><font color="black"><s:property value="numberOfPeople" /></font></td>
			</tr>

            <tr>
			    <th class="item">Payment of method</th>
				<td class="field"><font color="black"><s:property value="pay" /></font></td>
		    </tr>

				<tr>

					<th class="item">Card</th>
					<td class="field"><font color="black"><s:property value="card" /></font></td>
				</tr>
				</table>


		<table id="btntable">
			<tr>
				<td><s:form action="GoToMyPageAction">
				<button class="button4">MyPage</button>
						<!--<button data-icon="♛" class="button pink serif round glass">MyPage</button>-->
					</s:form></td>

				<td><s:form action="LogOutAction">
				<button class="button4">LogOut</button>
						<!--<button data-icon="♛" class="button pink serif round glass">LogOut</button>-->
					</s:form></td>
		</table>
	</div>
	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>