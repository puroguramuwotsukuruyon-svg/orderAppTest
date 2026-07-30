<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri= "jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>表示ページ１</title>
</head>
<body>
	<h1>注文内容を確認します</h1>
	<form action = "/rei18/OrderToDB" method="POST">
	
	<table border=1>
	<tr>
		<th>商品名</th>
		<th>値段</th>
		<th>個数</th>
	</tr>
		<c:forEach var="entry" items="${currentOrder.order}">
		<tr>
		<td><c:out value="${entry.key.name}" />
		<td><c:out value="${entry.key.price }" />
		<td><c:out value="${entry.value }" />
		</td>
		</c:forEach> 
	</table>
	<br />
	<br />
		<a href= "/rei18/jsp/orderInput.jsp">追加注文</a>
		
		<p>
		<input type="submit" value="注文確定" />
		</p>
	</form>
</body>
</html>