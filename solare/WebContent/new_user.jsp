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
<title>New Customer Registration</title>

<!--外部cssファイルの読み込み  -->
<link href="css/design.css" rel="stylesheet" type="text/css">

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




.iti {
	float: right;
	margin-right: 30%;
	margin-left: -20%
}

:valid {
	color: green;
}

:invalid {
	color: red;
}

#gen {
	color: black
}
</style>

</head>
<body>

	<div style="text-align: center">
		<h1>Solare Member Registration</h1>
		<hr class="head">
		<div class="contents">

			<s:form action="GoToNewUserConfirmPageAction" theme="simple">
				<table class="table">
                    <caption style="color:#ffffff;">Member Registration</caption>
					<tr>
						<th class="item">Name</th>
						<td><input type="text" size="20" name="lastName"
							maxlength="30" placeholder="苗字を入力してください"
							pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,12}" autofocus required>

							<input type="text" size="20" name="firstName" maxlength="30"
							placeholder="名前を入力してください"
							pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,12}" autofocus required
							title="数字・記号は使用できません"></td>
					</tr>

					<tr>
						<th class="item">Phone number</th>
						<td><input type="tel" size="30" name="userTel" maxlength="11"
							placeholder="電話番号を入力してください" pattern="[0-9]{10,11}" autofocus
							required></td>
					</tr>

					<tr>
						<th class="item">Email</th>
						<td><input type="email" size="30" maxlength="256"
							name="userEmail" placeholder="メールアドレスを入力してください" autofocus
							required></td>
					</tr>

					<tr>
						<th class="item">Gender</th>
						<td id="gen"><input type="radio" name="gender" value="0"><font color="white">Man</font>
							<input type="radio" name="gender" value="1" required><font color="white">Woman</font></td>
					</tr>

					<tr>
						<th class="item">Account ID</th>
						<td><input type="text" size="45" maxlength="16" name="userId"
							placeholder="半角英数字で８字以上１６字未満で入力してください" pattern="[0-9a-z]{8,16}"
							autofocus required title="半角英数字で入力してください"></td>
					</tr>

					<tr>
						<th class="item">Password</th>
						<td><input type="password" size="45" maxlength="32"
							name="userPassword" placeholder="半角英数字で８字以上３２字未満で入力してください"
							pattern="[0-9a-z]{8,32}" autofocus required
							title="半角英数字で入力してください"></td>
					</tr>

					<tr>
						<th class="item">Confirm Password</th>
						<td><input type="password" size="45" maxlength="32"
							name="userPass2" placeholder="確認用パスワードを入力してください"
							pattern="[0-9a-z]{8,32}" autofocus required
							title="半角英数字で入力してください"></td>
					</tr>
					<s:property value="msg" />
					<s:property value="msg2" />
				</table>
				<br>
				<button class="button4">Complete</button>
				<!--<button data-icon="♛" class="button pink serif round glass iti">Complete</button>-->
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
			</s:form>

			<s:form action="ReturnTopAction">
			<button class="button4">Top</button>
				<!--<button data-icon="♛" class="button pink serif round glass">Top</button>-->
			</s:form>
		</div>
	</div>

	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>