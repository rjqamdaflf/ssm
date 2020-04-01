
function send(email){
    $.ajax({
        type: "GET",
        url: "/user/getCode",
        data: {email:email},
        dataType: 'json',
        success: function (data) {
        }, error: function (e) {
        }
    });
}
let countdown=60;
function getCode(val){
    let reg = /^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/;
    if(countdown==60){
        let email = document.getElementById("textfield").value;
        if(email===""){
            alert("邮箱不能为空！");
            return;
        }else if(!reg.test(email)){
            alert("邮箱格式不对!")
            return;
        }
        else{
            send(email);
        }
    }
    if (countdown == 0) {
        val.removeAttribute("disabled");
        val.value="获取验证码";
        countdown=60;
    } else {
        val.setAttribute("disabled", true);
        val.value="重新发送(" + countdown + ")";
        countdown--;
        setTimeout(function() {
            getCode(val)
        },1000)
    }
}
//刷新验证码
function refreshCode() {
    document.getElementById("code").src = "validateCode?" + Math.random();
}

//表单验证
function checkForm() {
    let bpwd = document.registerForm.bpwd.value;
    let rebpwd = document.registerForm.rebpwd.value;
    if (bpwd != rebpwd) {
        alert("两次密码不一致！");
        return false;
    }
    document.registerForm.submit();
    return true;
}