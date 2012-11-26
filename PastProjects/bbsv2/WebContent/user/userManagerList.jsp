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
		</ul>

		<form action="userCountService!search">
			<div>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<b>用户名:</b><input type="text" name="keyName">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>权限:</b><select name="power">
					<option value="-1">请选择</option>
					<option value="1">管理员</option>
					<option value="2">版主</option>
					<option value="3">普通用户</option>
					<option value="0">禁用用户</option>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b> 班级权限:</b><select name="classPower">
					<option value="-1">请选择</option>
					<option value="1">班干</option>
					<option value="2">班级用户</option>
					<option value="3">普通用户</option>
				</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="submit" value="查询">
			</div>

		</form>
		<center>
			<br>
			<table class="table" style="width: 80%">
				<thead>
					<tr class="warning">
						<th class="center">用户名</th>
						<th class="center">权限</th>
						<th class="center">班级权限</th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="userList">
						<tr>
							<td><a
								href="userCountService!managerUser?user.userid=<s:property value="userid" />">
									<s:property value="username" />
							</a></td>
							<td><s:if test="power==1">
					管理员
					</s:if> <s:if test="power==2">
					版主
					</s:if> <s:if test="power==3">
					普通用户
					</s:if> <s:if test="power==0">
					禁用用户
					</s:if></td>
							<td><s:if test="classPower==1">
					班干
					</s:if> <s:if test="classPower==2">
					班级用户
					</s:if> <s:if test="classPower==0">
					普通用户
					</s:if></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</center>
		<%-- <div class="pagination pagination-centered">
		<ul>
			<li><a href="stuAction!goList?curPage=1">首页</a></li>
			<li><a href="stuAction!goList?curPage=${curPage-1}">上一页</a></li>
			<li><a class="active" href="stuAction!goList?curPage=${curPage}">${curPage}</a></li>
			<li><a href="stuAction!goList?curPage=${curPage+1}">${curPage+1}</a></li>
			<li><a href="stuAction!goList?curPage=${curPage+2}">尾页</a></li>
		</ul>
	</div> --%>
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