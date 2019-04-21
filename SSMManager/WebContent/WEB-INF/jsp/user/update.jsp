<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../resource/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link rel="stylesheet" href="../resource/layui/css/layui.css">
<style type="text/css">
span.field-validation-error {
	color: red;
}

</style>
</head>
<body>
	<div class="modal-header">

		<h4 class="modal-title">信息修改</h4>
	</div>
	<form id="data">
		<div class="modal-body">
			<input type="hidden" id="id">
			<div class="row">
				<div class="col-lg-12">
					<div class="form-group" lang="username">
						<label for="username">用户名：</label> <input type="text"
							class="form-control" name="username" id="username"
							placeholder="用户名" disabled="disabled">
					</div>
				</div>
				<div class="col-lg-12">
					<div class="form-group" lang="name">
						<label for="name">姓名：</label> <input type="text"
							class="form-control" name="uname" id="uname" placeholder="姓名"
							data-val="true" data-val-required="请填写 &#39;姓名&#39;。"> <span
							class="field-validation-error" data-valmsg-for="name"
							data-valmsg-replace="true"></span>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="form-group" lang="denger">
						<label for="denger">性别：</label>
						<div class="form-group">
							<label class="radio-inline"> <input type="radio"
								value="男" name="sex" checked="checked">男 <label
								class="radio-inline"> <input type="radio" value="女"
									name="sex">女
							</label>
						</div>
					</div>
				</div>

				<div class="col-lg-12">
					<div class="form-group">
						<label for="phone">电话号码：</label> <input type="text"
							class="form-control" name="phone" id="phone" placeholder="电话号码"
							data-val="true" data-val-required="请填写 &#39;电话号码&#39;。">
						<span class="field-validation-error" data-valmsg-for="phone"
							data-valmsg-replace="true"></span>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="form-group" lang="phonenumber">
						<label for="phone">年龄：</label> <input type="text"
							class="form-control" name="age" id="age" placeholder="年龄">
					</div>
				</div>
				<div class="col-lg-12">
					<div class="form-group">
						<label for="phone">身份证号码：</label> <input type="text"
							class="form-control" name="idcard" id="idcard" placeholder="身份证号"
							data-val="true" data-val-required="请填写 &#39;身份证号&#39;。">
						<span class="field-validation-error" data-valmsg-for="idcard"
							data-valmsg-replace="true"></span>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="form-group">
						<label for="phone">家庭人数：</label> <input type="text"
							class="form-control" name="number" id="number" placeholder="家庭人数"
							data-val="true" data-val-required="请填写 &#39;家庭人数&#39;。">
						<span class="field-validation-error" data-valmsg-for="number"
							data-valmsg-replace="true"></span>
					</div>
				</div>
				<div class="col-lg-12" id="p">
					<div class="form-group">
						<label for="driverid">停车位：</label> </label> <select name="pid" id="pid"
							class="selectpicker form-control" data-live-search="true" data-val="true" data-val-required="请选择 &#39;停车位&#39;。">
						</select>
						<span class="field-validation-error" data-valmsg-for="pid"
							data-valmsg-replace="true"></span>
					</div>
				</div>
				<div class="col-lg-12" id="f">
					<div class="form-group">
						<label for="driverid">房屋：</label> </label> <select name="fid" id="fid"
							class="selectpicker form-control" data-live-search="true" data-val="true" data-val-required="请选择 &#39;房间&#39;。">
						</select>
						<span class="field-validation-error" data-valmsg-for="fid"
							data-valmsg-replace="true"></span>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
					<button type="button" class="btn btn-primary" id="add">保存</button>
				</div>
	</form>
	<script src="../resource/js/jquery.min.js"></script>
	<script src="../resource/js/jquery.validate.min.js"></script>
	<script src="../resource/js/jquery.validate.unobtrusive.min.js"></script>
	<script src="../resource/js/common.js"></script>
	<script type="text/javascript" src="../resource/layui/layui.js"></script>
	<script type="text/javascript">
		$(function() {
			SelectInfo("../common/findFloorSelect", "#fid");
			SelectInfo("../common/findPlaceSelect", "#pid");
			$.ajax({
				url : 'findUserInfo',
				success : function(data) {
					console.log(data);
					data = JSON.parse(data);
					for (k in data) {
						$("#" + k).val(data[k]);
					}
					if (data["fid"] !== 0) {
						$("#f").hide();
					}
					if (data["pid"] !== 0) {
						$("#p").hide()
					}
				}
			});
			$("#add").click(function(){
				if (!$('#data').valid()) {
					return;
				}
				layui.use('layer', function() {
					layer = layui.layer;
					var url="updateInfo";
					var msg="修改成功";
					var data= $("#data").serialize();
					$.ajax({
						url : url,
						type : "POST",
						data : data,
						success : function(data) {
							layer.msg(msg);
							$("#id").val("");
						}
					});
				});
			});
		})
	</script>
</body>
</html>