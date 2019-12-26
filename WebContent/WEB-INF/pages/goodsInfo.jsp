<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品详情</title>
</head>
<style type="text/css">
	.main{
	    width: 1000px;
	    margin-left: auto;
	    margin-right: auto;
	}
	.top_left{
		display: inline-block;
	}
	.top_left img{
		
		width: 500px;
	}
	.top_right{
		display: inline-block;
	}
	
	.content{
		font-size: 20px;
		font-weight: 600px;
	}
	.content img{
		width: 100%;
	}
</style>
<body>
	<div class="main">
		<div class="top">
			<div class="top_left">
				<img alt="商品图片" src="${good.inco}">
			</div>
			<div class="top_right">
				${good.g_name }				<br>
				价格:${good.price }					<br>
				类型:${good.type_name }				<br>
				剩余:${good.num }					<br>
				选择数量:<button onclick="changeNum(false)">-</button><input style="width: 30px" type="number" id="num" value="1"><button onclick="changeNum(true)">+</button>   <br>
				<button onclick="addToCart(${good.id})">加入购物车</button><button>立即购买</button>
			</div>
		</div>
		<hr>
		<div class="content">
			${good.content }
		
		</div>
	</div>
</body>
<script type="text/javascript">
	//添加商品到购物车
	function addToCart(id){
		var num =$("#num").val();
		
		$.ajax({
			url:"goods/addToCart",
			type:"post",
			data:{"goods_id":id,"num":num},
			dataType:"json",
			success:function(data){
				if(data.code==3){
					window.open("pages/login.jsp","_blank");
				}else{
					alert(data.message)
				}
			}
		})
	}

	function changeNum(flg){
		var num = $("#num").val();
		if(flg){
			num++;
		}else{
			num--;
			if(num<=0){
				num=1;
			}
		}
		$("#num").val(num);
	}
</script>
</html>