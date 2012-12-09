<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的主页</title>
</head>
<body>
成功登陆
<br>
<s:include value="top.jsp"></s:include>

<s:iterator value="favoriteList">
	<a href="favoriteService!show?favorite.fid=<s:property value="fid" />">
	<s:property value="name" /></a>
	<a href="favoriteService!edit?favorite.fid=<s:property value="fid" />">
	编辑</a>
	<a
		href="favoriteService!delete?favorite.fid=<s:property value="fid" />">
	删除</a><br>
</s:iterator>
<a href="favoriteAdd.jsp">添加更多列表</a>
</body>
</html>