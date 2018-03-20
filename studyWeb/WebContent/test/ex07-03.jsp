<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처리페이지</title>
<style type="text/css">
	#result{
		width : 200px;
		height : 200px;
		border : 5px double #6699FF;
	}
</style>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("#pro").click(function(){
			if($("#name").val() == "김개동"){
				$("#result").text("관리자님 어서오세요");
			}else{
				$("#result").text("회원님 어서오세요");
			}
		});
	});
</script>
</head>
<body>
	이름<input type="text" id="name"><br>
	<button id="pro">처리</button>
	<div id="result"></div>
</body>
</html>