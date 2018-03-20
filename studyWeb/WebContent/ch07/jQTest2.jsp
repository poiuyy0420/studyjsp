<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery 실렉터와 메소드를 사용한 엘리멘트의 내용변경</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("#b1").click(function(){
			$("#b2").text($("p").text());
		});
		$("#b2").click(function(){
			$("#display").html("<img src='myFace.png' border='0'/>");
		});			
	
	});
		
</script>
</head>
<body>
	<p>이미지 표시</p>
	<button id="b1">버튼레이블 변경</button>
	<div id="display"></div>
	<button id="b2">버튼</button>
</body>
</html>