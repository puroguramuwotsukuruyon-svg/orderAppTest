<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content =" 10; url=/rei18/${file}">
<title>error page</title>
</head>
<body>
	<h1>エラー</h1>
	<c:out value="${error}" />
	<br/>
	10秒後に戻ります。
	<br/>
</body>
</html>