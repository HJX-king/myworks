<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="/myworks/" target=""> <!-- 指名当前页面的基础url -->

</head>
<style type="text/css">
	a img{
		height: 30px;
		width:30px;
		border-radius:15px;
	    vertical-align: middle;
	}
</style>
<body>
<div style="text-align: right;height: 40px;line-height: 40px">
	<a href="goods/toMainPage">主页</a>
	<a href="goods/toCartPage">购物车</a>
	<a href="goods/toOrderPage">我的订单</a>
	<c:if test="${login==null}">
		<a href="user/toLogin">登录</a>	&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="user/toRegister">注册</a>
	</c:if>
	<c:if test="${login!=null}">
		<a href="user/toUserInfo">
			<img alt="头像" src="${login.inco }">
			${login.nickName }</a>	&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="user/logOut">退出</a>
	</c:if>
</div>

</body>
<script type="text/javascript" src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</html>