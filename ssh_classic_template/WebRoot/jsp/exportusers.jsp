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
<script type="text/javascript">
	function toExport(obj) {
		//obj.form1.opt.value = "export";
		var v = document.getElementById("form1");
		v.action = "exportAction!export.action";
		obj.form.submit();
	}
	function toQuery(obj) {
		//obj.form1.opt.value = "query";
		var v = document.getElementById("form1");
		v.action = "exportAction!query.action";
		obj.form.submit();
	}
</script>
</head>

<body style="text-align: center;">
	<br>
	<form name="form1" method="post" id="form1">
		<table width="30%" align="left">
			<tr>
				<td align="left"><a href="javascript:window.history.go(-1);">返回</a>
					<input type="button" value="导出" onclick="toExport(this);" /> <input
					type="button" value="查询" onclick="toQuery(this)" /></td>
			</tr>
		</table>
		<input type="hidden" id="opt" name="opt" />
		请输入要查询的用户名包含的内容<input type="text" name="name">
	</form>
		<table border="0" width="30%" id="table">
			<tr bgcolor="#FFDDAA">
				<td align="center">用户名</td>
				<td align="center">密码</td>
			</tr>
			<s:iterator id="a" value="#request.users">
				<tr>
					<td><input type="text" name="name"
						value="<s:property value='name'/>" readonly="readonly">
					</td>
					<td><input type="text" name="password"
						value="<s:property value='password'/>" readonly="readonly">
					</td>
				</tr>
			</s:iterator>
		</table>
	<br>
	<s:form action="exportAction!importExcel.action" method="post" enctype="multipart/form-data">
		导入的excel文件:<s:file name="excelFile"></s:file><br>
		<s:submit value="导入"></s:submit>
	</s:form>
	<s:debug></s:debug>
</body>
</html>
