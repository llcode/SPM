<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加诗词</title>
</head>
<body>
	<center>
		<h4>请输入诗词信息：</h4>
		<s:form action="poemService!add">
			<s:textfield label="题目" name="poem.title"></s:textfield>
			<s:textfield label="作者" name="poem.author.name"></s:textfield>
			<s:textarea label="内容" name="poem.content" cols="40" rows="5"></s:textarea>
			<s:textarea label="译文" name="poem.translation" cols="40" rows="5"></s:textarea>
			<s:textarea label="解释" name="poem.explanation" cols="40" rows="5"></s:textarea>
			<s:textarea label="赏析" name="poem.appreciation" cols="40" rows="5"></s:textarea>
			<s:submit></s:submit>
		</s:form>
	</center>
</body>
</html>