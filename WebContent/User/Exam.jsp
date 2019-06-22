<%@page import="bean.Subject"%>
<%@page import="bean.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	Subject subject = (Subject)session.getAttribute("selsub");
	List<Question>list = (List)session.getAttribute("quesList");
	Long date = (Long)session.getAttribute("endtime");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>考试进行中</title>
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
            <label><h3><%=subject.getSubjectname() %></h3></label><br>
            <label >题量：<%=subject.getSinglenumber() %><b>50题</b></label><br>
            <label >每题分值：<b><%=subject.getSingleper() %></b></label><br>
            <label>考试时长：<b><%=subject.getTesttime() %></b></label><br>
            <label>剩余时间：<b class="text-success" id="resttime">00:00</b></label><br>
        </div>
    </div>
    <input style="display:none;" id="endtime" value="<%=date%>">
    <form action="<%=path%>/ExamResultAction" method="post" id="exam" class="mt-3">
    	<%
    	for(int i=0; i<list.size(); i++){
    		Question question = list.get(i);
    	%>
        <div class="mt-2">
            <label><b>习题<%= i+1 %></b></label>
            <hr class="my-0">
            <p><%=question.getQuestion()%></p>
            <div class="radio">
                <label><input type="radio" value="A" name="question<%=i%>">A.<%=question.getA() %></label>
            </div>
            <div class="radio">
                <label><input type="radio" value="B" name="question<%=i%>">B.<%=question.getB() %></label>
            </div>
            <div class="radio">
                <label><input type="radio" value="C" name="question<%=i%>">C.<%=question.getC() %></label>
            </div>
            <div class="radio">
                <label><input type="radio" value="D" name="question<%=i%>">D.<%=question.getD() %></label>
            </div>
        </div>
        <%} %>
        <hr>
        <div class="container text-center">
            <button class="btn btn-primary" type="submit">提交</button>
        </div>
    </form>
</div>
</body>
<script src="<%=path%>/js/exam.js"></script>
</html>