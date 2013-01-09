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
<div id="Wrapper">
<div id="Main">
<div class="sep20"></div>
<div class="box">
<h4>请输入登录信息</h4>
<s:form action="userCountService!regist" theme="simple"
	onsubmit="return checkSubmit();">
	<!-- 等效于type为text的input标签-->
	<!-- 如果action中的属性是一个封装类型，属性的赋值是按照对象导航的方式来寻找的 -->
	<table border="0">

		<tr>
			<td>用&nbsp;户&nbsp;名 <s:textfield label="用户名"
				name="usercount.name"></s:textfield> <font color="red">${userNameError}</font>
			<br>
			<font color="red">(至少8个字符，英文字母、数字、下划线，以英文字母开头)</font></td>
		</tr>
		<tr>
			<td>&nbsp;密&nbsp;码&nbsp; <s:password label="密码"
				name="usercount.password"></s:password></td>
		</tr>
		<tr>
			<td>确认密码 <s:password label="" name="password2"></s:password></td>
		</tr>
		<tr>
			<td>E-mail <s:textfield label="E-mail" name="usercount.email" />
			<font color="red">${userEmailError}</font></td>
		</tr>
		<tr>

			<td><s:submit value="提交"></s:submit> <input type="button"
				value="返回" onclick="gologin()"></td>
		</tr>

	</table>

</s:form>
</div>
</div>
</div>
</body>
</html>