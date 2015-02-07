<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import = "com.shopping.service.*" %>
<%@ include file="_session.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
int id = Integer.parseInt(request.getParameter("id"));
System.out.println(id);
CategoryManager.deleteCategory(id);
response.sendRedirect("categorylist.jsp");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<base href="<%=basePath%>">
    
<title>categorydelete</title>
</head>
<body>
删除成功！
<script language="javascript">
<!--
    	window.parent.main.document.location.reload();
-->    
</script>
</body>

</html>