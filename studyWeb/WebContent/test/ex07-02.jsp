<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>load버튼</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("#load").click(function(){
			$("#a").load("ex07-01.jsp");
		});
	});
</script>
</head>
<body>
<button id=load>로드</button>
<div id=a></div>
</body>
</html>