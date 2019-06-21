$(function () {

    var time = parseInt((parseInt($("#endtime").val() ) - new Date().getTime())/1000);
    alert(new Date().getTime());
    var min = parseInt(time/60);
    var second = time%60;
    $("#resttime").text(min+":"+second);
    var timer = self.setInterval(function addtime() {
        time--;
        show(time);
        if(time == 0){
            $("#resttime").removeClass("text-success");
            $("#resttime").removeClass("text-danger");
        }
        if(time == 0){
            $("#exam").submit();
            alert("考试结束!")
            clearInterval(timer);

        }
    }, 1000)

    function show(reltime) {
        var min = parseInt(reltime/60);
        var second = reltime%60;
        $("#resttime").text(min+":"+second);
    }
})
