<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#result{
		width : 200px;
		height : 200px;		border : 5px double #6699FF;
	}
</style>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("#pro").click(function(){
			$.get("test01.jsp",
					function(data){
					var resultStr = data;
				$("#result").text(resultStr);
			})
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