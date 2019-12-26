<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提交订单页</title>
</head>
<style type="text/css">
  #main{
		width: 1000px;
	    margin-left: auto;
	    margin-right: auto;
	    text-align: left;
	}
	.img{
		width: 100px;
	}
	.cart{
		border: 1px solid;
		
		margin: 10px 0px;
	
	}
	
	.g_name{
		width: 300px;
		display: inline-block;
		margin: 0px 10px;
		font-size: 18px;
		font-weight: 900;
	}
	.num{
		margin: 0px 10px;
	}
	.price{
		font-size: 20px;
		color: red;
		margin-right: 50px;
		display: inline-block;
		width: 100px;
		
	}
	#order{
	    border: 0px;
	    width: 200px;
	    height: 50px;
	    color: white;
	    font-size: 27px;
	    font-weight: 900;
	    background-color: red;
	    letter-spacing: 3px;
	}
</style>
<body>
	<div id="main">
		<div>
			选择收货地址 : <select id="address" style="width: 400px;">
				<c:forEach items="${addresses }" var="item">
 				<!--selected=‘true’可以缩写为selected,因为selected=‘false’是默认属性 -->
					<option value="${item.id }" <c:if test="${item.isdefault==1 }">selected</c:if>>
					
					${item.r_name } &nbsp;&nbsp;
					${item.cellphone } &nbsp;&nbsp;
					${item.address }
					</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<c:forEach items="${carts }" var="item">
				<div class="cart">
					<input type="hidden" value="${item.id }" class="id">
					<img alt="商品图" src="${item.inco }" class="img">
					<span class="g_name">${item.g_name }</span>
					单价:<span class="price">${item.price }</span>
					数量:<span>${item.num }</span>
					小计:<span class="price priceSum">${item.price * item.num}</span>
				</div>
			</c:forEach>
			<div style="text-align: right; font-size: 30px;">
				总计:  <span id="sum" style="color: red">0</span>
				<button id="order" onclick="oder()">去支付</button>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">

	//去支付
	function oder(){
		var s = "";
		$(".id").each(function(){
			s += "&cartIds="+$(this).val();
		})
		
		location.href="goods/toOrder?address_id="+$("#address").val()+s;
		
	}

//计算商品的总价
	function sum(){
		var sum = 0;
		$(".priceSum").each(function(){
			var price = parseInt($(this).text().trim()); //将当前行的价格拿出来,计算到总和中
			sum+=price;
		})
		$("#sum").text(sum); //将计算的结果放回总价所在的标签中
	}
	
	$(function(){
		sum();
	})
</script>
</html>