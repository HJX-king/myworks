<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<style type="text/css">
  body{
  		height:100%;
  		width:100%;
  		background-image: url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1567258425202&di=c87f8f88b153630313cc52e235993211&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201301%2F31%2F20130131204333_EGJEe.jpeg");
  		background-repeat: no-repeat;
    	background-size:cover;
    	overflow: hidden;
    	
  }
  div{
         display:inline-block;
         

  }
  input{
  		display:inline-block;
  		background-color: rgba(213,208,188,0.2);
  }
  .all{
  		position: relative;
		top:160px;
		left:300px;
  
  }
</style>
<body>
<div class="all">
<h1 style="font-size:56px">&ensp;&ensp;注&ensp;&ensp;册</h1>

	用户名:&ensp;&ensp;<input id="userName" name="userName"onblur="checkUserName()"><div id="nameMesg"></div><br><br>
	密&ensp;&ensp;码:&ensp;&ensp;<input id="password" name="password" type="password"><div id="pwMesg"></div><br><br>
	确认密码:<input id="repassword" name="repassword" type="password" ><div id="rpwMesg"></div><br><br>
	<button onclick="register()">注册</button><a href="/myworks/pages/main.jsp">返回</a>

</div>
</body>
<script type="text/javascript" src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	function checkUserName() {
		var userName=$("#userName").val();
		if(userName==undefined||userName==""){
			$("#nameMesg").text("用户名不能为空");
			$("#nameMesg").css('color','red').css('font-size','14px');
			return;
		}
		
		$.ajax({
			url:"/myworks/user/checkUserName",
			type:"post",
			data:{"userName":userName},
			dataType:"json",
			success:function(data){
				if(data.code==-1){
					$("#nameMesg").text(data.message);
					$("#nameMesg").css('color','red').css('font-size','14px');
				}else if(data==1){
					$("#nameMesg").text(data.message);
					$("#nameMesg").css('color','green').css('font-size','14px');
				}
				
			}
		})
		
	}
	 function register() {
	    var userName=$("#userName").val();
		var password=$("#password").val();
		var repassword=$("#repassword").val();
		if(userName==undefined||userName==""){
			$("#nameMesg").text("用户名不能为空");
			$("#nameMesg").css('color','red').css('font-size','14px');
			return;
		}
		if(password==undefined||password==""){
			$("#pwMesg").text("密码不能为空");
			$("#pwMesg").css('color','red').css('font-size','14px');
			return;
		}if(password!=repassword){
			$("#rpwMesg").text("两次密码不一致!");
			$("#rpwMesg").css('color','red').css('font-size','14px');
			return;
		}
		$.ajax({
			url:"/myworks/user/register",
			type:"post",
			data:{"userName":userName,"password":password,"repassword":repassword},
			dataType:"json",
			success:function(data){
				if(data.code==1){
					alert(data.message);
					location.href="/myworks/user/toLogin";
				}else if(data.code==-1){
					alert(data.message);
				}
			}
		});
		
	} 
</script> 
</html>