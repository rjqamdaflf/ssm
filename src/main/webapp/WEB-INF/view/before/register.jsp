<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <link href="css/before/daohang.css" rel="stylesheet" type="text/css"/>
    <link href="css/before/common.css" rel="stylesheet" type="text/css"/>
    <link href="css/before/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">

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
            let reg = /^([a-z0-9A-Z]+[-|\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\.)+[a-zA-Z]{2,}$/;
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
    </script>
</head>
<body>
<div class="clearfix">
    <div class="blank20"></div>
    <div class="box4">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="100%" valign="bottom">
                    <h2>普通会员注册</h2>
                </td>
            </tr>
        </table>
    </div>
    <div class="blank10"></div>
    <div class="box4">
        <div class="case_ll clearfix">
            <div class="regist">
                <form:form action="user/register" method="post" modelAttribute="buser" name="registerForm">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0"
                           class="ttbb2">
                        <tr>
                            <td width="16%" align="right"><span class="cl_f30">*</span>
                                E-mail：
                            </td>
                            <td width="59%">
                                <input style="width:49%" type="text" name="bemail"
                                       id="textfield" class="my_txt_350" value="${buser.bemail}"/>
                                <input  type="button" onclick="getCode(this)" class="my_txt_120" value="获取验证码" />
                            </td>
                        </tr>
                        <tr>
                            <td align="right">&nbsp;</td>
                            <td colspan="2" style="font-size: 12px; padding-bottom: 25px;">
                                （有效的E-mail地址才能收到激活码，帐户在激活后才能享受网站服务。）
                            </td>
                        </tr>
                        <tr>
                            <td align="right"><span class="cl_f30">*</span> 密码：</td>
                            <td><input type="password" name="bpwd" id="textfield2"
                                       class="my_txt_350"/></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="right">&nbsp;</td>
                            <td colspan="2" style="font-size: 12px; padding-bottom: 25px;">
                                （为了您帐户的安全，建议使用字符+数字等多种不同类型的组合，且长度大于5位。）
                            </td>
                        </tr>
                        <tr>
                            <td align="right"><span class="cl_f30">*</span> 重复密码：</td>
                            <td><input type="password" name="rebpwd" id="textfield3"
                                       class="my_txt_350"/></td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="right">&nbsp;</td>
                            <td colspan="2" style="font-size: 12px; padding-bottom: 25px;">
                                （确保您记住密码。）
                            </td>
                        </tr>
                        <tr>
                            <td align="right"><span class="cl_f30">*</span> 验证码：</td>
                            <td class="ared"><input type="text" name="code"
                                                    id="textfield5" class="my_txt_120"/>
                                    <%--<img id="code" src="validateCode"/>--%>
                                    <%--<a href="javascript:refreshCode();"><font color="blue">看不清，换一个！</font></a>--%>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">&nbsp;</td>
                            <td colspan="2" class="cl_f30" style="font-size: 12px; padding-bottom: 25px;"></td>
                        </tr>
                        <tr>
                            <td align="right">&nbsp;</td>
                            <td height="50"><input type="button" name="button" id="button" onclick="checkForm()"
                                                   value="注册账号" class="my_ann1"/></td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                </form:form>
                <div class="blank20"></div>
            </div>
        </div>
    </div>
    <div class="blank10"></div>
</div>
</body>
</html>
