<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>西交大苏研院BBS———个人信息注册</title>
<script type="text/javascript">
	function changeImage() {
		var img = document.getElementById("valiCode");
		img.src = "image.jsp?" + Math.random();
	}
</script>
<link href="WebSite/css/bootstrap-classic.css" rel="stylesheet" />
</head>
<body>
	<ul class="breadcrumb">
		<li><a href="">西安交通大学BBS</a> <span class="divider">/</span></li>
		<li><a href="userAction!goList">注册</a></li>
	</ul>

	<center>
		<h2>
			<font color=black>个人信息注册</font>
		</h2>
		<hr>

		<h3>
			<font color=red>以下资料请如实填写</font>
		</h3>
		<br>
	</center>

	<div class="box-content">

		<form class="form-horizontal" action="userCountService!register" method="post">
			<fieldset>

				<div class="control-group">
					<label class="control-label">昵称:</label>
					<div class="controls">
						<s:textfield class="span12 typeahead" size="100" type="text"
							name="user.username"></s:textfield>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">密码:</label>
					<div class="controls">
						<s:password class="input-xlarge focused" name="user.pwd"></s:password>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">真实姓名:</label>
					<div class="controls">
						<s:textfield class="input-xlarge focused" name="userinfo.sname"></s:textfield>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label">学号:</label>
					<div class="controls">
						<s:textfield class="input-xlarge focused" name="userinfo.sno"></s:textfield>
					</div>
				</div>

		<%-- 	<div class="control-group">
					<label class="control-label">验证码:</label>
					<div class="controls">
						<s:textfield class="input-xlarge focused" name="asdf"></s:textfield>
						<img id="valiCode" src="image.jsp"> <a
							href="javascript:changeImage()">看不清，换一张</a>
					</div>
				</div> --%>

				<div class="form-actions">
					<button type="reset" class="btn">返回</button>
					<button type="submit" class="btn btn-primary">提交</button>
				</div>
			</fieldset>
		</form>

	</div>

</body>
</html>