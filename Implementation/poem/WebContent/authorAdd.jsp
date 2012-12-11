<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>诗人信息</title>
<script type="text/javascript">
	function checkSubmit() {
		if (document.getElementsByName("author.name")[0].value == "") {
			document.getElementsByName("author.name")[0].focus();
			alert("作者名字不能为空！");
			return false;
		}
	}
</script>
</head>
<body>
<s:include value="top.jsp"></s:include>
<h1>添加诗人信息</h1>
<s:form action="authorService!add" onsubmit="return checkSubmit();"
	theme="simple">
	诗人:<s:textfield name="author.name"></s:textfield>
	<font color="red">${author}</font>
	<br>
	简介:<s:textarea name="author.description"></s:textarea>
	<br>
	<s:submit value="添加"></s:submit>
</s:form>
</body>
</html>
