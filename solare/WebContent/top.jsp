<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang=“ja”>

<head>

<!-- フォントの読み込み -->
<link href='https://fonts.googleapis.com/css?family=Kanit:200'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400italic'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Josefin+Sans'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Josefin+Slab'
	rel='stylesheet' type='text/css'>

<!-- colorbox(jQueryプラグイン)のcss -->
<link rel="stylesheet" href="colorbox-master/colorbox.css" />

<meta charset="UTF-8">
<link rel="shortcut icon" type="favicon.ico" href="../img/favicon.ico">

<!-- jQueryの読み込み -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

<!-- flexslider(jQueryプラグイン)の読み込み -->
<script src="js/jquery.flexslider.js"></script>
<script type="text/javascript" src="js/css_browser_selector.js"></script>

<!-- colorbox(jQueryプラグイン)のjs -->
<script src="colorbox-master/jquery.colorbox-min.js"></script>

<script type="text/javascript">
	(function($) {
		$(document).ready(function() {
			var thumbs = $(".thumb img");
			var top_images = $(".top img");
			thumbs.hover(function() {
				top_images.hide().eq(thumbs.index($(this))).show();
			});
		});
	})(jQuery);
	(function($) {
		$(document).ready(function() {
			var thumbs2 = $(".thumb2 img");
			var top_images2 = $(".top2 img");
			thumbs2.hover(function() {
				top_images2.hide().eq(thumbs2.index($(this))).show();
			});
		});
	})(jQuery);
	$(window).load(function() {
		$('.flexslider').flexslider({
			slideshowSpeed : 5000,
			/*mousewheel: true,*/
			slideshow : true

		});
	});
	jQuery(function() {
		jQuery('a[href^=#]').click(function() {
			var speed = 800;
			var href = jQuery(this).attr("href");
			var target = jQuery(href == "#" || href == "" ? 'html' : href);
			var position = target.offset().top;
			jQuery('body,html').animate({
				scrollTop : position
			}, speed, 'swing');
			return false;
		});
	});

	$(function() {

		/*colorboxのjquery*/
		$(".colorbox").colorbox({
			rel : 'colorbox', //colorboxがグループ化されるため、画面に［次へ・戻る］ボタン表示される
			transition : "elastic", //["elastic","fade","none"]、デフォルト＝elastic
			speed : 400, //写真表示スピード（切替）
			opacity : 0.85, //背景の透明度[0...1]、デフォルト=0.85
			width : "800px"

		});
	});
</script>


<style>
.centerImg {
	width: 815px;
	margin: 0 auto;
	outline: double 15px #000000;
}

table {
	border-right-width: 1px;
	border-left-width: 1px;
}

#content {
	margin-left: 75px;
	margin-right: 75px
}

#reservbtn {
	margin-left: auto;
	margin-right: auto
}

#resbtn {
	text-align: center;
	color: white;
}

.cube {
	margin: 0;
	border: 0;
	font-size: 18px;
	font-family font-family: margin-top: -25px;
	width: 120px;
	height: 50px;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-user-select: none;
	perspective: 500px;
	float: left;
}

.cube span {
	position: absolute;
	text-align: center;
	width: 120px;
	height: 50px;
	padding: 10px;
	border: #000000 solid 1px;
	/*キューブの枠線*/
	pointer-events: none;
	box-sizing: border-box;
}

.cube span:nth-child(1) {
	color: #000000;
	background-color: #000000;
	/*回転後の背景色*/
	transform: rotateX(90deg);
	transition: all 0.2s ease;
	transform-origin: 50% 50% -25px;
}

.cube span:nth-child(2) {
	color: #000000;
	/*回転前の文字色*/
	background-color: rgb(255, 255, 255);
	/*回転前の背景色*/
	transform: rotateX(0deg);
	transition: all 0.2s ease;
	transform-origin: 50% 50% -25px;
}

.cube:hover span:nth-child(1) {
	color: #ffffff;
	/*回転後の文字色*/
	transition: all 0.2s ease;
	transform: rotateX(0deg);
}

