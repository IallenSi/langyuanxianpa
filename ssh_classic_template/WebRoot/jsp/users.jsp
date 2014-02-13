<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
			function change(obj){
			var tag = obj.parentNode;
			while(tag.tagName!="TR"){
				tag = tag.parentNode;
			}
			var index = tag.rowIndex;
			if(document.getElementsByName("state")[index-1]!="0"){
				document.getElementsByName("state")[index-1].value="1";
			}
		}
        //用于执行更新保存的脚本
		function update(){
			var tb = document.getElementById("table");
			var div = document.getElementById("dataDiv");
			for(var i=1;i<tb.rows.length;i++){
				if(document.getElementsByName("state")[i-1].value=="1"){
					div.innerHTML=div.innerHTML+"<input name='id' value='"+document.getElementsByName("id")[i-1].value+"'/>";
					div.innerHTML=div.innerHTML+"<input name='name' value='"+document.getElementsByName("name")[i-1].value+"'/>";
					div.innerHTML=div.innerHTML+"<input name='password' value='"+document.getElementsByName("password")[i-1].value+"'/>";
				}
			}
			document.forms["form2"].submit();
		}
		</script>
</head>

<body style="text-align: center;">
	<form action="<s:url value='/demoAction!del.action' />" name="form1"
		method="post">
		<table border="0" width="30%" id="table">
			<tr bgcolor="#FFDDAA">
				<td align="center" style="width: 20px;">选</td>
				<td align="center">用户名</td>
				<td align="center">密码</td>
				<td align="center">职位</td>
			</tr>
			<s:iterator id="a" value="#request.users">
				<tr>
					<td><input type="checkbox" name="id"
						value="<s:property value='id'/>">
					</td>
					<td><input type="text" name="name"
						value="<s:property value='name' />" onchange="change(this)">
					</td>
					<td><input type="text" name="password"
						value="<s:property value='password' />" onchange="change(this)">
						<input type="hidden" name="state" value="0" />
					</td>
				</tr>
			</s:iterator>
		</table>
		<br>
		<table width="30%">
			<tr>
				<td align="left">
					<a href="javascript:window.history.go(-1);">返回</a>
					<input type="submit" value="删除" /> 
					<input type="button" value="保存" onclick="update();" />
					<s:a action="demoAction!export.action?name=%{#parameters.name}">导出</s:a>
				</td>
			</tr>
		</table>
	</form>
	<form name="form2" action="<s:url value='/demoAction!update.action'/>" method="post">
			<div id="dataDiv" style="display:none;">
			</div>
	</form>
	<s:debug></s:debug>
</body>
</html>
