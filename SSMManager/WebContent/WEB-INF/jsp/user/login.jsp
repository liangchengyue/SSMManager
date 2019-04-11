<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="resource/favicon.ico" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title> 登录</title>
    <link href="../resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="../resource/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="../resource/css/animate.min.css" rel="stylesheet">
    <link href="../resource/css/style.min.css" rel="stylesheet">
    <link href="../resource/css/login.min.css" rel="stylesheet">
    <script type="text/javascript" src="../resource/js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#login").click(function () {
                var name = $("#name").val();
                if (name.trim() == "") {
                    return;
                } var pwd = $("#password").val();
                if (pwd.trim() == "") {
                    return;
                }
                $.ajax({
                	url:'login',
                	data:{
                		"userName":name,
                		"password":pwd
                	},
                	type:"POST",
                	success:function(data){
                		console.log(data);
                		if(data!="登录失败"){
                			window.location.href="/SSMManager/common/toFrame";
                		}
                	}
                });
            });
            
        });
    </script>
</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <img src="resource/img/贵州大学明德学院.png" width="60px" />
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>小区管理系统</strong></h4>
                    <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                    </ul>
                    <strong>还没有账号？ <a href="toRegister">立即注册&raquo;</a></strong>
                </div>
            </div>
            <div class="col-sm-5">
                <form method="post" action="#">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录小区管理系统</p>
                    <input type="text" class="form-control uname" id="name" placeholder="用户名" />
                    <input type="password" class="form-control pword m-b" id="password" placeholder="密码" />
                 <button class="btn btn-success btn-block" type="button" id="login">登录</button>
                </form>
            </div>
        </div>
        <div class="signup-footer" >
            <div class="pull-left" style="text-align: center;">
                &copy; 2018-2019 小区管理系统
            </div>
        </div>
    </div>
</body>

</html>