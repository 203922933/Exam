<%@page import="db.DBQuestion"%>
<%@page import="bean.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	int id = Integer.parseInt(request.getParameter("id"));
	Question que = new DBQuestion().getQuestionById(id);
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
    <form method="post" action="<%=path%>/QuesAlterAction">
        <label><h3><%=que.getSubjectname() %></h3></label>
        <input style="display: none" name="id" value="<%=que.getId()%>">
        <div class="form-group">
            <label>题目:</label>
            <textarea class="form-control" name="question" rows="3"><%=que.getQuestion()%></textarea>
        </div>
        <div class="form-group">
            <label>A选项:</label>
            <textarea class="form-control" name="selectA" rows="2"><%=que.getA()%></textarea>
        </div>
        <div class="form-group">
            <label>B选项:</label>
            <textarea class="form-control" name="selectB" rows="2"><%=que.getB()%></textarea>
        </div>
        <div class="form-group">
            <label>C选项</label>
            <textarea class="form-control" name="selectC" rows="2"><%=que.getC()%></textarea>
        </div>
        <div class="form-group">
            <label>D选项:</label>
            <textarea class="form-control" name="selectD" rows="2"><%=que.getD()%></textarea>
        </div>
		正确答案：<input name="answer" class="form-control" type="text" value="<%=que.getAnswer()%>">
        <div class="container text-center mt-2">
            <button class="btn btn-primary" type="submit">修改</button>
        </div>
    </form>
</div>
</body>
</html>