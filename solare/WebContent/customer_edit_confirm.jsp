<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- フォントの読み込み -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>

<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Confirm Customer Information Edit</title>
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




#text {
	text-align: center;
	margin: auto;
}

.field {
	background-color: white
}

#editbtn {
	float: right;
	margin-right: 30%
}

#mypgbtn {
	margin-left: 30%;
	margin-bottom: 50px
}
</style>

<!--外部cssファイルの読み込み  -->
<link href="css/design.css" rel="stylesheet" type="text/css">

</head>
<body>
	<h1>Confirm the following</h1>
	<hr>
	<div class="contents">
		<p id="text">
			以下のように会員情報を変更します。<br>よろしければ「Edit」ボタンを押してください。
		</p>

		<table class="table">

            <caption style="color:#ffffff;">Member information</caption>
			<tr>
				<th class="item">Customer Name</th>
				<th class="field"><font color="black"><s:property value="newLastName" /> <s:property
						value="newFirstName" /></font></th>
			</tr>

			<tr>
				<th class="item">phone number</th>
				<th class="field"><s:property value="newUserTel" /></th>
			</tr>

			<tr>
				<th class="item">mail</th>
				<th class="field"><s:property value="newUserEmail" /></th>
			</tr>

			<tr>
				<th class="item">gender</th>
				<th class="field"><s:property value="newGenderStr" /></th>
			</tr>

			<tr>
				<th class="item">user_id</th>
				<th class="field"><s:property value="newUserID" /></th>
			</tr>
		</table>

		<s:form action="ChangeCustomerInfoCompleteAction">
			<div id="editbtn">
				<input type="hidden" name="newLastName"
					value="<s:property value="newLastName" />"> <input
					type="hidden" name="newFirstName"
					value="<s:property value="newFirstName" />"> <input
					type="hidden" name="newUserTel"
					value="<s:property value="newUserTel" />"> <input
					type="hidden" name="newUserEmail"
					value="<s:property value="newUserEmail" />"> <input
					type="hidden" name="newGender"
					value="<s:property value="newGender" />"> <input
					type="hidden" name="newUserID"
					value="<s:property value="newUserID" />"> <input
					type="hidden" name="newUserPass"
					value="<s:property value="newUserPass" />"><input
					type="hidden" name="confirmPass"
					value="<s:property value="confirmPass" />">
					<button class="button4">Edit</button>

			</div>
		</s:form>

		<div id="mypgbtn">
			<s:form action="ReturnCustomerEditAction">
			<button class="button4">Return</button>

			</s:form>
		</div>
	</div>

	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>