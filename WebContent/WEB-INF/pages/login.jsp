<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录11</title>
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
  		background-color: rgba(213,208,188,0.2);
  }

  .all{
  		position: relative;
		top:160px;
		left:300px;
  
  }
  div img{
  position: relative;
  top:20px;
  }
</style>
<body>

<div class="all">
<h1 style="font-size:56px">&ensp;&ensp;登&ensp;&ensp;录</h1>
<div id="megs"></div><br>
	用户名:<input id="userName" name="userName"><br><br>
	密&ensp;&ensp;码:<input id="password" name="password" type="password"><br>
	<!-- 验证码:<input id="imgcode" >	<img alt="" src="/myworks/user/imgcode"><br><br> -->
	<!-- &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
	记住我<input id="rem" type="checkbox" name="rem"> -->
	<button id="sub" onclick="login()">登录</button>
	<a href="/myworks/pages/main.jsp">返回</a>
</div>
</body>
<script type="text/javascript" src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
		function login(){
			/* var imgcode = $("#imgcode").val();
			if(imgcode==undefined||imgcode.trim()==""){
				$("#mesg").text("对不起,验证码不能为空");
				return;
			} */
			var userName=$("#userName").val();
			var password=$("#password").val();
			/* var rem=$("#rem").val(); */
			if(userName==undefined||userName==""){
				$("#megs").text("用户名不能为空");
				$("#megs").css('color','red').css('font-size','14px');
				return;
			}
			if(password==undefined||password==""){
				$("#megs").text("密码不能为空");
				$("#megs").css('color','red').css('font-size','14px');
				return;
			}
			 $.ajax({
				url:"/myworks/user/login",
				type:"post",
				data:{"userName":userName,"password":password},
				dataType:"json",
				success:function(data){
				 if(data.code==-1){
						 $("#megs").text(data.message);
						$("#megs").css('color','red');
						changeImg();
						return;
					}else if(data.code==1){ 
						alert(data.message);
						location.href="/myworks/goods/toMainPage";
					 }
				}
			}); 
		}




</script>
</html>