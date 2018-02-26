<!DOCTYPE html>
<html lang="ja">
    
<head>
<meta charset="utf-8">
<title>4eachblog 掲示板</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
    
     <h1>入力フォーム</h1>
    <form method="post" action="insert.php">
        <div>
            <label>名前</label>
            <br>
            <input type="text" class="text" size="35" name="name">
        </div>
        
        <div>
            <label>タイトル</label>
            <br>
            <input type="text" class="text" size="35" name="title">
        </div>
        
        <div>
            <label>コメント</label>
            <br>
            <textarea cols="35" rows="7" name="comments"></textarea>
        </div>
        
        <div>
            <input type="submit" class="submit" value="投稿する">
        </div>
    </form>
    
    
    
    
    
<?php
    mb_internal_encoding("utf8");
    $pdo = new PDO("mysql:dbname=test;host=localhost;","root","mysql");
    $stmt = $pdo->query("select * from 4each_keijiban");
    
    while ($row = $stmt->fetch()) {
        echo $row['handlename'];
        echo $row['title'];
        echo $row['comments'];
    }
?>
    
    
</body>    
    
    

</html>