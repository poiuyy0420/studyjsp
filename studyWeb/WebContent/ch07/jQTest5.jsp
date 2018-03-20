<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery Ajax메소드 - load()</title>
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
		$("#b1").click(function(){
			$("#result").load("xhrTest3.txt", function(response,stu,xhr){
				if(stu=="success")
					alert("로드 성공!");
				if(stu=="error")
					alert("에러: " + xhr.status + ": " + xhr.stu);
			});
		});
	});
</script>
</head>
<body>
	<button id="b1">결과</button>
	<div id="result"></div>
</body>
</html>