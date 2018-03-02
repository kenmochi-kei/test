<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang=“ja”>
<head>

<!--BootStrap読み込み-->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <script src="js/bootstrap.min.js"></script>

<!-- フォントの読み込み -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Resistration Complete</title>

<!--外部cssファイルの読み込み  -->
<link rel="stylesheet" type="text/css" href="css/design.css">

<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">
<style>

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
</style>
</head>
<body>

	<h1>Confirm the following</h1>
	<hr class="head">
	<div class="contents">
		<p>登録内容を確認してください</p>
		<table class="table">
            <caption style="color:#ffffff;">Member information</caption>
			<tr>
				<th class="item">name</th>
				<td><s:property value="fullName" /></td>
			</tr>

			<tr>
				<th class="item">phone number</th>
				<td><s:property value="userTel" /></td>
			</tr>

			<tr>
				<th class="item">mail</th>
				<td><s:property value="userEmail" /></td>
			</tr>

			<tr>
				<th class="item">gender</th>
				<td><s:property value="genderStr" /></td>
			</tr>
			<tr>
				<th class="item">Account ID</th>
				<td><s:property value="userId" /></td>
			</tr>

		</table>
		<br>
		<div id="btns">
			<s:form action="ReturnTopAction">
			<button class="button4">Top</button>
				<!--<button data-icon="♛" class="button pink serif round glass position"
					id="left">Top</button>-->
			</s:form>

			<s:form action="ReturnNewUserAction">
			<button class="button4">Cancel</button>
				<!--<button data-icon="♛" class="button pink serif round glass position">Cancel</button>-->
			</s:form>

			<s:form action="NewUserRegisterCompleteAction">
				<input type="hidden" name="lastName"
					value="<s:property value="lastName" />">
				<input type="hidden" name="firstName"
					value="<s:property value="firstName" />">
				<input type="hidden" name="gender"
					value="<s:property value="gender" />">
				<input type="hidden" name="userTel"
					value="<s:property value="userTel" />">
				<input type="hidden" name="userId"
					value="<s:property value="userId" />">
				<input type="hidden" name="userPassword"
					value="<s:property value="userPassword" />">
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
					<input type=hidden name="userEmail"
					value="<s:property value="userEmail" />">
					<button class="button4">Register</button>
				<!--<button data-icon="♛" class="button pink serif round glass position"
					id="right">Register</button>-->
			</s:form>
		</div>
		<br>
	</div>
	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>