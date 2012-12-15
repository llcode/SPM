<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="poemService!index">唐诗宋词</a>
<a href="authorService!index">诗人风采</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<s:if test="%{#session.userInSession.userid != null}">
	<a href="favoriteService!index">我的收藏卡</a>
	<a href="myNewPoemService!index">生诗词库</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="search.jsp">搜索</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a
		href="userCountService!queryById?usercount.userid=${userInSession.userid}">${userInSession.name}</a>

	<a href="userCountService!loginout">Log out</a>
</s:if>
<s:else>
请<a href="userLogin.jsp">登录</a>或者<a href="userRegister.jsp">注册</a>以使用更多功能。
</s:else>
<br>
<hr>
</body>
</html>