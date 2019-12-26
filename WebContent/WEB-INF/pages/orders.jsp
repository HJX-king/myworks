<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/pages/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单展示</title>
</head>
<style type="text/css">
	.main{
		width: 1000px;
	    margin-left: auto;
	    margin-right: auto;
	    text-align: left;
	}
	.img{
		height: 50px;
	}
	.order{
		
		border: 1px solid;
		margin: 10px 0px;
		
	
	}
</style>
<body>
	
	
	<div class="main">
		<c:forEach items="${list }" var="item">
			<div class="order">
				<div>
					订单编号: ${item.id }&nbsp;&nbsp;
					总价: ${item.price }
					<c:if test="${item.status==0 }">未支付</c:if>
					<c:if test="${item.status==1 }">已支付</c:if>
					<div>
						收货地址:
					</div>
				</div>
				<div>
					<c:forEach items="${item.mappings }" var="it">
						<div>
							<img src="${it.inco }" class="img"/>
							${it.g_name }
							${it.num }
							${it.price }
						</div>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
		<div>
			${paging }
		</div>
	</div>
</body>
</html>