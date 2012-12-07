<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加收藏列表</title>
</head>
<body>
<h4>请输入收藏列表信息：</h4>
<s:form action="favoriteService!add">
	<s:textfield label="收藏列表名称" name="favorite.name" />
	<s:submit value="提交" />
</s:form>
<a href="favoriteService!index">所有列表</a>
</body>
</html>