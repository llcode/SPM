<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC
"-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link id="bs-css" href="css/bootstrap-cerulean.css" rel="stylesheet">
<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/charisma-app.css" rel="stylesheet">
<link href="css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
<link href='css/fullcalendar.css' rel='stylesheet'>
<link href='css/fullcalendar.print.css' rel='stylesheet' media='print'>
<link href='css/chosen.css' rel='stylesheet'>
<link href='css/uniform.default.css' rel='stylesheet'>
<link href='css/colorbox.css' rel='stylesheet'>
<link href='css/jquery.cleditor.css' rel='stylesheet'>
<link href='css/jquery.noty.css' rel='stylesheet'>
<link href='css/noty_theme_default.css' rel='stylesheet'>
<link href='css/elfinder.min.css' rel='stylesheet'>
<link href='css/elfinder.theme.css' rel='stylesheet'>
<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='css/opa-icons.css' rel='stylesheet'>
<link href='css/uploadify.css' rel='stylesheet'>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

<script type="text/javascript">
	function goBack() {
		window.location.href = "userCountService!goManagerList";
	}
</script>
<!-- The fav icon -->
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
	<!-- topbar starts -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a> <a class="brand" href="index.html"> <img alt="Charisma Logo"
					src="img/logo20.png" /> <span>Charisma</span></a>

				<!-- theme selector starts -->
				<div class="btn-group pull-right theme-container">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-tint"></i><span class="hidden-phone"> Change
							Theme / Skin</span> <span class="caret"></span>
					</a>
					<ul class="dropdown-menu" id="themes">
						<li><a data-value="classic" href="#"><i
								class="icon-blank"></i> Classic</a></li>
						<li><a data-value="cerulean" href="#"><i
								class="icon-blank"></i> Cerulean</a></li>
						<li><a data-value="cyborg" href="#"><i class="icon-blank"></i>
								Cyborg</a></li>
						<li><a data-value="redy" href="#"><i class="icon-blank"></i>
								Redy</a></li>
						<li><a data-value="journal" href="#"><i
								class="icon-blank"></i> Journal</a></li>
						<li><a data-value="simplex" href="#"><i
								class="icon-blank"></i> Simplex</a></li>
						<li><a data-value="slate" href="#"><i class="icon-blank"></i>
								Slate</a></li>
						<li><a data-value="spacelab" href="#"><i
								class="icon-blank"></i> Spacelab</a></li>
						<li><a data-value="united" href="#"><i class="icon-blank"></i>
								United</a></li>
					</ul>
				</div>
				<!-- theme selector ends -->

				<!-- user dropdown starts -->
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone"> admin</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="userCountService!goUserCenter">个人中心</a></li>
						<li class="divider"></li>
						<li><a href="userCountService!logout">Logout</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!-- topbar ends -->
	<div class="row-fluid">

		<!-- left menu starts -->
		<div class="span2 main-menu-span">
			<div class="well nav-collapse sidebar-nav">
				<ul class="nav nav-tabs nav-stacked main-menu">
					<li class="nav-header hidden-tablet">Main</li>
					<li><a class="ajax-link" href="index.jsp"><i
							class="icon-home"></i><span class="hidden-tablet">&nbsp;&nbsp;Home</span></a></li>
					<li><a class="ajax-link" href="bbs/bbsService!goBbsIndex"><i
							class="icon-eye-open"></i><span class="hidden-tablet">&nbsp;&nbsp;BBS</span></a></li>
					<li><a class="ajax-link"
						href="album/albumService!goAlbumIndex"><i class="icon-edit"></i><span
							class="hidden-tablet">&nbsp;&nbsp;Album</span></a></li>
					<li><a class="ajax-link" href="userCountService!goUserCenter"><i
							class="icon-list-alt"></i><span class="hidden-tablet">
								个人中心</span></a></li>
				</ul>
				<label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input
					id="is-ajax" type="checkbox"> Ajax on menu</label>
			</div>
			<!--/.well -->
		</div>
		<!--/span-->
		<!-- left menu ends -->

		<noscript>
			<div class="alert alert-block span10">
				<h4 class="alert-heading">Warning!</h4>
				<p>
					You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
						target="_blank">JavaScript</a> enabled to use this site.
				</p>
			</div>
		</noscript>

		<ul class="breadcrumb">
			<li><a href="/bbsv2/index.jsp">首页</a> <span class="divider">/</span>
				<a href="userCountService!goUserCenter">个人中心</a> <span
				class="divider">/</span>
			<li><a href="userCountService!goManagerList">用户管理</a></li>
			<span class="divider">/</span>
			<li><a href="userCountService!managerUser">用户权限修改</a></li>
		</ul>
		<center>

			<div class="box-content">
				<s:form action="userCountService!userUpdate" method="post">
					<fieldset>
						<table style="width: 60%">
							<tbody>
								<s:hidden name="user.userid"></s:hidden>

								<tr>
									<td><b>用户名</b></td>
									<td><s:textfield name="user.username" theme="simple"></s:textfield></td>
								</tr>
								<tr>
									<td><b>初始化密码</b></td>
									<td><s:password name="user.pwd" theme="simple"></s:password></td>
								</tr>
								<tr>
									<td><b>修改权限</b></td>
									<td><select name="user.power">
											<s:if test="user.power==1">
												<option value="1" selected="selected">管理员</option>
												<option value="2">版主</option>
												<option value="3">普通用户</option>
												<option value="0">禁用用户</option>

											</s:if>
											<s:elseif test="user.power==2">
												<option value="1">管理员</option>
												<option value="2" selected="selected">版主</option>
												<option value="3">普通用户</option>
												<option value="0">禁用用户</option>
											</s:elseif>
											<s:elseif test="user.power==3">
												<option value="1">管理员</option>
												<option value="2">版主</option>
												<option value="3" selected="selected">普通用户</option>
												<option value="0">禁用用户</option>

											</s:elseif>
											<s:else>
												<option value="1">管理员</option>
												<option value="2">版主</option>
												<option value="3">普通用户</option>
												<option value="0" selected="selected">禁用用户</option>
											</s:else>
									</select></td>
								</tr>
								<tr>
									<td><b>班级权限</b></td>
									<td><select name="user.classPower">
											<s:if test="user.classPower==1">
												<option value="1" selected="selected">班干</option>
												<option value="2">班级用户</option>
												<option value="3">普通用户</option>

											</s:if>
											<s:elseif test="user.classPower==2">
												<option value="1">班干</option>
												<option value="2" selected="selected">班级用户</option>
												<option value="3">普通用户</option>
											</s:elseif>
											<s:else>
												<option value="1">班干</option>
												<option value="2">班级用户</option>
												<option value="3" selected="selected">普通用户</option>

											</s:else>

									</select></td>
								</tr>
								<tr style="align: center">
									<td colspan="2"><input type="submit" value="保存修改">&nbsp;&nbsp;&nbsp;
										<input type="reset" value="重置"> &nbsp;&nbsp;&nbsp;<input
										type="button" value="返回" onclick="goBack()"></td>
								</tr>

							</tbody>
						</table>
					</fieldset>
				</s:form>
			</div>

		</center>
	</div>
	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.min.js"></script>
	<script src="js/jquery.flot.pie.min.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="js/charisma.js"></script>
</body>
</html>