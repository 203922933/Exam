$(function() {
    var options;
    $.each(citydata, function (key, value) {
        //根据数据创建option并追加到select上
        var option = "<option value=" + key + ">" + key + "</option>";
        options += option;
    });
    $("#province").append(options);
});
$("#province").change(function () {
    var province = $(this).val();
    var city = $("#city");
    //找到市的信息
    var citys = citydata[province];
    //删除原来市的信息
    city.empty();
    city.append("<option value='null'>-请选择城市-</option>");
    //添加option
    $.each(citys, function (index, item) {
        city.append("<option value='"+item+"'>" + item + "</option>");
    });
    $("#city").removeClass("blur");
    $("#posmessage").html("<br>");
})

function checkcity() {
    if($("#province").val() == "null"){
        $("#province").addClass("blur");
        $("#posmessage").text("请选择省份");
        return false;
    }else if($("#city").val() == "null"){
        $("#province").addClass("blur");
        $("#posmessage").text("请选择省份");
        return false;
    }
    return true;
}


function checkpassagin() {
    if ($("#password").val() != $("#passagin").val()) { //判断元素对象的value值
        $("#passagin").addClass("blur"); //添加css样式
        $("#pwamessage").text("两次输入密码不一致");
        return false;
    }
    return true;
}

function checkemail() {
    var em = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if (!em.test($("#email").val())) {
        $("#email").addClass("blur"); //添加css样式
        $("#emailmessage").text("请正确输入邮箱");
        return false;
    }
    return true;
}

function checkname() {
    var na = /^[_a-zA-Z0-9]{8,16}$/;

    if(!na.test($("#name").val())){
        $("#name").addClass("blur"); //添加css样式
        $("#namemessage").text("账号由8-16位数字、字母、下划线组成");
        return false;
    }
    return true;
}


function checkpw() {
    var p = /^[a-zA-Z]\w{5,15}$/;
    if (!p.test($("#password").val())) { //判断元素对象的value值
        $("#password").addClass("blur"); //添加css样式
        $("#pwmessage").text("密码由6-16位字母、数字、下划线组成");
        return false;
    }
    return true;
}

function checktel(){
    var em = /^1([38]\d|5[0-35-9]|7[3678])\d{8}$/;
    if(!em.test($("#tel").val())){
        $("#tel").addClass("blur"); //添加css样式
        $("#telmessage").text("请正确输入手机号");
        return false;
    }
    return true;
}

$("#name").blur(function () {
    var na = /^[_a-zA-Z0-9]{8,16}$/;
    if(!na.test($(this).val())){
        $(this).addClass("blur"); //添加css样式
        $("#namemessage").text("账号由8-16位数字、字母、下划线组成");
    }

})

$("#name").focus(function () {
    $(this).removeClass("blur");
    $("#namemessage").html("<br>");
})

$("#password").blur(function checkpw() {
    var p = /^[a-zA-Z]\w{5,15}$/;
    if (!p.test($(this).val())) { //判断元素对象的value值
        $(this).addClass("blur"); //添加css样式
        $("#pwmessage").text("密码由6-16位字母、数字、下划线组成");
    }
})

$("#province").blur(function () {
    if($(this).val() == "null"){
        $("#province").addClass("blur");
        $("#posmessage").text("请选择省份");
    }
})

$("#province").focus(function () {
    $(this).removeClass("blur");
    $("#posmessage").html("<br>");
})

$("#city").blur(function () {
    if($(this).val() == "null"){
        $("#city").addClass("blur");
        $("#posmessage").text("请选择城市");
    }
})

$("#city").focus(function () {
    $(this).removeClass("blur");
    $("#posmessage").html("<br>");
})

$("#password").focus(function () {
    $(this).removeClass("blur");
    $("#pwmessage").html("<br>");
})

$("#passagin").blur(function () {
    if ($("#password").val() != $(this).val()) { //判断元素对象的value值
        $(this).addClass("blur"); //添加css样式
        $("#pwamessage").text("两次输入密码不一致");
    }
})

$("#passagin").focus(function () {
    $(this).removeClass("blur");
    $("#pwamessage").html("<br>");
})

$("#email").blur(function checkemail() {
    var em = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if (!em.test($(this).val())) {
        $(this).addClass("blur"); //添加css样式
        $("#emailmessage").text("请正确输入邮箱");
    }

})

$("#email").focus(function () {
    $(this).removeClass("blur");
    $("#emailmessage").html("<br>");
})

$("#tel").blur(function () {
    var em = /^1([38]\d|5[0-35-9]|7[3678])\d{8}$/;
    if(!em.test($(this).val())){
        $(this).addClass("blur"); //添加css样式
        $("#telmessage").text("请正确输入手机号");
    }
})

$("#tel").focus(function () {
    $(this).removeClass("blur");
    $("#telmessage").html("<br>");
})

$("#regbutton").click(function () {
    if(checkname() && checkpw() && checkpassagin() && checkemail() && checktel() && checkcity()){
        $("#registerform").submit();
    }
})
