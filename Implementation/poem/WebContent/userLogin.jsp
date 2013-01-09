<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<script type="text/javascript">
	function goregist() {
		window.location.href = "regist.jsp";
	}
</script>
</head>
<body>
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep20"></div>
<div class="box">
<h4>请输入登录信息</h4>
<s:form action="userCountService!login" theme="simple">
	<!-- 等效于type为text的input标签-->
	<!-- 如果action中的属性是一个封装类型，属性的赋值是按照对象导航的方式来寻找的 -->
	<table border="0">
		<tr>
			<td>用&nbsp;户&nbsp;名 <s:textfield label="用户名"
				name="usercount.name"></s:textfield></td>
		</tr>
		<tr>
			<td>&nbsp;密&nbsp;码&nbsp; <s:password label=""
				name="usercount.password"></s:password></td>
		</tr>
		<tr>

			<td><s:submit value="登录"></s:submit> <input type="button"
				value="注册" onclick="goregist()"></td>
		</tr>
	</table>
</s:form>
</div>
</div>
</div>
</body>
</html>