<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="favicon.ico">
<link href="../resource/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link href="../resource/css/font-awesome.min.css?v=4.4.0"
	rel="stylesheet">
<link href="../resource/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="../resource/css/animate.min.css" rel="stylesheet">
<link href="../resource/css/style.min.css?v=4.0.0" rel="stylesheet">
<base target="_blank">
<style type="text/css">
span.field-validation-error {
	color: red;
	text-align: left;
	display: block;
}

.checkbox input[type=checkbox], .checkbox-inline input[type=checkbox],
	.radio input[type=radio], .radio-inline input[type=radio] {
	margin-left: 0;
}

.checkbox input[type=checkbox], .checkbox-inline input[type=checkbox],
	.radio input[type=radio], .radio-inline input[type=radio] {
	margin-top: 0;
}

.no-padding span {
	margin-left: 20px
}
</style>
</head>
<body class="gray-bg">
	<div class="middle-box text-center loginscreen   animated fadeInDown">
		<div>
			<h3>欢迎注册 小区物业管理系统</h3>
			<p>创建一个小区物业管理系统新账户</p>
			<form class="m-t" role="form">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="请输入用户名"
						name="userName" id="userName" data-val="true"
						data-val-required="请填写 &#39;用户名&#39;。"> <span
						class="field-validation-error" data-valmsg-for="userName"
						data-valmsg-replace="true"></span>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="请输入密码"
						name="password" data-val="true"
						data-val-required="请填写 &#39;密码&#39;。" id="password"> <span
						class="field-validation-error" data-valmsg-for="password"
						data-valmsg-replace="true"></span>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="请再次输入密码"
						name="truepassword" data-val="true" data-val-equalto="两次密码不匹配。"
						data-val-equalto-other="password"> <span
						class="field-validation-error" data-valmsg-for="truepassword"
						data-valmsg-replace="true"></span>
				</div>
				<div class="form-group text-left">
					<div id="check" class="checkbox i-checks">
						<label class="no-padding"> <input id="check"
							type="checkbox"><span>我同意注册协议</span>
						</label> <br> <span class="field-validation-error check"
							style="display: none;">请勾选&#39;注册协议&#39;</span>
					</div>

				</div>
				<div id="register" class="btn btn-primary block full-width m-b">注
					册</div>

				<p class="text-muted text-center">
					<small>已经有账户了？</small><a href="toLogin">点此登录</a>
				</p>

			</form>
		</div>
	</div>
	<script src="../resource/js/jquery.min.js?v=2.1.4"></script>
	<script src="../resource/js/bootstrap.min.js?v=3.3.5"></script>
	<script src="../resource/js/plugins/iCheck/icheck.min.js"></script>
	<script src="../resource/js/jquery.validate.min.js"></script>
	<script src="../resource/js/jquery.validate.unobtrusive.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("input[type='checkbox']").change(function() {
				var ch = $(this).prop("checked");
				if (!ch) {
					$(".check").show();
				} else {
					$(".check").hide();
				}
			})
			$("#register").click(function() {
				var ch = $("input[type='checkbox']").prop("checked");
				if (!ch) {
					$(".check").show();
					return;
				} else {
					$(".check").hide();
				}
				console.log(ch);
				//console.log(ch);
				if (!$('form').valid()) {
					return;
				}
				var name = $("#userName").val();
				var pwd = $("#password").val();
				$.ajax({
					url : 'register',
					data : {
						"userName" : name,
						"password" : pwd,
						"type" : 0,
						"name":name
					},
					type : "POST",
					success : function(data) {
						window.location.href = "toLogin";

					}
				});
			});
		})
	</script>
</body>
</html>