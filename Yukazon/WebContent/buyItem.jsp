<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />

	<title>商品画面</title>

	<style type="text/css">
/* ========TAG LAYOUT======== */
	body {
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
		font-family:Verdana, Helvetica, sans-serif;
		font-size:12px;
		color:#333;
		background:#fff;
	}
	table {
		text-align:center;
		margin:0 auto;
	}
/* ========ID LAYOUT======== */
	#top {
		width:780px;
		margin:30px auto;
		border:1px solid #333;
	}
	#header {
		width: 100%;
		height: 80px;
		background-color: black;
	}
	#main {
		width: 100%;
		height: 500px;
		text-align: center;
	}
	#footer {
		width: 100%;
		height: 80px;
		background-color: black;
		clear:both;
	}
	.right {
     text-align: right;
}
	</style>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
<div>
		<s:form action="ItemSearchAction">

			<tr>
				<td><p class="right">
					<s:textfield name="searchWord" placeholder="商品検索"/>
				</p></td>
				<td><p class="right">
					<s:submit value="検索"/>
				</p></td>
			</tr>

		</s:form>

		<s:if test="message != ''">
			<h3><s:property value="message" escape="false"/></h3>
		</s:if>

		<s:form action="BuyItemAction">
			<table>
				<s:iterator value="buyItemDTOList">

				<tr>
					<td>
						<h3><s:property value="itemName"/></h3>
					</td>
				</tr>



				<tr>
					<td>
						<span>値段</span>
					</td>
					<td>
						<s:property value="itemPrice" /><span>円</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>在庫</span>
					</td>
					<td>
					<s:if test="item_stock>0">
						<s:property value="item_stock"/>
					</s:if>
					<s:else>
						<span>品切れ</span>
					</s:else>
					</td>
				</tr>

				<tr>
					<td>
						<span>購入個数</span>
					</td>
					<td>
					<s:if test="item_stock>0">
						<select name="count">
							<option value="0" selected="selected">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</s:if>
					<s:else>
						<select name="count">
							<option value="0" selected="selected">0</option>
						</select>
					</s:else>
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				</s:iterator>

				<tr>
					<td>
						<s:submit value="カートに入れる"/>
					</td>
				</tr>

			</table>
		</s:form>

			<!-- <div>
				 <p>マイぺージは<a href='<s:url action="MyPageAction" />'>こちら</a></p>
			</div>-->
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>