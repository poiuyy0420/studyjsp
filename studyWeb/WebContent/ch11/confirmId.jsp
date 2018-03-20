<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ch11.logon.LogonDBBean" %>

<% request.setCharacterEncoding("utf-8");%>

<%
	//id는 사용자가 회원가입을 하기 위해서 입력한 아이디
	String id = request.getParameter("id");
	
	//DB 처리빈인 LogonDBBean 클래스의 객체를 얻어낸다
	LogonDBBean manager = LogonDBBean.getInstance();
	
	//사용자가 입력한 id값을 가지고 LogonDBBean 클래스의 confirmId() 메소드를 호출
	//중복 아이디 체크 confirmId() 메소드의 실행 결과로 check에는 1 또는 -1값이 리턴됨
	int check = manager.confirmId(id);
	
	out.println(check);
%>