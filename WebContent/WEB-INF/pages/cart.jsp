<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/pages/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的购物车</title>
</head>
<style type="text/css">
.main {
	width: 1000px;
	margin-left: auto;
	margin-right: auto;
	text-align: left;
}

.img {
	width: 100px;
}

.cart {
	border: 1px solid;
	margin: 10px 0px;
}

.g_name {
	width: 300px;
	display: inline-block;
	margin: 0px 10px;
	font-size: 18px;
	font-weight: 900;
}

.num {
	margin: 0px 10px;
}

.price {
	font-size: 20px;
	color: red;
	margin-right: 50px;
	display: inline-block;
	width: 100px;
}

#toOrder {
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
	<div class="main">
		<input type="checkbox" id="checkAll" checked="checked"> 全选
		<c:forEach items="${carts }" var="item">
			<div class="cart">
				<input type="hidden" value="${item.id }" class="id"> <input
					type="checkbox" class="checkOne" checked="checked"> <img
					alt="商品图" src="${item.inco }" class="img"> <span
					class="g_name">${item.g_name }</span> 单价:<span class="price">
					${item.price }</span> <span class="num"><button
						onclick="changeNum(${item.id},false,this)">-</button> <input
					type="number" onchange="changeNum(${item.id },undefined,this)"
					style="width: 30px" id="num" value="${item.num }">
					<button onclick="changeNum(${item.id},true,this)">+</button></span> 小计:<span
					class="price priceSum">${item.price *item.num }</span> <a
					href="javascript:void(0)" onclick="deleteCart(${item.id})">删除</a>

			</div>
		</c:forEach>
		<div style="text-align: right; font-size: 30px;">
			总计:<span id="sum" style="color: red">0</span>
			<button id="toOrder" onclick="toOrder()">提交订单</button>
		</div>
	</div>
</body>
<script type="text/javascript">

//点击全选按钮
$("#checkAll").click(function (){
	var flg=$(this).prop("checked");
	$(".checkOne").each(function(){
		$(this).prop("checked",flg);
	});
	sum();//点击全选按钮,要从新计算价格
})
//点击子项
$(".checkOne").each(function (){
	$(this).click(function(){
		//获取checked的值
		var flg=$(this).prop("checked");
		if(flg){
			//$(".checkOne:checked") ?????
			//attr只能点一次,prop可以用多次
			if($(".checkOne").length==$(".checkOne:checked").length){
				$("#checkAll").prop("checked",flg)
			}
		}else{
			$("#checkAll").prop("checked",flg)
		}
		sum();//每次勾选子项都要重新计算价格
	})
})

//跳转到订单支付页面
	function toOrder(){
	//创一个集合
		var arr = new Array();
		$(".id").each(function(){
			//获取多选框的属性
			var flg = $(this).parent().children(".checkOne").eq(0).prop("checked");
			if(flg){//如果是勾选了,就获取他的id
				var id = $(this).val();
				arr.push(id);
			}
		})
		
		var str = "";
		//遍历集合,拿出里面的每一个id
		arr.forEach(function(item){
			str+= "ids="+item+"&";
		})
		location.href="goods/toToOrderPage?"+str;
	}
	
	//根据购物车记录id删除购物车记录
	function deleteCart(id){
		
		var flg = confirm("确定要删除此商品?")
		if(!flg){//点击取消,不删除
			return;
		}
		
		$.ajax({
			url:"goods/deleteCart",
			type:"post",
			data:{"id":id},
			dataType:"json",
			success:function(data){
				if(data.code==3){
					window.open("user/toLogin","_blank");
				}else if(data.code==1){
					location.reload();
				}else{
					alert(data.message);
				}
			}			
		})
	}
	
	//修改商品的数量
	function changeNum(id,flg,th){
		var $input = $(th).parent().children("input").eq(0);
		var num = $input.val(); //获取到当前商品的数量
		//点击加减号来修改
		//直接修改的话就直接获取到数量
		if(flg!=undefined){
			if(flg){
				num++;
			}else{
				num--;
				if(num<=0){
					num=1;
				}
			}
		}
		//将计算后的数量发送给服务器
		$.ajax({
			url:"goods/updateCart",
			type:"post",
			data:{"id":id,"num":num},
			dataType:"json",
			success:function(data){
				if(data.code==3){
					window.open("user/toLogin","_blank");
				}else if(data.code==1){
					$input.val(num);
					//计算出新数量之后, 将新数量放到数量框中
					//$(th) 代表的是加减按钮, 
					
					var $price =  $(th).parent().parent().children(".price").eq(0); //拿到单价的标签
					var p = parseInt($price.text().trim()); //获取到单价
					var su = p * num;//小计
					
					var $priceSum =  $(th).parent().parent().children(".priceSum").eq(0)
					$priceSum.text(su);//计算小计
					sum(); //重新计算总价
				}else{
					alert(data.message);
				}
			}			
		})
	}
	
	//计算商品的总价
	function sum(){
		var sum = 0;
		$(".priceSum").each(function(){
			//不是所有的商品都要计算, 是哪些被选中的商品才需要计算
			var flg = $(this).parent().children(".checkOne").eq(0).prop("checked"); //获取当前行中的按钮的选中状态
			if(flg){ //如果状态是true, 说明需要计算
				var price = parseInt($(this).text().trim()); //将当前行的价格拿出来,计算到总和中
				sum+=price;
			}
		})
		$("#sum").text(sum); //将计算的结果放回总价所在的标签中
	}
	
	$(function(){
		sum();
	})
</script>
</html>