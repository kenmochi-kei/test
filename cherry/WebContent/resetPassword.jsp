<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>



<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>パスワード再設定</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sato_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body>



<%-- <div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/ja_JP/sdk.js#xfbml=1&version=v2.11';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<script>
window.twttr=(function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],t=window.twttr||{};if(d.getElementById(id))return;js=d.createElement(s);js.id=id;js.src="https://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);t._e=[];t.ready=function(f){t._e.push(f);};return t;}(document,"script","twitter-wjs"));
</script>

<script async defer src="//assets.pinterest.com/js/pinit.js"></script>
 --%>

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />

<!-- メインコンテンツ -->
<div class="outbox1">
	<div class="main">

		<div class="sectionHeader">
			<h1><i class="fa fa-unlock-alt" aria-hidden="true"></i>パスワード再設定<i class="fa fa-unlock-alt" aria-hidden="true"></i></h1>
		</div>
	<div class="error" align="center">
		<s:iterator value="errMsgList">
			<s:div>
				<s:property/>
			</s:div>
		</s:iterator>
	</div>

				<div class="contBody">
					<s:form action="ResetPasswordConfirmAction">
					<table>

					<tr id="box">
						<th>
						<label>cherryID</label>
						</th>
						<td>
						<input type="text"  autofocus name="userId" value="" placeholder="IDを入力" />
						</td>
					</tr>
					<tr id="box">
						<th>
						<label>新しいパスワード</label>
						</th>
						<td>
						<input type="password" name="password" value="" placeholder="パスワードを入力">
						</td>
					</tr>

					<tr id="box">
						<th>
						<label>再確認パスワード</label>
						</th>
						<td>
						<input type="password" name="passwordc" value="" placeholder="再入力してください">
						</td>
					</tr>
					</table>
						<div class="btnn">
							<div class="btnnc">
								<button type="submit">
								<span>確認画面へ</span>
								</button>
							</div>
						</div>
					</s:form>
					<!-- <div class="fb-like"></div>
					<a class="twitter-share-button" href="https://twitter.com/share" data-dnt="true">Tweet</a>
					<a data-pin-do="buttonPin" data-pin-round="true" href="https://www.pinterest.com/pin/create/button/?url=http%3A%2F%2Flocalhost%3A8080%2Fcherry%2FTopAction&media=https%3A%2F%2Ffarm8.staticflickr.com%2F7027%2F6851755809_df5b2051c9_z.jpg&description=Next%20stop%3A%20Pinterest"><img src="//assets.pinterest.com/images/pidgets/pinit_fg_en_round_red_16.png" /></a> -->
				</div>
	</div>
</div>

<!-- フッター -->
<jsp:include page="include_footer.jsp" />

</body>
</html>