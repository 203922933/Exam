$("#name").blur(function () {
    if($(this).val().length < 6) {
        $(this).addClass("blur");
        $("#message").text("请输入正确的用户名！");
    }
})

$("#name").focus(function () {
        $(this).removeClass("blur");
        $("#message").html("<br>");
})

$("#password").blur(function () {
    if($(this).val().length <6 ) {
        $(this).addClass("blur");
        $("#message").text("请正确输入密码");
    }
})

$("#password").focus(function () {
    $(this).removeClass("blur");
    $("#message").html("<br>");
})

$("#login").click(function () {
    if($("#name").val().length <6 ) {
        $("#name").addClass("blur");
        $("#message").text("请正确输入用户名");
    }else if($("#password").val().length <6 ){
        $("#password").addClass("blur");
        $("#message").text("请正确输入密码");
    }else{
        $("#log").submit();
    }
})