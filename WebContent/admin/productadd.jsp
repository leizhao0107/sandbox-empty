<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import = "com.shopping.service.*" %>
<%@ page import = "com.shopping.model.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ include file="_session.jsp"%>

<%
request.setCharacterEncoding("gb2312");
String action = request.getParameter("action");

if(action!=null && action.trim().equals("add")){
	String name = request.getParameter("name");
	String descr = request.getParameter("descr");
	double normalprice=Double.parseDouble(request.getParameter("normalprice"));
	double memberprice=Double.parseDouble(request.getParameter("memberprice"));
	int categoryid = Integer.parseInt(request.getParameter("categoryid"));
	
	
	Product p = new Product();
	p.setId(-1);
	p.setName(name);
	p.setDescr(descr);
	p.setNormalprice(normalprice);
	p.setMemberprice(memberprice);
	p.setCategoryid(categoryid);
	if(ProductManager.getInstance().addProduct(p)){
		
	
	
	out.println("Congratulation! Productadd OK");
}
	response.sendRedirect("productlist.jsp");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">

    
<title>productadd</title>
</head>
<body>
		<center>产品类别</center>
		<form action="productadd.jsp" method="post">
			<input type = "hidden" name="action" value="add"> 
			<table>
				<tr>
					<td>name:</td>
					<td><input type="text" name="name"></td>
				</tr>	
				<tr>
					<td>descr:</td>
					<td><textarea name="descr" rows="8" cols="40"></textarea></td>
				</tr>
				<tr>
					<td>normalprice:</td>
					<td><input type="text" name="normalprice"></td>
				</tr>
				<tr>
					<td>memberprice:</td>
					<td><input type="text" name="memberprice"></td>
				</tr>
				<tr>
					<td>categoryId:</td>
					<td><input type="text" name="categoryid"></td>
				</tr>
				
				<tr>
					<td colspan=2><input type="submit" value="提交"></td>
				</tr>			
			</table>
		</form>
		
</body>

</html>