.cube:hover span:nth-child(2) {
	background-color: #000000;
	/*回転後の下の色*/
	transition: all 0.2s ease;
	transform: rotateX(-90deg);
}

.safaribtn {
	display: none
}

.safari .safaribtn {
	display: inline
}

.safari a {
	text-decoration: none
}

.safari a, a:hover, a:visited, a:link, a:active {
	color: black
}

.safari a.safaribtn {
	font-size: 1em;
	display: block;
	width: 100px;
	padding-top: 10px;
	padding-bottom: 10px;
	text-align: center;
	border: 2px solid;
	border-color: #aaaaaa #444444 #444444 #aaaaaa;
	background: #ffffff;
}

.safari a.safaribtn:hover {
	background: #777777;
}

#safarimenu_countainer {
	text-align: center;
	width: 800px;
	margin-left: auto;
	margin-right: auto;
	margin-bottom: 50px
}
/*

.safari .safaribtn {
    margin: 0;
	border: 0;
	font-size: 19px;
	font-family: margin-top : -25px;
	width: 120px;
	height: 50px;

}


.safari .safaribtn span{
    border-top: 1px solid #ccc;
    border-right: 1px solid #999;
    border-bottom: 1px solid #999;
    border-left: 1px solid #ccc;
    padding: 5px 20px;
    font-weight: bold;
    cursor: pointer;
    color: #666;
    background-color:white

	}

*/
.safari #info {
	claer: both
}

.safari .cube span {
	display: none;
}

.safari3 .cube span:nth-child(1) {
	display: none
}

.safari3 .cube span:nth-child(2) {
	cdisplay: none
}

.safari3 .cube:hover span:nth-child(1) {
	display: none
}

.safari3 .cube:hover span:nth-child(2) {
	display: none
}

* / #infobtn {
	margin-left: 300px
}

#shopinfobb {
	font-family: 'Kanit', sans-serif;
	color: white;
	font-family: 'Kanit', sans-serif;
	width: 700px;
	margin: 0 auto;
}

.copy {
	color: white;
}
</style>
<link href="css/css.css" rel="stylesheet" type="text/css">
<title>Solare</title>
</head>

<body>
	<!--
