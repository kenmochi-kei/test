<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<!-- フォントの読み込み -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Leave</title>
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




body {
	text-align: center;
	margin: auto;
}

#mpgbtn {
	float: left;
	margin-left: 35%;
	margin-right: -30%
}
</style>
<!--外部cssファイルの読み込み  -->
<link href="css/design.css" rel="stylesheet" type="text/css">

</head>
<body>
	<h1>Leave</h1>
	<hr>
	<div class="contents">
		<p>本当に退会しますか？</p>
		<p>退会をご希望のお客様は「Leave」ボタン押してください</p>
		<br>
		<br>
		<div id="mpgbtn">
			<s:form action="LeaveAction">
			<button class="button4">Leave</button>

			</s:form>
		</div>
		<s:form action="GoToMyPageAction">
		<button class="button4">MyPage</button>

		</s:form>
	</div>
	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare.All Right Reserved</small>.
	</p>
</body>
</html>
