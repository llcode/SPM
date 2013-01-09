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
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep20"></div>
<div class="box">
<h1>编辑收藏列表</h1>
<s:form action="favoriteService!update">
	<s:hidden name="favorite.fid"></s:hidden>
	<s:textfield name="favorite.name"></s:textfield>
	<s:submit></s:submit>
</s:form>
</div>
</div>
</div>
</body>
</html>