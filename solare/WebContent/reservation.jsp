<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<!--BootStrap読み込み-->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <script src="js/bootstrap.min.js"></script>
	<!-- フォントの読み込み -->
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
	<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">
	<!--外部cssファイルの読み込み  -->
	<link href="css/design.css" rel="stylesheet" type="text/css">
	<!-- jQuery読み込み -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script type="text/javascript" src="js/easyselectbox.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
	<script>
		  $(function() {
		    $("#datepicker").datepicker();
		  });
	</script>
	<script type="text/javascript">
		(function($) {
			$('.easy-select-box').easySelectBox({
				speed : 200
			});
		})(jQuery);
	</script>
	<style>
		input{

		  border:1px solid #525252;     /* 枠線の装飾 */

		  background-color: #fff;   /* 背景色 */

		  border-radius: 3px;         /* CSS3 */

		  -moz-border-radius: 20px;    /* Firefox */

		  -webkit-border-radius: 20px; /* Safari,Chrome */
		  font-size:20px;
		}
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



	button.button4:hover {

	    /* 背景色を明るい青色に指定 */
	    background-color: rgb(150, 17, 84);

	    /* 文字色を白色に指定 */
	    color: #fff;
	}




	.day {
		float: left
	}

	.day1 {
		clear: both
	}

	.resbtn {
		float: right;
		margin-right: 30%;
		margin-left: -20%
	}
	.msg{
		color: red;
		font-size:1.7em;
		font-weight:bold
	}


	#seat {background-color:white;
	margin-left:auto;
	margin-right:auto}
	</style>
</head>
<body>

			<div class="msg"><s:property value="message" /></div>

	<h1>Reservation</h1>
	<hr class="head">
	<div class="contents">
	<!--予約状況テーブル -->
		<table border="1" id="seat" style="background-color:rgba(255,255,255,0.8); margin-top:30px; margin-bottom:0px;margin-right : auto;
 margin-left : auto;" class="table" >
			<tr>
				<td><font color="black"><s:property value="tomorrowList[0]" /></font></td>
				<td><font color="black"><s:property value="tomorrowList[1]" /></font></td>
				<td><font color="black"><s:property value="tomorrowList[2]" /></font></td>
				<td><font color="black"><s:property value="tomorrowList[3]" /></font></td>
				<td><font color="black"><s:property value="tomorrowList[4]" /></font></td>
				<td><font color="black"><s:property value="tomorrowList[5]" /></font></td>
				<td><font color="black"><s:property value="tomorrowList[6]" /></font></td>
			</tr>
			<tr>
				<td><font color="black"><s:property value="nextWeekList[0]" /></font></td>
				<td><font color="black"><s:property value="nextWeekList[1]" /></font></td>
				<td><font color="black"><s:property value="nextWeekList[2]" /></font></td>
				<td><font color="black"><s:property value="nextWeekList[3]" /></font></td>
				<td><font color="black"><s:property value="nextWeekList[4]" /></font></td>
				<td><font color="black"><s:property value="nextWeekList[5]" /></font></td>
				<td><font color="black"><s:property value="nextWeekList[6]" /></font></td>
			</tr>
			<tr>
				<td><font color="black"><s:property value="vacancyList[0]" /></font></td>
				<td><font color="black"><s:property value="vacancyList[1]" /></font></td>
				<td><font color="black"><s:property value="vacancyList[2]" /></font></td>
				<td><font color="black"><s:property value="vacancyList[3]" /></font></td>
				<td><font color="black"><s:property value="vacancyList[4]" /></font></td>
				<td><font color="black"><s:property value="vacancyList[5]" /></font></td>
				<td><font color="black"><s:property value="vacancyList[6]" /></font></td>
			</tr>
		</table>

		<s:form action="GoToPaymentInformationPageAction">
			<h3>
				<span>
					<font color="red">
						<s:property value="seletedDateErrorMessage" />
					</font>
				</span>
			</h3>
			<table class="table" style="margin-top:50px;margin-bottom:40px; ">
                <caption style="color:#ffffff;">reservation</caption>
				<tr>
					<th class="item">Course Plan</th>
					<td><input type="radio" value="A" required name="courseString"
						checked>Ａcourse <input type="radio" value="B"
						name="courseString">Ｂcourse <input type="radio" value="C"
						name="courseString">Ccourse<s:property value="courseString"/></td>
				</tr>
				<tr>
					<th class="item">number of people</th>

					<td><select name="numberOfPeople" class="easy-select-box">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<s:property value="numberOfPeople"/>
					</select></td>
				</tr>
				<tr>
					<th class="item">Date</th>
					 <td>
					 <div>

					 <input type="text" id="datepicker" readonly="readonly" name="calendar" style="color:black;width:5.5em;font-family:sans-serif; " value="">

					 <s:property value="calendar"/>

					 </div>
						<!--
							<s:iterator value="tomorrowList" status="st">
								<option value="<s:property value="tomorrowList[#st.index]" />">
									<s:property value="tomorrowList[#st.index]" />
								</option>
							</s:iterator>

							<s:property value="reservationDate"/>
							-->
					</td>
				</tr>
				<tr>
					<th class="item">Visiting time</th>
					<td><select name="reservationTime" class="easy-select-box"><s:property value="reservationTime"/>
							<option value="18:00">18:00</option>
							<option value="18:30">18:30</option>
							<option value="19:00">19:00</option>
							<option value="19:30">19:30</option>
							<option value="20:00">20:00</option>
							<option value="20:30">20:30</option>
							<option value="21:00">21:00</option>
							<option value="21:30">21:30</option>
							<option value="22:00">22:00</option>
					</select></td>
				</tr>
			</table>

			<div class="resbtn">
			<button value="Reservation" class="button4">Payment</button>
				<!--<button data-icon="♛" class="button pink serif round glass">Reservation</button>-->
			</div>
		</s:form>
		<div class="topbtn">
			<s:form action="ReturnTopAction">
			<button class="button4">Top</button>
				<!--<button data-icon="♛" class="button pink serif round glass">Top</button>-->
			</s:form>
		</div>
	</div>

	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>
