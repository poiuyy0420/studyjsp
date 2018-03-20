<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery Ajax메소드 - $.get()</title>
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
			$.get("xhrTest3.txt",function(data, status){
				var resultStr = "데이터: " + data + + "\n처리상태 : " + status;
				$("#result").text(resultStr);
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