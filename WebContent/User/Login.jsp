<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String message = (String)session.getAttribute("message");
	if(message == null){
		message = "";
	}else{
		session.removeAttribute("message");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link type="text/css" rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path%>/css/login.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path%>/js/jquery-3.3.1.min.js"></script>

    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="<%=path%>/js/popper.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="<%=path%>/js/bootstrap.min.js"></script>


</head>

<body>
<div class="text-center w-100 h-50 bg-info mb-5">
    <h2>在&nbsp;线&nbsp;考&nbsp;试&nbsp;系&nbsp;统</h2>
</div>
<div class="col-sm-8 mt-5 pt-3 border border-info border-radius col-md-4 container bg-light">

    <form class="text-left" action="<%=path %>/LoginAction" id="log" method="post">
        <h2 class="text-center ">登&nbsp;&nbsp;录</h2>
        <br>
        <br>
        <lable class="w-100 ">
            用户名：
            <input type="text" class="form-control" name="username" id="name">
        </lable>
        <br>
        <lable class="w-100 ">
            密码：
            <input type="password" class="form-control" name="password" id="password">
        </lable>
        <label class="w-100 text-center text-danger" >
            <p id="message"><br></p>
        </label>
        <div class="text-center">
        <div class="btn-group">
            <button class="btn btn-lg btn-primary" type="button" id="login">登录</button>&nbsp;&nbsp;
            <a href="<%=path%>/User/Register.jsp" target="_blank"><button class="btn btn-lg btn-success" type="button" id="register">注册</button></a>
        </div>
        </div>
        <br>
    </form>
</div>
<script type="text/javascript">
<%
	if(message.equals("-1")){
		out.print("$(function(){"+
			"$('#message').text('用户名或密码错误，登录失败');"+
		"})");
	}
%>
</script>
</body>
<script src="<%=path%>/js/loginck.js">
</script>
</html>