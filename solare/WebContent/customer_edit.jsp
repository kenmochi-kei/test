<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<!--Bootstrap読み込み-->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/bootstrap.min.js"></script>

<!-- フォントの読み込み -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300'
	rel='stylesheet' type='text/css'>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">
<title>CustomEdit</title>
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


div {
	text-align: center;
	margin: auto;
}

#edit {
	float: right;
	margin-right: 33%;
}

#mypg {
	margin-left: 25%;
}

leave {
	margin-right: 5%
}

#footer {
	clear: both;
	margin-top: 100px
}

:valid {
	color: green;
}

:invalid {
	color: red;
}

#gender {
	color: black
}
</style>

<!--外部cssファイルの読み込み  -->
<link href="css/design.css" rel="stylesheet" type="text/css">

</head>
<body>
	<h1>Member Information</h1>
	<hr>
	<div class="contents">
		<s:form action="GoToCustomerEditConfirmPageAction">
			<table class="table" style="margin-bottom: 30px;">

				<caption style="color: #ffffff;">Member information</caption>

				<tr>
					<th class="item">Name</th>
					<td class="field"><input type="text" size="20"
						name="newLastName" maxlength="30" placeholder="苗字を入力してください"
						pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,12}" autofocus
						title="数字・記号は使用できません" required> <input type="text"
						size="20" name="newFirstName" maxlength="30"
						placeholder="名前を入力してください"
						pattern="[ぁ-んァ-ヶ亜-黑一-十a-zA-Zａ-ｚＡ-Ｚー]{1,12}" autofocus
						title="数字・記号は使用できません" required></td>
				</tr>
				<tr>
					<th class="item">Phone number</th>
					<td class="field"><input type="tel" size="30"
						name="newUserTel" maxlength="11" placeholder="電話番号を入力してください"
						pattern="[0-9]{10,11}" autofocus title="数字で入力してください" required></td>
				<tr>
					<th class="item">Email</th>
					<td class="field"><input type="email" size="30"
						maxlength="256" name="newUserEmail" placeholder="メールアドレスを入力してください"
						autofocus required></td>
				</tr>

				<tr>
					<th class="item">Gender</th>
					<td id="gender"><input type="radio" name="newGender" value="0"><font
						color="white">Man <input type="radio" name="newGender"
							value="1" required>Woman
					</font></td>
				</tr>

				<tr>
					<th class="item">Account ID</th>
					<td class="field"><input type="text" size="45" maxlength="16"
						name="newUserID" placeholder="半角英数字で８字以上１６字以下で入力してください"
						pattern="[0-9a-z]{8,16}" autofocus title="半角英数字のみ使用可能です" required></td>
				</tr>

				<tr>
					<th class="item">Password</th>
					<td class="field"><input type="password" size="45"
						maxlength="32" name="newUserPass"
						placeholder="半角英数字で８字以上３２字以下で入力してください" pattern="[0-9a-z]{8,32}"
						autofocus title="半角英数字のみ使用可能です" required></td>
				</tr>

				<tr>
					<th class="item">Confirm Password</th>
					<td class="field"><input type="password" size="45"
						maxlength="32" name="newConfirmPass"
						placeholder="確認用パスワードを入力してください" pattern="[0-9a-z]{8,32}" autofocus
						title="半角英数字のみ使用可能です" required></td>
				</tr>
				<s:property value="errorMessage1" />
				<s:property value="errorMessage2" />
			</table>

			<div id="edit">
				<button class="button4">Edit</button>

			</div>
		</s:form>

		<div id="mypg">
			<s:form action="GoToMyPageAction">

				<button class="button4">MyPage</button>
			</s:form>
		</div>
		<br> <br> <br>
		<div id="leave">
			<p>退会ご希望のお客様はこちら</p>


			<s:form action="GoToLeaveAction">

				<button class="button4">Leave</button>
			</s:form>
		</div>
	</div>
	<hr class="foot" id="footer">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>