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
<title>エラー</title>

<!--外部cssファイルの読み込み  -->
<LINK rel="stylesheet" type="text/css" href="css/design.css">

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
</style>
</head>
<body>
	<div class="contents">
		<h1>Error</h1>
		<hr>

		<p>予期せぬエラーが発生いたしました</p>
		<p>メインメニュー画面からやり直してください</p>

		<s:form action="ReturnTopAction">
		<button class="button4">Top</button>

		</s:form>
	</div>
	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	<p>
</body>
</html>