<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/poem/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div id="Top">
<div id="TopMain">
<div class="content">
<div style="padding-top: 6px;">
<table>
	<tr>
		<td width="200" align="left"><b><a href="poemService!index">唐诗宋词学习网</a></b></td>
		<td width="300" align="right"><a href="poemService!index">唐诗宋词</a>
		&nbsp;&nbsp;&nbsp;<a href="authorService!index">诗人风采</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td width="460" align="right"><s:if
			test="%{#session.userInSession.userid != null}">
			<a href="favoriteService!index">我的收藏卡</a>&nbsp;&nbsp;&nbsp;
			<a href="myNewPoemService!index">生诗词库</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="search.jsp">搜索</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a
				href="userCountService!queryById?usercount.userid=${userInSession.userid}">${userInSession.name}</a>
&nbsp;&nbsp;&nbsp;
	<a href="userCountService!loginout">Log out</a>
		</s:if> <s:else>
请<a href="userLogin.jsp">登录</a>或者<a href="userRegister.jsp">注册</a>以使用更多功能。
</s:else></td>
	</tr>
</table>
</div>
</div>
</div>
</div>
</body>
</html>