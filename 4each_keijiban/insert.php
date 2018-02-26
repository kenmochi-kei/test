<?php
mb_internal_encoding("utf8");
$pdo = new PDO("mysql:adname=test; host=localhost;", "root", "mysql");

$pdo -> exec("insert into contactform(handlename,title,comments)
values('".$_POST['name']."','".$_POST['title']."','".$_POST['comments']."');");

header("Location:http://localhost/4each_keijiban/index.php");

?>