Using Modernizr.js for smartphone.
http://modernizr.com
-->


	<h1 id="top">Solare</h1>
	<p id="sub">~Italian&amp;French Restaurant~</p>
	<br>
	<hr color="black">
	<div id="cubeMain">

		<div class="cubeconteiner">
			<a class="cube menu" href="#info"> <span>Info</span> <span>Info</span>
			</a> <a class="cube menu" href="#menu"> <span>Menu</span> <span>Menu</span>
			</a> <a class="cube menu" href="#course"> <span>Course</span> <span>Course</span>
			</a> <a class="cube menu" href="GoToReservationPageAction"> <span>Reservation</span>
				<span>Reservation</span>
			</a> <a class="cube menu" href="#aboutus"> <span>AboutUs</span> <span>AboutUs</span>
			</a> <a class="cube menu" href="#shopinfo"> <span>ShopInfo</span> <span>ShopInfo</span>
			</a> <a class="cube menu" href="GoToMyPageAction"> <span>MyPage</span>
				<span>MyPage</span>
			</a>
		</div>

	</div>
	<div id="safarimenu_countainer">
		<a class="safaribtn menu" href="#info"> Info </a> <a
			class="safaribtn menu" href="#menu"> Menu </a> <a
			class="safaribtn menu" href="#course">Course </a> <a
			class="safaribtn menu" href="GoToReservationPageAction">
			Reservation </a> <a class="safaribtn menu" href="#aboutus">AboutUs </a> <a
			class="safaribtn menu" href="#shopinfo">ShopInfo </a> <a
			class="safaribtn menu" href="GoToMyPageAction">MyPage </a>
	</div>


	<br>
	<br>
	<br>
	<br>

	<!-- Information -->
	<h2 id="info" class="bline" style="width: 6.5em;">Information</h2>
	<hr color="black">
	<div class="flexslider">
		<ul class="slides">
			<li><img src="img/info1.jpg" alt="" width="840" height="430" />
				<p class="flex-caption">温かみ溢れる落ち着いた店内</p></li>

			<li><img src="img/info3.jpg" alt="" width="840" height="430" />
				<p class="flex-caption">仔牛のフィレステーキ オーロラ風</p></li>
			<li><img src="img/info4.jpg" alt="" width="840" height="430" />
				<p class="flex-caption">苺のドルチェ</p></li>
			<li><img src="img/info5.jpg" alt="" width="840" height="430" />
				<p class="flex-caption">多種のワインを取り揃えております</p></li>
		</ul>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<!-- Menu -->
	<h2 id="menu" class="bline" style="width: 4.2em">Menu</h2>
	<hr size="2" color="#000000">
	<p id="menuex">
		国産の食材のみを使用したしたイタリアン・フレンチ料理の数々 <br> その一部をご紹介致します。 <br>
		季節や仕入れ状況によってメニューが異なりますので、 <br> 詳しくはご来店いただいて店内メニューでご確認ください。 <br>
		<br> <br>
		<!--colorbox--------------------------->
	<div class="centerImg">
		<a class="colorbox" href="img/01.jpg" title="クリームコロッケバジル添え"> <img
			src="img/01.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/02.jpg" title="サーモンのムニエル"> <img
			src="img/02.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/03.jpg" title="トマトソースのサーモン蒸し"> <img
			src="img/03.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/04.jpg" title="バジルと鯛のクリームソテー"> <img
			src="img/04.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/05.jpg" title="特製ソースの鰹のたたきサラダ"> <img
			src="img/05.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/06.jpg" title="さっぱりオリーブサラダ"> <img
			src="img/06.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/07.jpg" title="白身魚のホワイトソース和え"> <img
			src="img/07.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/08.jpg" title="さいころステーキデミグラスソース"> <img
			src="img/08.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/09.jpg" title="きのことトマトとハンバーグ"> <img
			src="img/09.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/10.jpg" title="かにクリームコロッケ"> <img
			src="img/10.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/11.jpg" title="冷製トマトマカロニサラダ"> <img
			src="img/11.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/12.jpg" title="トマトミートソースパスタ"> <img
			src="img/12.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/13.jpg" title="半熟卵ときのこのクリームパスタ"> <img
			src="img/13.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/14.jpg" title="海鮮和風パスタ"> <img
			src="img/14.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/15.jpg" title="ズッキーニとバジルオイルのプチハンバーグ">
			<img src="img/15.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/16.jpg" title="店長おすすめ！本日の創作料理"> <img
			src="img/16.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/17.jpg" title="オイスターソースのイタリアン春巻き">
			<img src="img/17.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/18.jpg" title="黒豚ハムのブランブレッド"> <img
			src="img/18.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/19.jpg" title="アイスキャラメルワッフル"> <img
			src="img/19.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/20.jpg" title="ラズベリーハートケーキ"> <img
			src="img/20.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/21.jpg" title="アイスキャラメルパンケーキ"> <img
			src="img/21.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/22.jpg" title="イチゴとクリームのカントゥチーニ"> <img
			src="img/22.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/23.jpg" title="特製アイスプチトゥロン"> <img
			src="img/23.jpg" width="200" height="133">
		</a> <a class="colorbox" href="img/24.jpg" title="イチゴラズベリータワー"> <img
			src="img/24.jpg" width="200" height="133">
		</a>
	</div>

	<!--colorbox/--------------------------->



	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


