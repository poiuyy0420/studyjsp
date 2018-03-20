<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name ="viewport" content="width=device-width,initial-scale=1.0"/>

<h2>reqeust 예제 - 요청메소드</h2>
	<form method="post" action="requestTest1.jsp">
		<dl>
			<dd>
				<label for="name">이름</label>
				<input type="text" id="name" name="name" placeholder="김개동" autofocus required>
			</dd>
			<dd>
				<label for="age">나이</label>
				<input type="number" id="age" name="age" min="20" max="99" value="20" required>
			</dd>
			<dd><fieldset>
				<legend>성별</legend>
				<input type="radio" id="gender" name="gender" value="m" checked>
				<label for="gender">남</label>
				<input type="radio" id="gender" name="gender" value="f">
				<label for="gender">여</label>
			</fieldset></dd>
			<dd>
				<label for="hobby">취미</label>
				<select id="hobby" name="hobby" required>
				<option value="잠자기" selected>잠자기
				<option value="무협지보기">무협지보기
				<option value="애니메이션시청">애니메이션시청
				<option value="건프라">건프라
				</select>
			</dd>
			<dd>
				<input type="submit" value="전송">
			</dd>
		</dl>
	</form>