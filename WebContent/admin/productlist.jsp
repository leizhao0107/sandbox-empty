<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import = "com.shopping.service.*" %>
<%@ page import = "com.shopping.model.*" %>
<%@ page import = "java.util.*" %>


<%
//int strPageNo = Integer.parseInt(request.getParameter("pageNo"));

String strPageNo = request.getParameter("pageNo");
int pageNo = 1;
if(strPageNo != null){
	pageNo=Integer.parseInt(strPageNo);
}
if(pageNo<1)pageNo=1;
int pageSize = 3;
%>

<%

List<Product> products = new ArrayList<Product>();
int pageCount = ProductManager.getInstance().getProducts(products,pageNo,pageSize);
if(pageNo>pageCount){
	pageNo = pageCount;
}



%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Productlist</title>
</head>
<body>
 	<table border="1" align="center">
 			<tr>
 				<td>ID</td>
 				<td>Name</td>
 				<td>Descr</td>
 				<td>Normalprice</td>
 				<td>Memberprice</td>
 				<td>CategoryID</td>
 				<td></td>
 			</tr>
<%
		for(Iterator<Product> it = products.iterator();it.hasNext();){
			Product p = it.next();
		
%>
	<tr>
		<td><%=p.getId() %></td>
		<td><%=p.getName()%></td>
		<td><%=p.getDescr()%></td>
		<td><%=p.getNormalprice()%></td>
		<td><%=p.getMemberprice()%></td>
		<td><%=p.getCategoryid()%></td>
		<td><a href="productadd.jsp?id=<%= p.getId()%>">添加产品</a></td>
		<td><a href="productdelete.jsp?id=<%= p.getId()%>">删除产品</a></td>	
		<td><a href="productmodify.jsp?id=<%= p.getId()%>">修改产品</a></td>		
	</tr>

 			
<%
}
%>
	</table>
		<center>
			第<%=pageNo %>页
			&nbsp;
			共<%=pageCount %>页
			&nbsp;
			<a href="productlist.jsp?pageNo=<%=pageNo-1 %>">上一页</a>
			&nbsp;
			<a href="productlist.jsp?pageNo=<%=pageNo+1 %>">下一页</a>
		</center>
	
	
</body>
</html>