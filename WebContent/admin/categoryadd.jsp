<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import = "com.shopping.service.*" %>
<%@ page import = "com.shopping.model.*" %>
<%@ include file="_session.jsp"%>

<%
request.setCharacterEncoding("gb2312");
String strPid = request.getParameter("pid");
int pid = 0;
if(strPid != null){
	pid = Integer.parseInt(strPid);
}


String action = request.getParameter("action");

if(action!=null && action.trim().equals("add")){
	String name = request.getParameter("name");
	String descr = request.getParameter("descr");
	if(pid==0){
	Category.addTopCategory(name, descr);
	}else{
		Category parent = new Category();
		parent.setId(pid);
		Category child = new Category();
		child.setId(-1);
		child.setName(name);
		child.setDescr(descr);
		parent.addChild(parent.getId(),child);
	}
	out.println("Congratulation! Register OK");
	
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">

    
<title>categoryadd</title>
</head>
<body>
		<center>添加类别</center>
		<form action="categoryadd.jsp" method="post">
			<input type = "hidden" name="action" value="add"> 
			<input type = "hidden" name="pid" value="<%=pid %>">
			<table>
				<tr>
					<td>类别名称:</td>
					<td><input type="text" name="name"></td>
				</tr>	
				<tr>
					<td>类别描述:</td>
					<td><textarea name="descr" rows="8" cols="40"></textarea></td>
				</tr>
				<tr>
					<td colspan=2><input type="submit" value="提交"></td>
				</tr>			
			</table>
		</form>
		
</body>

</html>