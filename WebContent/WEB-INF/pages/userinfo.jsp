<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
</head>
<style type="text/css">
body{
  		height:100%;
  		width:100%;
  		background-image: url("http://localhost:8090/img/getImg?fileName=timg.jpg");
  		background-repeat: no-repeat;
    	background-size:cover;
    	overflow: hidden;
    	
  }
  input{
 		display:inline-block;
  		background-color: rgba(255,255,255,0.2);
  }

	img{
		width: 150px;
		height:150px;
		border-radius:50%; 
		box-shadow: 1px 2px 2px 2px;
	}
	div{
	position: relative;
	left:50px;
	}

</style>
<body>

<a href="/myworks/goods/toMainPage">返回主页</a>
<div>
<form action="/myworks/user/updateUserInfo" method="post">
		<table>
			<tr>
				<td>头像</td>
				<td>
					<img id="tx" alt="" src="${userInfo.inco }" onclick="opFile()">
					<input type="file" id="file" onchange="upload()" style="display: none">
					<input type="hidden" id="inco" name="inco" value="${userInfo.inco}">
				</td>
			</tr>
			<tr>
				<td>昵称</td>
				<td>
					<input id="nickName" name="nickName" value="${userInfo.getNickName() }">
				</td>
			</tr>
			<tr>
				<td>手机号</td>
				<td>
					<input id="cellphone" name="cellphone" value="${userInfo.cellphone }">
				</td>
			</tr>
			<tr>
				<td>qq</td>
				<td>
					<input id="qq" name="qq" value="${userInfo.qq }">
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td>
					<input id="email" name="email" value="${userInfo.email }">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交">
				</td>
				
			</tr>
		</table>
	</form>
	<hr/>
	<span style="font-size: 20px;font-weight: 600">收货地址</span>
	<a href="javascript:void(0)" onclick="showAdd()">添加收货地址</a>
	<div>收货人姓名 联系电话  收货地址</div>
	<div id="addAddress" style="display: none;">
		<input id="a_r_name" >
		<input id="a_cellphone" >
		<input id="a_address"  style="width: 300px;">	
		<a href="javascript:void(0)" onclick="addAddress()">提交</a>
		<a href="javascript:void(0)" onclick="cancel()">取消</a>
		</div>
	<c:forEach items="${addressList }" var="item">
	<div>
		<c:if test="${item.isdefault==1 }"><input type="checkbox" checked="checked" disabled="disabled"></c:if>
		<c:if test="${item.isdefault!=1 }"><input type="checkbox" onchange="updateIsdefault(${item.id })"></c:if>
		<input class="r_name" value="${item.r_name }">
		<input class="cellphone" value="${item.cellphone }">
		<input class="address" value="${item.address }">
		<a href="javascript:void(0)" onclick="showEdit(this)">修改</a>
		<span class="edit" style="display: none">
			<a href="javascript:void(0)" onclick="updateAddress(${item.id},this)" >提交修改</a>&ensp;&ensp;&ensp;
			<a href="javascript:void(0)"  onclick="deleteById(${item.id})" >删除</a>&ensp;&ensp;&ensp;
		</span>
	</div>
		
	</c:forEach>
</div>

</body>
<script type="text/javascript" src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
function showEdit(th){
	var $p=$(th).parent();//获取修改按钮的父标签
	$(th).hide();//将自身隐藏起来
	$p.children(".edit").eq(0).show();//将父标签下的 class名称为 edit的标签显示出来
	//eq(0)指的是$p.children(".edit")里的第一个
}
function showAdd(){
	$("#addAddress").show(500);
}
//提交修改
function addAddress(){
	var a_r_name=$("#a_r_name").val();
	if(a_r_name==undefined||a_r_name==""){
		alert("对不起,收件人不能为空");
		return;
	}
	var a_cellphone=$("#a_cellphone").val();
	if(a_cellphone==undefined||a_cellphone==""){
		alert("对不起,联系电话不能为空");
		return;
	}
	var a_address=$("#a_address").val();
	if(a_address==undefined||a_address==""){
		alert("对不起,地址不能为空");
		return;
	}
	$.ajax ({
		url:"/myworks/address/addaddress",
		type:"post",
		data:{"r_name":a_r_name,"cellphone":a_cellphone,"address":a_address},
		dataType:"json",
		success:function(data){
			if(data.code==1){
				location.reload();
			}else if(data.code==-1){
				alert(data.message);
			}else if(data.code==3){
				location.href="/myworks/pages/login.jsp";
			}
		}
		
		
	})
}
function updateIsdefault(id){
	$.ajax ({
		url:"/myworks/address/updateDefault",
		type:"post",
		data:{"id":id},
		dataType:"json",
		success:function(data){
			location.reload();
		}
		
		
	})
}
function cancel(){
	$("#addAddress").hide(500);
}
function deleteById(id){
	$.ajax ({
		url:"/myworks/address/deleteById",
		type:"post",
		data:{"id":id},
		dataType:"json",
		success:function(data){
			if(data.code==1){
				location.reload();
			}else if(data.code==-1){
				alert(data.message);
			}else if(data.code==3){
				location.href="/myworks/pages/login.jsp";
			}
		}
		
		
	})
}
function updateAddress(id,th){
	var $p=$(th).parent().parent();
	var r_name=$p.children(".r_name").eq(0).val().trim();
	if(r_name==undefined||r_name==""){
		alert("对不起,收件人不能为空");
		return;
	}
	var cellphone=$p.children(".cellphone").eq(0).val().trim();
	if(cellphone==undefined||cellphone==""){
		alert("对不起,联系电话不能为空");
		return;
	}
	var address=$p.children(".address").eq(0).val().trim();
	if(address==undefined||address==""){
		alert("对不起,地址不能为空");
		return;
	}
	
	$.ajax ({
		url:"/myworks/address/updateAddressById",
		type:"post",
		data:{"id":id,"r_name":r_name,"cellphone":cellphone,"address":address},
		dataType:"json",
		success:function(data){
			if(data.code==1){
				location.reload();
			}else if(data.code==-1){
				alert(data.message);
			}else if(data.code==3){
				location.href="/myworks/pages/login.jsp";
			}
		}
		
		
	})
	
	
}
function opFile(){
	$("#file").click();
}
//异步上传头像

 function upload(){
	var fd=new FormData();//文件对象
	fd.append("file",$("#file")[0].files[0]);
	
	$.ajax({
		url:"http://localhost:8090/img/upload",
		type:"post",
		data:fd,
		contentType:false,//默认"application/x-www-form-urlencoded"
		processData:false,//是否将数据转换成字符串
		dataType:"json",
		success:function(data){
			$("#tx").attr("src",data.data[0]);
			$("#inco").val(data.data[0]);
		}
	})
	}  
</script>
</html>