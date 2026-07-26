<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文入力画面</title>
</head>
<body>
	<h1>注文入力</h1>
	
	<form action = "/rei18/OrderServlet" method="POST">
	<table>
	<tr>
	<th>商品名</th>
	<td><input type = "text" name="name" required/></td>
	</tr>
	
	<tr>
	<th>注文数</th>
	<td><input type = "number" name ="count" value="0" /></td>
	</tr>
	
	</table>
	
	<input type ="submit" value ="送信" />
	
	
	</form>
	
</body>
</html>