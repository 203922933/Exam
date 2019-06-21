<%@page import="bean.Student"%>
<%@page import="bean.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	List<Subject>list = (List)session.getAttribute("subList");
	Student student = (Student)session.getAttribute("student");
	int pg = 0;
	int pgall = list.size();
	if(pgall%8 == 0){
		pgall /=8; 
	}else{
		pgall = pgall/8+1;
	}
	String pagestring = request.getParameter("page");
	if(pagestring == null){
		pg = 0;
	}else{
		pg = Integer.parseInt(pagestring);
	}
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>选择考试</title>
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
        <label class="text-left col-10 text-10">欢迎登录,<b><%=student.getUsername()%></b></label>
        <div class="text-right col-2">
            <a href="<%=path%>/QuitLoginAction"><button class="btn btn-sm btn-danger">退出登录</button></a>
        </div>
    </div>
</div>
<div class="container mt-5 px-0">
    <div class="bg-light1 px-2">
        <h4>考试列表</h4>
        <hr class="mb-0 pb-2">
    </div>
    <%
    	if(list.size()!=0){
    		out.println("<div class='container bg-light mt-0'>");
	    	for(int i=0; i<list.size(); i++){
	    		if(i%4 == 0){
	    			out.println("<div class='row pb-2'>");
	    		}	
    			Subject subject = list.get(i);
    %>
    		<div class="card bg-light page mb-2 col-3">
                <img class="card-img-top cardimg" src="<%=path %>/img/course.jpg">
                <div class="card-body bg-light">
                    <label><h5><%=subject.getSubjectname() %></h5></label>
                    <label>题量：<%=subject.getSinglenumber() %></label><br>
                    <label>时长：<%=subject.getTesttime() %>分钟</label>
                    <div class="container text-center">
                        <a href="<%=path%>/QuesListAction?id=<%=subject.getId()%>"><button class="btn btn-sm btn-primary">开始考试</button></a>
                    </div>
                </div>
            </div>
    <%
	    		if((i+1)%4 == 0){
					out.println("</div>");
				}
    		}
	    	out.println("</div>");
    	}
    %>
    
</div>
</body>
</html>