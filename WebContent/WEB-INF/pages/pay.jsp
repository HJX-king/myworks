<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/pages/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>支付</title>
</head>
<body>
	
	<div class="main">
		<form action="goods/pay" method="post">
			<input type="hidden" name="id" value="${order_id }">
			<input  > 
			
			<input type="submit" value="确认支付">
		
		</form>
	</div>
	
</body>
</html>