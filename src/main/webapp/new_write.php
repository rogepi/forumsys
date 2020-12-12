<?php
session_start();
// echo "title: " . $_POST["title"] . "<br>";
// echo "author:" . $_SESSION["username"] . "<br>";
// echo "type: " . $_POST["ntype"] . "<br>";
// echo "level: " . $_POST["level"] . "<br>";
// echo "content: " . $_POST["content"] . "<br>";
// echo "date: " . date("Y/m/d") . "<br>";

$title=$_POST["title"];
$author=$_SESSION["username"];
$type=$_POST["ntype"];
$level=$_POST["level"];
$content=$_POST["content"];


include('dbcn.php');

$sql = "INSERT INTO wenzhangxinxi (title,author,type,level,address,content,date) VALUES ('$title','$author','$type','$level','','$content',NOW())";
echo $sql;
if($conn->query($sql)==TRUE) {
  echo "<script>alert('文章录入成功');window.history.back(-1);</script>";die;
} else {
  echo "<script>alert('文章录入失败');window.history.back(-1);</script>";die;
}
?>