<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试开始啦</title>
</head>
<body>
<s:include value="top.jsp"></s:include>
<div id="Wrapper">
<div id="Main">
<div class="sep10"></div>
<div class="box">
<div class="cell">
<h1>测试开始啦</h1>
</div>
<s:form action="myNewPoemService!goResult" theme="simple">
	<s:hidden name="mode"></s:hidden>
	<s:iterator value="myNewPoems" status="npoemid">
		<div class="cell">
		<div class="content">
		<p><s:property value="#npoemid.index+1" /> <s:property
			value="poem.title" /> <br>
		<s:property value="poem.author.name" /> <br>
		<s:subset source="allItems">
			<s:iterator status="itemid">
				<s:if test="poemid == poem.pid">
					<s:if test="exist == false">
						<!--  the %{} must stay together, I mean no whitespace between them!  -->
						<s:hidden name="testItems[%{#itemid.index}].poemid"
							value="%{poemid}"></s:hidden>
						<s:hidden name="testItems[%{#itemid.index}].sentenceid"
							value="%{sentenceid}"></s:hidden>
						<s:textfield
							cssStyle="display:inline; border-bottom: 1px solid; border-top: 0px; border-left: 0px; border-right: 0px;"
							name="testItems[%{#itemid.index}].sentence" theme="simple"></s:textfield>
						<s:property value="punc" />
					</s:if>
					<s:else>
						<s:property value="sentence" />
						<s:property value="punc" />
					</s:else>
				</s:if>
			</s:iterator>
		</s:subset></p>
		</div>
		</div>
	</s:iterator>
	<div class="cell"><s:submit cssClass="super normal button"
		value="好，做完了" /></div>
</s:form></div>
</div>
</div>
<s:include value="bottom.jsp"></s:include>
</body>
</html>