<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 金額、日付表示カスタムタグ -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:property value="pro_detail.product_name" />の詳細ページ</title>


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/reset.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mt_style.css">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/ochiai_style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript"
	src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Dosis"
	rel="stylesheet">

<script>
	function goPutProductIntoCartAction() {
		document.getElementById('form').action = "PutProductIntoCartAction";
	}
</script>

</head>
<body>

	<!-- ヘッダー -->
	<jsp:include page="include_header.jsp" />


	<!-- メインコンテンツ -->
	<div class="main">
		<s:form id="form" name="form" action="PutProductIntoCartAction">
			<div class="detail">
				<div class="leftCol">
					<h1>商品画像</h1>
					<s:hidden name="imageFileName"
						value="%{pro_detail.image_file_name}" />
					<div class="proImg">
						<img src='<s:property value="pro_detail.image_file_name"/>' />
					</div>
					<div class="relation">
						<h4>[関連商品]</h4>
						<ul>
							<s:iterator value="similarInfoDTOList">
								<li><s:url id="url" action="ProDetailAction">
										<s:param name="id" value="%{product_id}" />
									</s:url> <s:a href="%{url}">
										<img src='<s:property value="image_file_name"/>'/>
										<p>
											<s:property value="product_name" />
										</p>
										<p class="price">
											\
											<fmt:formatNumber value="${price}" />
										</p>
									</s:a></li>
							</s:iterator>
						</ul>
					</div>
				</div>






				<div class="rightCol">
					<h1>商品詳細</h1>
					<table class="table">
						<tr>
							<th>商品番号</th>
							<td><s:hidden name="productId"
									value="%{pro_detail.product_id}" /> <s:property
									value="pro_detail.product_id" /></td>
						</tr>
						<tr>
							<th>ふりがな</th>
							<td><s:hidden name="productNameKana"
									value="%{pro_detail.product_name_kana}" /> <s:property
									value="pro_detail.product_name_kana" /></td>
						</tr>
						<tr>
							<th>商品名</th>
							<td><s:hidden name="productName"
									value="%{pro_detail.product_name}" /> <s:property
									value="pro_detail.product_name" /></td>
						</tr>
						<tr>
							<th>商品詳細</th>
							<td><s:hidden name="productDescription"
									value="%{pro_detail.product_description}" /> <s:property
									value="pro_detail.product_description" /></td>
						</tr>
						<tr>
							<th>値段</th>
							<td><s:hidden name="price" value="%{pro_detail.price}" /> \<fmt:formatNumber value="${pro_detail.price}" /></td>
						</tr>
						<tr>
							<th>発売会社</th>
							<td><s:hidden name="releaseCompany"
									value="%{pro_detail.release_company}" /> <s:property
									value="pro_detail.release_company" /></td>
						</tr>
						<tr>
							<th>購入個数</th>
							<td><s:select list="count" name="productCount" value="1" /></td>
						</tr>
						<%-- 	<br><br>
				<s:hidden name="productId" value="%{pro_detail.product_id}" />
				<s:hidden name="duplicationFlg" value="%{duplicationFlg}" />
				<s:if test="duplicationFlg">
				<input type="submit" value="購入個数を変更">
				</s:if>
				<s:else>
				<input type="submit" value="カートに追加">
				</s:else> --%>
						<tr>
					</table>
					<div class="cartbutton">
						<a href="javascript:void(0)"
							onclick="document.form.submit();return false;" class="button">カートに入れる</a>
						<!-- a hrefだとnull pointerのerrorがでる -->
						<!--<a href='<s:url action="PutProductIntoCartAction"/>' class="button">Add to Cart</a>-->
						<!--<s:submit value="Add to Cart" onclick="goPutProductIntoCartAction();"/>-->
						<!--<s:submit class="button" value="Add to Cart"/>-->
					</div>
					<div class="cartbutton">
						<a href="/cherry/GoHomeAction" class="button">ホーム</a>
					</div>

				</div>
				<!--関連商品の表示-->







				<!--
				ProductDTO productDTO = new ProductDTO();
				productDTO.setDef_id(rs.getInt("id"));
				productDTO.setProduct_id(rs.getInt("product_id"));
				productDTO.setProduct_name(rs.getString("product_name"));
				productDTO.setProduct_name_kana(rs.getString("product_name_kana"));
				productDTO.setProduct_description(rs.getString("product_description"));
				productDTO.setCategory_id(rs.getInt("category_id"));
				productDTO.setPrice(rs.getInt("price"));
				productDTO.setImage_file_name(rs.getString("image_file_name"));
				productDTO.setRelease_date(rs.getString("release_date"));
				productDTO.setRelease_company(rs.getString("release_company"));
				productDTO.setRegist_date(rs.getString("regist_date"));
				productDTO.setUpdate_date(rs.getString("update_date"));
 -->


			</div>
		</s:form>
	</div>

	<!-- フッター -->
	<jsp:include page="include_footer.jsp" />


</body>
</html>