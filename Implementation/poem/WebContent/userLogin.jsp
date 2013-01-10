<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep10"></div>
<div class="box">
<div class="cell">
<div class="fr" style="margin: 16px 10px 0px 0px;"><a
	href="userRegister.jsp">注册</a></div>
<h1>请输入登录信息</h1>
</div>
<div class="inner"><s:form action="userCountService!login"
	theme="simple">
	<!-- 等效于type为text的input标签-->
	<!-- 如果action中的属性是一个封装类型，属性的赋值是按照对象导航的方式来寻找的 -->
	<table cellpadding="5" cellspacing="0" border="0" width="100%">
		<tr>
			<td width="120" align="right">用户名</td>
			<td width="auto" align="left"><s:textfield name="usercount.name"
				cssClass="sl"></s:textfield></td>
		</tr>
		<tr>
			<td width="120" align="right">密码</td>
			<td width="auto" align="left"><s:password
				name="usercount.password" cssClass="sl"></s:password></td>
		</tr>
		<tr>
			<td width="120" align="right"></td>
			<td width="auto" align="left"><s:submit value="登录"
				cssClass="super normal button"></s:submit></td>
		</tr>
	</table>
</s:form></div>
</div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>