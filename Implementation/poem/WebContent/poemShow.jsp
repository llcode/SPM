<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>诗词信息</title>
</head>
<body>
<s:include value="top.jsp"></s:include>
<h1>诗词信息：</h1>
<s:property value="poem.title" />
<br>
<s:property value="poem.author.name" />
<br>
<p>内容：</p>
<s:property value="poem.content" />
<br>
<p>译文：</p>
<s:property value="poem.translation" />
<br>
<p>翻译：</p>
<s:property value="poem.explanation" />
<br>
<p>鉴赏：</p>
<s:property value="poem.appreciation" />
<br>

<a href="poemService!edit?poem.pid=<s:property value="poem.pid" />">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="poemService!delete?poem.pid=<s:property value="poem.pid" />">删除</a>
<br>
<a href="poemService!addToNewPoem?poem.pid=<s:property value="poem.pid" />">添加生诗词表</a>
<a href="favoriteService!goAddPoem?poem.pid=<s:property value="poem.pid" />">添加到收藏列表</a>
<a href="poemService!index">返回列表</a>
</body>
</html>