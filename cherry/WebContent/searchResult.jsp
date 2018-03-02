<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE HTML>
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
			<h1>
				<s:if test="categoryId == 1">
					<span class="category orange">&nbsp;&nbsp;全てのカテゴリ</span>
				</s:if>
				<s:if test="categoryId == 2">
					<span class="category orange">&nbsp;&nbsp;本</span>
				</s:if>
				<s:if test="categoryId == 3">
					<span class="category blue">&nbsp;&nbsp;家電&amp;パソコン</span>
				</s:if>
				<s:if test="categoryId == 4">
					<span class="category green">&nbsp;&nbsp;おもちゃ&amp;ゲーム</span>
				</s:if>
			</h1>

		<s:iterator value="msgList">
			<h1>検索キーワード "<s:property />"</h1>
		</s:iterator>
		<s:if test="searchDTOList.size()==0">
			<h1>検索結果がありません。</h1>
		</s:if>
	<ul>
		<s:iterator value="searchDTOList">
		<li>
			<s:url id="url" action="ProDetailAction">
				<s:param name="id" value="productId"/>

			</s:url>

			<s:a href="%{url}">
				<s:if test="categoryId == 2">
					<span class="category orange">&nbsp;&nbsp;本</span>
				</s:if>
				<s:if test="categoryId == 3">
					<span class="category blue">&nbsp;&nbsp;家電&amp;パソコン</span>
				</s:if>
				<s:if test="categoryId == 4">
					<span class="category green">&nbsp;&nbsp;おもちゃ&amp;ゲーム</span>
				</s:if>


				<div><img src='<s:property value="imageFileName"/>' alt="画像なし"/></div>
					<p class="name"><s:property value="productName"/></p>
					<p class="price">\<span><s:property value="price"/></span></p>
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
		$('.home .top_main ul li img').eq(i).css('max-width','281px');
	}
	};	//配列をまわす

});	//function
</script>
</body>
</html>