<%@page import="bean.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	List<Subject>list = (List)session.getAttribute("subList");
	session.removeAttribute("subList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>题库管理</title>
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
        <label class="text-left col-10 text-10">欢迎管理员登录,<b>Username</b></label>
        <div class="text-right col-2">
            <a href="#"><button class="btn btn-sm btn-danger">退出登录</button></a>
        </div>
    </div>
</div>
<div class="container text-center mt-3">
    <a href="<%=path%>/Manager/AddExam.jsp"><button class="btn btn-primary">创建题库</button></a>
</div>
<div class="container mt-3 px-0">
    <div class="bg-light1 px-2">
        <h4>题库列表</h4>
        <hr class="mb-0 pb-2">
    </div>

    <div class="container bg-light mt-0">
        <div class="row pb-2">
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
                <img class="card-img-top cardimg" src="img/course.jpg">
                <div class="card-body bg-light">
                    <label><h5><%=subject.getSubjectname() %></h5></label>
                    <label>题量：<%=subject.getSinglenumber() %></label><br>
                    <label>时长：<%=subject.getTesttime() %></label>
                    <div class="container text-center btn-group">
                        <a href="<%=path%>/GetAllQuesitionAction?name=<%=subject.getSubjectname()%>"><button class="btn btn-sm btn-primary">所有试题</button></a>&nbsp;
                        <a href="<%=path%>/Manager/UpdateExam.jsp?id=<%=subject.getId()%>"><button class="btn btn-sm btn-primary">修改</button></a>&nbsp;
                        <a href="<%=path%>/SubjectDelAction?id=<%=subject.getId()%>"><button class="btn btn-sm btn-primary">删除</button></a>
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
</div>
</body>
</html>