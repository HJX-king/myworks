<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/pages/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页面</title>
</head>
<style type="text/css">
/*body {
	height: 100%;
	width: 100%;
	background-image:
		url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567258425202&di=c87f8f88b153630313cc52e235993211&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201301%2F31%2F20130131204333_EGJEe.jpeg");
	background-repeat: no-repeat;
	background-size: cover;

}
 
div {
	float: right;
	font-size: 20px;
	position: relative;
	margin-right: 30px;
}
 */

.goods{
		display: inline-block;
		margin: 10px 20px;
		cursor: pointer;
	}
	.img{
		width: 260px;
    	height: 320px;
	}
	.price{
	    font-size: 35px;
   		color: red;
	}
	.num{
		font-size: 12px;
	}
	a{
		margin: 0px 10px;
	}
</style>
<body>
<%-- <div style="text-align: right;">
<c:if test="${login==null }">
<a href="/myworks/pages/register.jsp">新用户注册</a>
<a href="/myworks/pages/login.jsp">登录系统</a>
</c:if>
<c:if test="${login!=null }">
<a href="/myworks/user/toUserInfo">
			<img alt="" src="${login.inco }">
			${login.nickName }</a>
<a href="/myworks/user/logout">退出系统</a>
</c:if>
</div> --%>

<div style="text-align: center;">
	<form action="goods/toMainPage">
		<input name="g_name" value="${goods.g_name }"><input type="submit">			<br>
		<c:forEach items="${typeList }" var="item">
			<!-- 我们在jsp中拼接html代码时, 时可以在任意位置使用jsp标签的, jsp表本身是封装的Java代码 -->
			<input type="checkbox" value="${item.id }" 
			<c:forEach var="type_id" items="${goods.typeIds}">
				<c:if test="${item.id==type_id}">checked="checked"</c:if>
			</c:forEach> 
			name="typeIds"> ${item.type_name }
		</c:forEach>
		<div>
			<input type="hidden" value="" id="price" name="orderBy">
			<input type="hidden" value="" id="create_time" name="orderBy">
		</div>
	</form>
	<button onclick="sortPrice(this)" id="pb">价格</button>
	<button onclick="sortTime(this)" id="tb">创建时间</button>
</div>

<div id="main" style="text-align: center;">
	<c:forEach items="${goodsList }" var="item">
	
		<div class="goods" onclick="toInfo(${item.id})">	
			<img class="img" alt="图片" src="${item.inco }">
			<div class="price">￥${item.price }</div>
			<div class="g_name">${item.g_name }</div>
			<div class="num">剩余:${item.num }</div>
		</div>
	
	</c:forEach>
	
</div>
<div style="text-align: center;margin: 30px 0px">${paging1 }</div>
</body>
<script type="text/javascript">
//最开始保持中立状态
//点击之后保持设定状态
var priceIndex = 0;
var timeIndex = 0;
var price = ${orderBy};// 从服务端返回的排序
if(price!=null){
	price.forEach(function (item){  //遍历多个排序方式
		if(item!=""){  //判断
			if(item=="price ASC"){  //如果是价格的从低到高  , 设置角标为0 计算设置按钮和input框的值 
				priceIndex = 0;
				sortPrice($("#pb"));
			}else if(item=="price DESC"){
				priceIndex = 1;
				sortPrice($("#pb"));
			}else if(item=="create_time ASC"){
				timeIndex = 0;
				sortTime($("#tb"));
			}else if(item=="create_time DESC"){
				timeIndex = 1;
				sortTime($("#tb"));
			}
		}
	})
}


function sortPrice(th){
	if(priceIndex%2==0){
		$(th).text("价格(低->高)")
		$("#price").val("price ASC");
	}else{
		$(th).text("价格(高->低)")
		$("#price").val("price DESC");
	}
	priceIndex++;
}


function sortTime(th){
	if(timeIndex%2==0){
		$(th).text("时间(低->高)")
		$("#create_time").val("create_time ASC");
	}else{
		$(th).text("时间(高->低)")
		$("#create_time").val("create_time DESC");
	}
	timeIndex++;
}





//进入商品详情
	function toInfo(id){
		//location.href = ; //在当前标签页打开
		window.open("goods/toGoodsInfoPage?id="+id,"_blank"); //指定打开的方式
	}
</script>
</html>