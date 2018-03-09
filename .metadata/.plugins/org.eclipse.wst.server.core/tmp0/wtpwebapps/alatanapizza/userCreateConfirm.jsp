<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv = "Content-Type" content = "text/html; charset = utf-8"/>
  <meta http-equiv = "Content-Style-Type" content = "text/css"/>
  <meta http-equiv = "Content-Script-Type" content = "text/javascript"/>

  <link href="css/craftdenki.css" rel="stylesheet">

  <title>確認画面</title>

</head>

<body>
  <div id = "header"> </div>

  <div id = "main">
    <div id ="top">
      <p>ユーザー登録</p>
    </div>


    <div>登録する内容は以下でよろしいですか？</div>

      <table>
      <s:form action="UserCreateCompleteAction">


      <tr id = "box">
        <td> <label>ユーザーID : </label> </td>
        <td> <s:property value = "loginUserId" /> </td>
      </tr>

      <tr id = "box">
        <td> <label>ログインPASS : </label> </td>
        <td> <s:property value = "loginPassword" /> </td>
      </tr>

      <tr id = "box">
        <td> <label>苗字 : </label> </td>
        <td> <s:property value = "familyName" /> </td>
      </tr>

      <tr id = "box">
        <td> <label>名前 : </label> </td>
        <td> <s:property value = "firstName" /> </td>
      </tr>

      <tr id = "box">
        <td> <label>苗字（かな） : </label> </td>
        <td> <s:property value = "familyNameKana"/> </td>
      </tr>

      <tr id = "box">
        <td> <label>名前（かな） : </label> </td>
        <td> <s:property value = "firstNameKana"/> </td>
      </tr>

      <tr id = "box">
        <td> <label>性別 : </label> </td>
          <td> <s:if test = "sex == 0">男</s:if>
	 		   <s:if test = "sex == 1">女</s:if>
	 	  </td>
      </tr>

      <tr id = "box">
        <td> <label>メールアドレス : </label> </td>
        <td> <s:property value = "mail"/> </td>
      </tr>

      <tr id = "box">
        <td> <label>秘密の質問 : </label></td>
          <td> <s:if test = "secretQuestion == 1">好きな食べ物</s:if>
	 		   <s:if test = "secretQuestion == 2">嫌いな食べ物</s:if>
	 	  </td>
      </tr>

      <tr id = "box">
        <td> <label>答え : </label> </td>
        <td> <s:property value = "secretAnswer"/> </td>
      </tr>

      <tr id = "box">
        <td> <label>郵便番号 : </label> </td>
        <td> <s:property value = "yubin"/> </td>
      </tr>

      <tr id = "box">
        <td> <label>住所 : </label> </td>
        <td> <s:property value = "address"/> </td>
      </tr>

      <tr id = "box">
        <td> <label>電話番号 : </label> </td>
        <td> <s:property value = "tel"/> </td>
      </tr>


      <tr>
        <td>
            <s:submit value = "登録する" />
        </td>
      </tr>

      </s:form>
      </table>
    </div>


  <div id = "footer"> </div>

</body>
</html>