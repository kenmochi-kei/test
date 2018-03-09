<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<title>alatanapizza検索結果</title>

</head>

<body class="home">


<!-- メインコンテンツ -->
<div class="top_main clearfix">
			<h1>
				<s:if test="categoryId == 1">
					<span>全てのカテゴリ</span>
				</s:if>
				<s:if test="categoryId == 2">
					<span>ピザ</span>
				</s:if>
				<s:if test="categoryId == 3">
					<span>サイドメニュー</span>
				</s:if>
				<s:if test="categoryId == 4">
					<span>ドリンク</span>
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

					<p class="name"><s:property value="productName"/></p>
					<p class="price">\<span><s:property value="price"/></span></p>

		</li>
		</s:iterator>

	</ul>
</div>


</body>
</html>