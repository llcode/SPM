<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add poem to favorite</title>
</head>
<body>
<center>
	<h4>添加诗歌到收藏</h4>
	<s:form action="favoriteService!addPoem">
		<s:textfield label="收藏编号" name="favorite.fid"></s:textfield>
		<s:textfield label="诗词编号" name="poem.pid"></s:textfield>
		<s:submit></s:submit>
	</s:form>
</center>
</body>
</html>