<%@page import="bean.Manager"%>
<%@page import="bean.Score"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	List<Score>list = (List)session.getAttribute("scList");
	session.removeAttribute("scList");
	Manager manager = (Manager)session.getAttribute("manager");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>考试记录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/chiose.css">
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
</div>
<div class="text-center">
    <br><h1>在&nbsp;线&nbsp;考&nbsp;试&nbsp;系&nbsp;统</h1><br>
</div>
<div class="container mt-3">
    <div class="row bg-light1 py-1">
        <label class="text-left col-10 text-10">欢迎管理员登录,<b><%=manager.getName() %></b></label>
        <div class="text-right col-2">
            <a href="#"><button class="btn btn-sm btn-danger">退出登录</button></a>
        </div>
    </div>
</div>
<div class="container mt-5 px-0">
    <div class="bg-light1 px-2">
        <h4>历史记录</h4>
        <hr class="mb-0 pb-2">
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>用户</th>
            <th>考试名称</th>
            <th>结束时间</th>
            <th>得分</th>
        </tr>
        </thead>
        <tbody>
        <%for(Score score:list){%>
        <tr>
            <td><%=score.getUsername() %></td>
            <td><%=score.getSubjectname() %></td>
            <td><%=score.getEndtime() %></td>
            <td><%=score.getScore() %></td>
        </tr>
        <%} %>
        </tbody>
    </table>

</div>
</body>
</html>