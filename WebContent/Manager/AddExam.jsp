<%@page import="bean.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	Manager manager = (Manager)session.getAttribute("manager");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新建题库</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/chiose.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path %>/js/jquery-3.3.1.min.js"></script>
    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="<%=path %>/js/popper.min.js"></script>
    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="<%=path %>/js/bootstrap.min.js"></script>
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
</div>
<div class="text-center">
    <br><h1>在&nbsp;线&nbsp;考&nbsp;试&nbsp;系&nbsp;统</h1><br>
</div>
<div class="container mt-3">
    <div class="row bg-light1 py-1">
        <label class="text-left col-10 text-10">欢迎管理员登录,<b><%=manager.getName()%></b></label>
        <div class="text-right col-2">
            <a href="#"><button class="btn btn-sm btn-danger">退出登录</button></a>
        </div>
    </div>
</div>
<div class="container mt-5 mb-3 px-0">
    <div class="bg-light1 px-2">
        <h4>添加题库</h4>
        <hr class="mb-0 pb-2">
    </div>
    <div class="container text-center">
    <form method="post" action="<%=path%>/SubjectAddAction">
        <label class="text-left w-50">考试名称：<input class="form-control" type="text" name="name"></label><br>
        <label class="text-left w-50">单题分值：<input class="form-control" type="text" name="fenzhi"></label><br>
        <label class="text-left w-50">考题数量：<input class="form-control" type="text" name="num"></label><br>
        <label class="text-left w-50">考试时长（分钟）：<input class="form-control" type="text" name="time"></label><br>
      	<button class="btn btn-primary" type="submit">添加题库</button>
    </form>
    </div>
</div>
</body>
</html>