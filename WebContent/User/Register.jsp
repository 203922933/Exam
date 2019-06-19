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
    <title>注册</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link type="text/css" rel="stylesheet" href="<%=path %>/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="<%=path %>/css/register.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=path %>/js/jquery-3.3.1.min.js"></script>

    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="<%=path %>/js/popper.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="<%=path %>/js/bootstrap.min.js"></script>

    <script src="<%=path %>/js/proCity.js"></script>

</head>

<body>
<div class="container mt-3 col-sm-12 col-md-4">
    <h2 class="text-info text-center">注&nbsp;册</h2>

    <form method="post" class="text-center" name="registerform" id="registerform" action="<%=path %>/RegisterAction">

        <label class="text-left w-100">
            用户名：
            <input type="text" name="username" class="form-control" id="name">
        </label>
        <p class="text-danger" id="namemessage"><br></p>

        <label class="text-left w-100">
            密码：
            <input type="password" name="password" class="form-control" id="password">
        </label>

        <p id="pwmessage" class="text-danger"><br></p>

        <label class="text-left w-100">
            确认密码：
            <input type="password" class="form-control" name="passagin" id="passagin">
        </label>
        <p id="pwamessage" class="text-danger"><br></p>
        <label class="text-left w-100">
            邮箱：
            <input type="email" class="form-control" name="usermail" id="email">
        </label>
        <p id="emailmessage" class="text-danger"><br></p>
        <label class="text-left w-100">
            手机：
            <input type="email" class="form-control" name="usertel" id="tel">
        </label>
        <p id="telmessage" class="text-danger"><br></p>
        <label class="text-left w-100">
            地址：
            <div class="container row form-inline">
                <select class="form-control" name="province" id="province">
                    <option value="null">-请选择省份-</option>
                </select>
                &nbsp;
                <select  class="form-control" name="city" id="city">
                    <option value="null">-请选择城市-</option>
                </select>
            </div>
        </label>
        <p id="posmessage" class="text-danger">
	    <%
	    	if(message.equals("0")){
	        	out.print("两次密码不一致");
	        }else if(message.equals("1")){
	        	out.print("用户名已存在");
	        }else{
	        	out.print("<br>");
	        }
       	%>
        </p>
        <button class="btn btn-primary" type="button" id="regbutton">注册</button>
    </form>
</div>
</body>
<script src="<%=path%>/js/registerck.js">

</script>
</html>