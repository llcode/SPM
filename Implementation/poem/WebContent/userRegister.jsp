<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>注册</title>
<script type="text/javascript">
	function gologin() {
		window.location.href = "userCountService!goLogin";
	}
	function checkSubmit() {
			if (document.getElementsByName("usercount.name")[0].value == "") {
				document.getElementsByName("usercount.name")[0].focus();
				alert("用户名不能为空！");
				return false;
			}
			if (document.getElementsByName("usercount.password")[0].value == ""
					|| document.getElementsByName("password2")[0].value == "") {
				document.getElementsByName("usercount.password")[0].focus();
				alert("密码不能为空！");
				return false;
			}
	
			if (document.getElementsByName("usercount.password")[0].value != document
					.getElementsByName("password2")[0].value) {
				document.getElementsByName("usercount.password")[0].focus();
				alert("两次密码不一致！");
				return false;
			}
	
			if (document.getElementsByName("usercount.email")[0].value == "") {
				document.getElementsByName("usercount.email")[0].focus();
				alert("注册邮箱不能为空!");
				return false;
			}
	}
</script>
</head>
<body>
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep10"></div>
<div class="box">
<div class="cell">
<div class="fr" style="margin: 16px 10px 0px 0px;"><a
	href="userLogin.jsp">登录</a></div>
<h1>请输入注册信息</h1>
</div>
<div class="inner">
<s:form action="userCountService!regist" theme="simple"
	onsubmit="return checkSubmit();">
	<!-- 等效于type为text的input标签-->
	<!-- 如果action中的属性是一个封装类型，属性的赋值是按照对象导航的方式来寻找的 -->
	<table cellpadding="5" cellspacing="0" border="0" width="100%">
		<tr>
			<td width="120" align="right">用户名</td>
			<td width="auto" align="left"><s:textfield label="用户名"
				name="usercount.name" cssClass="sl"></s:textfield><font color="red">${userNameError}</font>
			<font color="red">(至少8个字符，英文字母、数字、下划线开头)</font></td>
		</tr>
		<tr>
			<td width="120" align="right">密码</td>
			<td width="auto" align="left"><s:password name="usercount.password" cssClass="sl"></s:password></td>
		</tr>
		<tr>
			<td width="120" align="right">确认密码</td> 
			<td width="auto" align="left"><s:password name="password2" cssClass="sl"></s:password></td>
		</tr>
		<tr>
			<td width="120" align="right">电子邮件</td>
			<td width="auto" align="left"><s:textfield name="usercount.email" cssClass="sl"/>
			<font color="red">${userEmailError}</font></td>
		</tr>
		<tr>
			<td width="120" align="right"></td>
			<td width="auto" align="left"><s:submit value="提交" cssClass="super normal button"></s:submit></td>
		</tr>
	</table>
</s:form>
</div>
</div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>