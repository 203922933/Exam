<%@page import="bean.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	List<Question>list = (List)session.getAttribute("queListByName");
	session.removeAttribute("queListByName");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>试题列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/exam.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path %>/js/jquery-3.3.1.min.js"></script>
    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="<%=path %>/js/popper.min.js"></script>
    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="<%=path %>/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="bg-ls text-center py-3">
        <div class="mx-5 text-left">
            <label><h3>C语言程序设计</h3></label><br>
            <label >题量：<b>50题</b></label><br>
            <label >每题分值：<b>1</b></label><br>
            <label>考试时长：<b>12:00</b></label><br>
        </div>
    </div>
    <%
    for(int i=0; i<list.size(); i++){
   		Question que = list.get(i);
    %>
    <div class="mt-2">
        <label><b>习题<%=i+1 %></b></label>
        <hr class="my-0">
        <label><p>A.<%=que.getA() %></p></label><br>
        <label><p>B.<%=que.getB() %></p></label><br>
        <label><p>C.<%=que.getC() %></p></label><br>
        <label><p>D.<%=que.getD() %></p></label><br>
        <label class="text-success">正确答案：<%=que.getAnswer() %></label>
        <div class="container btn-group px-0">
            <a href="<%=path%>/UpdateQuestion.jsp?id=<%=que.getId()%>"><button class="btn btn-sm btn-primary">修改</button></a>&nbsp;&nbsp;
            <a href="<%=path%>/QuesDelAction?id=<%=que.getId()%>"><button class="btn btn-sm btn-danger">删除</button></a>
        </div>
    </div>
    <%} %>
    <hr>
</div>
</body>
</html>