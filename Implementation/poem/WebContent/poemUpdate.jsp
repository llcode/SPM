<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var goBack = function() {
		//window.history.go(-1);
		window.location.href = "poemService!index";
	}
</script>
</head>
<body style="background-color: Khaki">
<s:include value="top.jsp"></s:include>
<h1>欢迎更新信息 ${userInSession.name }</h1>
<hr>
<s:form action="poemService!update">
	<!-- 将原有的数据回显在页面上 -->
	<s:hidden name="poem.pid"></s:hidden>
						题目<br>
	<s:textfield name="poem.title" readonly="true" theme="simple"></s:textfield>
	<br>
						作者<br>
	<s:textfield name="poem.author.name" readonly="true" theme="simple"></s:textfield>
	<br>
						诗文<br>
	<s:textarea name="poem.content" theme="simple" />
	<br>
						翻译<br>
	<s:textarea name="poem.translation" theme="simple" />
	<br>
						解释<br>
	<s:textarea name="poem.explanation" theme="simple" />
	<br>
						鉴赏<br>
	<s:textarea name="poem.appreciation" theme="simple" />
	<br>
	<s:submit value="更新" theme="simple"></s:submit>
	<s:reset value="重置" theme="simple"></s:reset>
</s:form>
<input type="button" value="返回主页" onclick="goBack()">
</body>
</html>