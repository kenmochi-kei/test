<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <%@ taglib prefix="s" uri="/struts-tags"%>
        <html lang=“ja”>

        <head>
        <!-- フォントの読み込み -->
            <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>

            <link href="img/favicon.ico" rel="icon" type="img/ico" />
            <link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width">

            <!--外部cssファイルの読み込み  -->
            <link href="css/design.css" rel="stylesheet" type="text/css">
            <title>Login</title>
            <style type="text/css">

            /*ボタンデザインのcss*/
                button.button4 {
                    margin-top: 20px;
                    margin-right: 10px;
                    margin-left: 10px;
                    border-color: white;
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

                .msg {
                    color: red;
                    font-size: 1.7em;
                    font-weight: bold
                }

                #ft {
                    clear: both;
                }

                .line {
                    margin-bottom: 100px;
                    text-align: center;
                }

                .btn1 {
                    float: left
                }

                #btn2 {
                    margin-left: 35%
                }

                #topbtn {
                    margin-left: auto;
                    margin-right: auto;
                    margin-top: 100px;
                    clear: both
                }
            </style>
        </head>

        <body>


            <div class="contents">
                <h1>Login</h1>
                <hr>
                <p>
                    <div class="msg"><s:property value="message" /></div>
                    <div class="msg"><s:property value="errorMessage" /></div>
                    <div class="msg"><s:property value="logOutMsg" /></div>
                    <s:form action="LoginAction">
                        <table class="table">
                            <tr>
                                <th class="item">Account ID</th>
                                <td>
                                                                    <input type="text" size="50" maxlength="45" name="userId" placeholder="半角英数字で８字以上１６字未満で入力してください">
                                <!--
                                    <input type="text" size="50" maxlength="45" name="userId" placeholder="半角英数字で８字以上１６字未満で入力してください" pattern="[0-9a-z]{8,16}" autofocus required>
                                -->
                                </td>
                            </tr>

                            <tr>
                                <th class="item">Password</th>
                                <td>
                                    <input type="password" size="50" maxlength="32" name="userPassword" placeholder="半角英数字で８字以上３２字未満で入力してください" pattern="[0-9a-z]{8,32}" autofocus required>
                                </td>
                            </tr>
                        </table>
                        <br>
                        <input type=hidden name="reservationDate" value="<s:property value=" reservationDate " />">
                        <input type=hidden name="courseNumber" value="<s:property value=" courseNumber " />">
                        <input type=hidden name="reservationTime" value="<s:property value=" reservationTime " />">
                        <input type=hidden name="numberOfPeople" value="<s:property value=" numberOfPeople " />">
                        <input type=hidden name="courseString" value="<s:property value=" courseString " />">
                        <input type=hidden name="userRequest" value="<s:property value=" userRequest " />">
                        <input type=hidden name="logOutFlag" value="<s:property value=" logOutFlag " />">
                        <div class="btn1" id="btn2">

<!--
                        <s:url var="facebook" action="login-facebook" />
                        <s:a href="%{facebook}">
                        <img src="img/facebook-j.png"></s:a>

                        <s:url var="twitter" action="login-twitter" />
                        <s:a href="%{twitter}">
                        <img src="img/twitter-j.png"></s:a>s
-->
                       <button class="button4">Login</button>

                        </div>
                    </s:form>

                    <s:form action="GoToNewUserPageAction">
                        <input type=hidden name="reservationDate" value="<s:property value=" reservationDate " />">
                        <input type=hidden name="courseNumber" value="<s:property value=" courseNumber " />">
                        <input type=hidden name="reservationTime" value="<s:property value=" reservationTime " />">
                        <input type=hidden name="numberOfPeople" value="<s:property value=" numberOfPeople " />">
                        <input type=hidden name="courseString" value="<s:property value=" courseString " />">
                        <input type=hidden name="userRequest" value="<s:property value=" userRequest " />">
                        <div class="btn1">
                            <button class="button4">CreateAccount</button>

                        </div>
                    </s:form>
                    <div id="topbtn">
                        <s:form action="ReturnTopAction">
                            <button class="button4">Top</button>

                        </s:form>
                    </div>
            </div>

            <hr class="foot">
            <p class="copy">
                <small>Copyright © 2017 Solare. All Rights Reserved.</small>
            </p>


        </body>

        </html>