<!-- Course -->
	<h2 id="course" class="bline" style="width: 4.5em">Course</h2>
	<hr size="2" color="#000000">

	<p id="coursetxt">
		季節の食材の味を最大限に引き出した当店自慢のコース料理 <br>
		本場フランスで腕を磨いたシェフが腕を振るった珠玉の料理をご堪能ください。 <br> <strong>※コースメニューは事前に予約が必要になります。<br>
			&nbsp;&nbsp;&nbsp;お電話、またはホームページのReservationよりご予約をお願い致します。
		</strong>
	</p>
	<br>
	<br>
	<br>


	<div id="coursemenu">
		<table id="courselist">
			<caption>~Course Menu~</caption>
			<tr>
				<th class="a">Course A</th>
				<th class="b">Course B</th>
				<th class="c">Course C</th>
			</tr>

			<tr>
				<th class="a">2hour</th>
				<th class="b">3hour</th>
				<th class="c">3hour</th>
			</tr>

			<tr>
				<th class="a">5,000yen</th>
				<th class="b">7,500yen</th>
				<th class="c">10,000yen</th>
			</tr>

			<tr>
				<th class="a">1,シザーサラダ</th>
				<th class="b">1,白身魚のカルパッチョ</th>
				<th class="c">1,新鮮野菜のサラダ "オーロラ風”</th>
			</tr>

			<tr>
				<th class="a">2,グラタンスープ</th>
				<th class="b">2,野菜ミネストローネ</th>
				<th class="c">2,ヴィシソワーズ</th>
			</tr>

			<tr>
				<th class="a">3,ホエー豚の香草焼き</th>
				<th class="b">3,車えびのトマトクリーム煮</th>
				<th class="c">3,牛フィレとトリュフのファンタジー</th>
			</tr>

			<tr>
				<th class="a">4,ペペロンチーノ</th>
				<th class="b">4,カルボナーラ</th>
				<th class="c">4,えびとブロッコリーのパスタ</th>
			</tr>

			<tr>
				<th class="a">5,ガトーショコラ</th>
				<th class="b">5,紅茶のシフォンケーキ</th>
				<th class="c">5,三種のチーズリゾット</th>
			</tr>

			<tr>
				<th class="a"></th>
				<th class="b"></th>
				<th class="c">6,濃厚ティラミス</th>
			</tr>
		</table>

		<br> <br> <br>

		<div id="resbtn">
			<p>ご予約、ご予約状況のご確認はこちらから</p>
			<s:form action="GoToReservationPageAction">
				<button class="button4" type="submit">Reservation</button>
			</s:form>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


<!-- About Us -->
	<div>
		<h2 id="aboutus" class="bline" style="width: 6em">About Us</h2>
	</div>
	<hr size="2" color="#000000">

	<div id="aboutText">
		<p>
			<strong>大切な人と大切なひと時を・・・</strong>
		</p>
		<p>
			当ホームページをご覧戴き誠に有難うございます。 <br> オーナーシェフの半田と申します。 <br>
			当店は御茶ノ水の片隅で2015年初春に、都会にひっそりとたたずむオアシスの場としてオープン致しました。 <br>
			四季折々の料理をオーナーシェフが表現することをテーマとしております。 <br>
			野菜果実をよりおいしく食べていただけるよう、あらゆる調理技法を駆使し、 <br>
			他に比類ない一品を皆様方にご提供したいと存じます。
		</p>
		<img src="img/info1.jpg" alt="" width="440" height="250" />
	</div>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<!-- ShopInfo -->
	<h2 id="shopinfo" class="bline" style="width: 5.5em">ShopInfo</h2>
	<hr size="2" color="#000000">
	<div id="shopinfobb" align="center">
		<h3>Tel. 01-2345-6789</h3>
		<h3>Lunch 12:30～15:00 / Dinner 18:00～24:00</h3>
		<h3>〒113-0034 東京都文京区湯島3丁目2-12 御茶ノ水天神ビル2F</h3>
	</div>
	<div style="width: 500px; margin: auto;">
	<!-- GoogleMap -->
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3239.910248408922!2d139.76482297877934!3d35.70382618382467!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x60188c18b82a5b79%3A0xf4b11fd9c5add54c!2z44CSMTEzLTAwMzQg5p2x5Lqs6YO95paH5Lqs5Yy65rmv5bO277yT5LiB55uu77yS4oiS77yR77ySIOW-oeiMtuODjuawtOWkqeelnuODk-ODqw!5e0!3m2!1sja!2sjp!4v1460439784843"
			width="500" height="300" style="border: 0"></iframe>
	</div>

	<div id="topbtn">

		<a href="#top">
			<button class="button4">Top</button>
		</a>

	</div>

	<br>
	<br>
	<hr class="foot">
	<p class="copy">
		<small>Copyright © 2017 Solare. All Rights Reserved.</small>
	</p>

</body>

</html>