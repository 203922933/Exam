<%@page import="bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	Student student = (Student)session.getAttribute("student");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/main.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="js/popper.min.js"></script>
    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div id="demo" class="carousel slide" data-ride="carousel">
    <!-- 指示符 -->
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>
    <!-- 轮播图片 -->
    <div class="carousel-inner lbt">
        <div class="carousel-item active">
            <img src="https://static.runoob.com/images/mix/img_fjords_wide.jpg">
        </div>
        <div class="carousel-item">
            <img src="https://static.runoob.com/images/mix/img_nature_wide.jpg">
        </div>
        <div class="carousel-item">
            <img src="https://static.runoob.com/images/mix/img_mountains_wide.jpg">
        </div>
    </div>
    <!-- 左右切换按钮 -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
</div>
    <div class="text-center">

        <br><h1>在&nbsp;线&nbsp;考&nbsp;试&nbsp;系&nbsp;统</h1><br>
    </div>
<div class="row mt-3 bg-light">
    <div class="col-3 pb-2 px-0">
        <div class="bg-light1 px-1">
            <h3>个人信息</h3>
        <hr>
        </div>
        <div class="px-2">
            <label><b>用户名：<%=student.getUsername() %></b></label><br><br>
            <label><b>电&nbsp;&nbsp;&nbsp;话：<%=student.getUsertel() %></b></label><br><br>
            <label><b>邮&nbsp;&nbsp;&nbsp;箱：<%=student.getUsermail() %></b></label><br><br>
            <label><b>地&nbsp;&nbsp;&nbsp;址：<%=student.getAddress() %></b></label><br><br>
            <div class="container btn-group text-center">
                <a href="#"><button class="btn btn-primary">修改信息</button></a>&nbsp;&nbsp;
                <a href="#" ><button class="btn btn-danger">退出登录</button></a>
            </div>
        </div>
    </div>
    <div class="bg-white col-1"></div>
    <div class="container btn-group-lg text-center col-8 mt-5">
        <a href="#"><button class="btn btn-primary">选择考试</button></a>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#"><button class="btn btn-primary">考试记录</button></a>
    </div>
</div>
</div>
</body>
</html>