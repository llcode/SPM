<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏列表内容</title>
</head>
<body>
<h4><s:property value="favorite.name" /> 里的内容：</h4>
<s:iterator value="poemList">
	<s:property value="title" />
	<br>
	<s:property value="author.name" />
	<br>
	<s:property value="content" />
	<br>
	<a
		href="favoriteService!removePoem?favorite.fid=<s:property value="favorite.fid"/>&poem.pid=<s:property value="pid"/>">删除</a>
	<hr>
</s:iterator>
<a href="favoriteService!index">所有列表</a>
</body>
</html>