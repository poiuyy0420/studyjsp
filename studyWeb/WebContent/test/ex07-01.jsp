<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디와 비밀번호 입력</title>
<style type="text/css">
	#result{
		width : 200px;
		height : 200px;
		border : 5px double #6699FF;
	}
</style>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>

	$(document).ready(function() {
		$("#b1").click(function() {
			var result = "아이디 :" + $("#id").val();
			result += "비밀번호 : " + $("#pass").val();
			$("#result").text(result);
		});
	});
</script>
</head>
<body>
	아이디와 비밀번호 입력<br>
	아이디 <input type="text" name="id" id="id"><br>
	비밀번호 <input type="password" name="pass" id="pass"><br>
	<button id="b1">확인</button><br>
	결과<br>
  	<div id="result"></div>
	
</body>
</html>