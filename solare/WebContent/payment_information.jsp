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

<!-- jQueryの読み込み -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支払い選択</title>
<link rel="stylesheet" href="css/design.css">
</head>
<style>
input, select {
	color: black
}

/*ボタンデザインのcss*/
.button4 {
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

.pinput {
	font-size: 1.0em;
}

table {
	width: 500px;
	margin-right: auto;
	margin-left: auto;
	padding-left: 100px;
}

h3 {
		text-align: center;
		color: red;
	}
</style>

<body style="color: white;">
	<h1>Payment</h1>
	<h3>
		<span>
			<s:property value="payNotFundErrorMessage" />
		</span>
	</h3>
	<div>
		<form name="form1" action="GoToReservationConfirmationPageAction">
			<table>

				<!-- 支払方法の選択 -->
				<tr>

				</tr>
				<tr>
				</tr>

				<tr>
					<td><input type="radio" id="cash" name="pay" value="Cash"
						onClick="changeDisabled()" checked> <label for="cash">現金支払い</label>
						<s:property value="pay" /></td>
				</tr>

				<tr>
					<td><input type="radio" id="credit" name="pay"
						value="Credit card" onClick="changeDisabled()"> <label
						for="credit">クレジットカード</label> <s:property value="pay" /></td>
				</tr>
			</table>
			<br>
			<table>
				<tr id="cardSelect">
					<th>カードを選択</th>
					<td>
						<!-- カードの種類を選択 --> <select name="card" style="color: black"
						required><s:property value="card" />
							<option value=""></option>
							<option value="VISA">VISA</option>
							<option value="JCB">JCB</option>
							<option value="MASTER">MASTER</option>
					</select>
					</td>
				</tr>

				<tr id="text1">
					<th>Card holder</th>
					<!-- カード名義を入力 -->
					<td><input type="text" name="cardHolder" size="30"
						maxlength="20" pattern="^[A-Z| |]{,20}"
						title="大文字アルファベット20文字以下で入力してください。" placeholder="名前を入力してください"
						required /></td>
				</tr>

				<tr id="text2">
					<th>Card number</th>
					<td>
						<!-- カード番号を入力 --> <input type="password" name="cardNumber"
						size="30" pattern="[0-9]{16}" maxlength="16"
						title="数字のみ16桁を入力してください。" placeholder="カード番号を入力してください" required />
					</td>
				</tr>

				<tr id="Period">
					<th>MONTH/YEAR</th>
					<!-- カード有効期限を選択 -->
					<td><select name="cardMonth" required>
							<option value=""></option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
					</select> <select id="Year" name="cardYear" required>
							<option value=""></option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
					</select></td>
				</tr>

				<tr id="text3">
					<th>Security code</th>
					<td>
						<!-- セキュリティコードを入力 --> <input type="password" name="securityCode"
						size="30" maxlength="4" pattern="[0-9]{3,4}"
						title="数字のみ3桁又は4桁を入力してください。" placeholder="セキュリティコードを入力してください"
						required />
					</td>
				</tr>
			</table>
			<p align="center" class="pinput">
				<input type="submit" name="btn1" value="ReservationConfirm"
					class="button4" />
			</p>
		</form>

		<form action="BackPageAction">
			<p align="center" class="pinput">
				<input type="submit" name="btn2" value="Back" class="button4" />
			</p>
		</form>

		<script>
			function changeDisabled() {
				//クレジットカード情報の入力可にする
				if (document.form1["pay"][1].checked) {
					document.form1["card"].disabled = false;
					document.form1["cardHolder"].disabled = false;
					document.form1["cardNumber"].disabled = false;
					document.form1["cardMonth"].disabled = false;
					document.form1["cardYear"].disabled = false;
					document.form1["securityCode"].disabled = false;
				}
				//クレジットカード情報の入力不可にする
				else {
					document.form1["card"].disabled = true;
					document.form1["cardHolder"].disabled = true;
					document.form1["cardNumber"].disabled = true;
					document.form1["cardMonth"].disabled = true;
					document.form1["cardYear"].disabled = true;
					document.form1["securityCode"].disabled = true;
				}
			}
			//ページを表示したとき、changeDisabled()を呼び出す
			window.onload = changeDisabled;
		</script>
	</div>

	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>

</html>

