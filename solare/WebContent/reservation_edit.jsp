<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>

<!--BootStrap読み込み-->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<script src="js/bootstrap.min.js"></script>

<!-- フォントの読み込み -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300'
	rel='stylesheet' type='text/css'>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Change Reservation</title>

<!--外部cssファイルの読み込み  -->
<link rel="stylesheet" type="text/css" href="css/design.css">

<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">


<script type="text/javascript" src="js/easyselectbox.min.js"></script>

<script type="text/javascript">
	(function($) {
		$('.easy-select-box').easySelectBox({
			speed : 200
		});
	})(jQuery);
</script>

<style>
table th, table td {
	border-color: white;
	border-style: solid; /* 線種 */
	border-right-width: 1px;
	border-left-width: 1px;
	border-color: white; /* 線色 */
}

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

#editbtn {
	float: right;
	margin-right: 35%;
	margin-left: -30%
}

.msg {
	color: red;
	font-size: 1.7em;
	font-weight: bold
}
</style>
</head>


<body>
	<div class="msg">
		<s:property value="message" />
	</div>
	<h1>Change Reservation</h1>
	<hr class="head">
	<table class="table" border="1" style="color: white">
		<tr>
			<td><s:property value="tomorrowList[0]" /></td>
			<td><s:property value="tomorrowList[1]" /></td>
			<td><s:property value="tomorrowList[2]" /></td>
			<td><s:property value="tomorrowList[3]" /></td>
			<td><s:property value="tomorrowList[4]" /></td>
			<td><s:property value="tomorrowList[5]" /></td>
			<td><s:property value="tomorrowList[6]" /></td>
		</tr>
		<tr>
			<td><s:property value="nextWeekList[0]" /></td>
			<td><s:property value="nextWeekList[1]" /></td>
			<td><s:property value="nextWeekList[2]" /></td>
			<td><s:property value="nextWeekList[3]" /></td>
			<td><s:property value="nextWeekList[4]" /></td>
			<td><s:property value="nextWeekList[5]" /></td>
			<td><s:property value="nextWeekList[6]" /></td>
		</tr>
		<tr>
			<td><s:property value="vacancyList[0]" /></td>
			<td><s:property value="vacancyList[1]" /></td>
			<td><s:property value="vacancyList[2]" /></td>
			<td><s:property value="vacancyList[3]" /></td>
			<td><s:property value="vacancyList[4]" /></td>
			<td><s:property value="vacancyList[5]" /></td>
			<td><s:property value="vacancyList[6]" /></td>
		</tr>
	</table>

	<div class="contents">
		<p>現在のご予約状況</p>
		<s:iterator value="reservationInfoList">
			<table class="table">
				<caption style="color: #ffffff;">
					reservation
					<s:property value="customerReservationNumber" />
				</caption>
				<tr>
					<th class="item">Reservation No.</th>
					<td><s:property value="customerReservationNumber" /></td>
				</tr>
				<tr>
					<th class="item">day</th>
					<td><s:property value="reservationDateString" /></td>
				</tr>
				<tr>
					<th class="item">plan</th>
					<td><s:property value="courseString" /></td>
				</tr>
				<tr>
					<th class="item">visiting time</th>
					<td><s:property value="reservationTime" /></td>
				</tr>
				<tr>
					<th class="item">number of people</th>
					<td><s:property value="numberOfPeople" /> 人</td>
				</tr>
			</table>
		</s:iterator>

		<s:form action="GoToReservationEditConfirmPageAction">
			<table class="table">
				<caption style="color: #ffffff;">reservation</caption>
				<tr>
					<th class="item">Reservation No.</th>
					<td><select name="customerReservationNumber"
						class="easy-select-box">
							<s:iterator value="reservationInfoList">
								<option value="<s:property value="customerReservationNumber" />"><s:property
										value="customerReservationNumber" /></option>
							</s:iterator>
					</select></td>
				</tr>
				<tr>
					<th class="item">Course Plan</th>
					<td><input type="radio" value="0" required name="courseNumber"
						checked>Ａcourse <input type="radio" value="1"
						name="courseNumber">Ｂcourse <input type="radio" value="2"
						name="courseNumber">Ｃcourse</td>
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
					</select></td>
				</tr>
				<tr>
					<th class="item">Date</th>
					<td><select name="reservationDate" class="easy-select-box">
							<s:iterator value="tomorrowList" status="st">
								<option value="<s:property value="tomorrowList[#st.index]" />">
									<s:property value="tomorrowList[#st.index]" />
								</option>
							</s:iterator>
					</select></td>
				</tr>
				<tr>
					<th class="item">Visiting time</th>
					<td><select name="reservationTime" class="easy-select-box">
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
				<button class="button4">Edit</button>
				<!--<button data-icon="♛" class="button pink serif round glass">Edit</button>-->
			</div>
		</s:form>


		<s:form action="GoToMyPageAction">
			<button class="button4">MyPage</button>
			<!--<button data-icon="♛" class="button pink serif round glass">MyPage</button>-->
		</s:form>

		<br> <br> <br>
		<p>予約のキャンセルはこちら</p>
		<s:form action="GoToCancelAction">
			<button class="button4">Cancel</button>
			<!--<button data-icon="♛" class="button pink serif round glass">Cancel</button>-->
		</s:form>
	</div>

	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>
</body>
</html>