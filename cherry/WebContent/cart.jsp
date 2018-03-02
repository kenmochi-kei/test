<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- 金額、日付表示カスタムタグ -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート画面</title>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mt_style.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cart_style.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script><script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
<!-- ヘッダー -->
	<jsp:include page="include_header.jsp" />
<!-- ヘッダーここまで -->


<!-- ここからメイン -->



<div class="main">

	<h2 class="title">カート</h2><br>

		<s:property value="errMsg"/>
		<!-- カートが殻のときのメッセージ！！ -->
			<s:if test="cartList.isEmpty()">
				<p class="message">カートの中は空です</p>
			</s:if>
		<!-- カートが殻のときのメッセージここまで -->

			<s:else>
				<p class="message">カートには以下の商品が入っています</p>

<!----------------- カート内容ここから --------------------------------------->

			<s:iterator value="cartList">

			<div class="border">
            		</div>

	<div class="main_content clearfix_hon">
		<!-- 画像 --><div class="pro_img">
						<s:url id="url" action="ProDetailAction"><s:param name="id" value="productId" /></s:url>
							<s:a href="%{url}">
								<img src='<s:property value="image_file_name"/>' alt="画像なし"/>
							</s:a>
					</div>

	<div class="pro_text">
					<div class="name">
					<s:url id="url" action="ProDetailAction"><s:param name="id" value="productId" /></s:url>
								<s:a href="%{url}">
		<!-- ふりがな --><div class="kana">
							<s:property value="product_name_kana" />
						</div>

		<!-- 商品名 --><div class="pro_name">
							商品名:
								<s:property value="product_name" />
						</div>
						</s:a>
					</div>


				<div class="price_count">
		<!-- 値段 --><div class="price">
							価格:\
							<fmt:formatNumber value="${price}" />
						</div>

		<!-- 個数 --><div class="count">
							(購入数:  <s:property value="productCount" />点)
						</div>
		<%-- <!-- 小計 --><div class="subtotal">
						小計
							${price * productCount}
						</div> --%>
				</div>
					 <div class="comp_info">
		<!-- 発売会社 --><div class="company">
							発売会社：<s:property value="release_company" />
						</div>

		<!-- 年月日 --><div class="release_date">
							発売日：<%-- <s:date name="releaseDate" format="yyyy年MM月dd日" /> --%>
									<fmt:parseDate var="date2" value="${release_date}" pattern="yyyy-MM-dd HH:mm:ss.SS" /><fmt:formatDate value="${date2}" pattern="yyyy年M月d日" />
						</div>
					</div>



			<!-- 削除ボタンここから -->
			<div class="delete">
				<s:form action="CartDeleteAction">
					<a href='<s:url action="CartDeleteAction"><s:param name="productId" value="productId"></s:param></s:url>'>削除</a>
				</s:form>
			</div>
			<!-- 削除ここまで -->
		</div>
				</div>


			</s:iterator>
			<div class="border">
            		</div>
		</s:else>
	</div>


<!----------------- カート内容ここまで --------------------------------------->

	<!-- 合計金額を表示 -->
		<div class="totalprice">
			合計金額:\
			<fmt:formatNumber value="${totalPrice}" />
		</div>
	<!-- 合計金額ここまで -->


	<!-- 決済にとばす -->
       <s:if test="! cartList.isEmpty()">
		<div class="settlement_btn">
			<a href='<s:url action="PurchaseInfoAction" />'>決済画面へ</a>
		</div>

		</s:if>
	<!-- 決済にとばすここまで -->

<!-- F5, Backspaceの無効化 -->
<script>
	$(function(){
		$(document).keydown(function(event){
			//クリックされたキーコードを取得する
			var keyCode = event.keyCode;

			//F5の場合はfalseをリターン
			if(keyCode == 116){
				console.log("F5");
				return false;
			}

			//バックスペースキーを制御する
			if(keyCode == 8){
				console.log("Backspace");
				return false;
			}
		})
	});
</script>

</body>
<!-- フッター -->
	<jsp:include page="include_footer.jsp" />
<!-- フッターここまで -->
</html>



















