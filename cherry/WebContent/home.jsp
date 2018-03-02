<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 金額、日付表示カスタムタグ -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Cherry</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>

<body class="home">

<!-- ヘッダー -->
<jsp:include page="include_header.jsp" />


<!-- メインコンテンツ -->
<div class="top_main clearfix">
	<h1>商品一覧</h1>
	<ul>
		<s:iterator value="#session.proList">
		<li>
			<s:url id="url" action="ProDetailAction">
				<s:param name="id" value="%{product_id}"/>

			</s:url>

			<s:a href="%{url}">

				<s:if test="category_id == 2">
					<span class="category orange">&nbsp;&nbsp;本</span>
				</s:if>
				<s:if test="category_id == 3">
					<span class="category blue">&nbsp;&nbsp;家電&amp;パソコン</span>
				</s:if>
				<s:if test="category_id == 4">
					<span class="category green">&nbsp;&nbsp;おもちゃ&amp;ゲーム</span>
				</s:if>

				<div><img src='<s:property value="image_file_name"/>' alt="画像なし"/></div>



				<p class="name"><s:property value="product_name"/></p>
				<p class="price">\<span><fmt:formatNumber value="${price}" /></span></p>
			</s:a>
		</li>
		</s:iterator>

	</ul>
</div>

<!-- フッター -->
<jsp:include page="include_footer.jsp" />

<script>
$(function() {

	for(var i = 0; i < $(".home .top_main ul li img").length; i++){
	var arra_w = $('.home .top_main ul li img').eq(i).width() - 14;

	var arra_h = $('.home .top_main ul li img').eq(i).height();
	if(arra_w < arra_h || arra_w == arra_h){
		$('.home .top_main ul li img').eq(i).css('max-height','245px');
	}else{
		$('.home .top_main ul li img').eq(i).css('max-width','288px');
	}
	};	//配列をまわす

});	//function
</script>

</body>
</html>