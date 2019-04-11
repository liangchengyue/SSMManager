<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet"
	href="resource/plugins/grid_manager/GridManager.min.css">
<link rel="stylesheet" href="resource/layui/css/layui.css">
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script src="resource/js/jquery.min.js"></script>
<script src="resource/js/jquery.validate.min.js"></script>
<script src="resource/js/jquery.validate.unobtrusive.min.js"></script>
<script src="resource/js/bootstrap.min.js"></script>
<script src="resource/js/common.js"></script>
<script type="text/javascript"
	src="resource/plugins/grid_manager/GridManager.min.js"></script>
<script type="text/javascript" src="resource/layui/layui.js"></script>
<style type="text/css">
span.field-validation-error {
	color: red;
}
</style>
<script type="text/javascript">
	$(function() {
		init("");
	})

	function init(keyword) {
		var table = document
				.querySelector('table[grid-manager="demo-ajaxPageCode"]');
		table
				.GM({
					ajax_url : 'user/list',
					ajax_type : 'POST',
					query : {
						pluginId : 1,
						'keyword' : keyword
					},
					supportAjaxPage : true,
					supportCheckbox : false,
					columnData : [
							{
								key : 'userName',
								text : '用户名'
							},
							{
								key : 'name',
								text : '姓名'
							},
							{
								key : 'phone',
								text : '联系电话'
							},
							{
								key : 'sex',
								text : '性别'
							},
							{
								key : 'action',
								remind : 'the action',
								width : '100px',
								text : '操作',
								template : function(action, rowObject) {
									return '<a style="color:#337ab7;" href="javascript:;" onclick="deleteInfo(\''
											+ rowObject.id
											+ '\')">删除</a>'
											+ "| "
											+ '<a style="color:#337ab7;" href="javascript:;" onclick="updateInfo(\''
											+ rowObject.id + '\')">编辑</a>';
								}
							} ]

				});
	}
</script>
</head>
<body style="margin: 20px">
	<div class="row">
		<div class="col-md-10">
			<h3>用户列表</h3>
		</div>
		<div class="col-md-1">
			<div class="form-group">
				<button type="button" data-toggle="modal" data-target="#myModal"
					class="btn">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
				</button>
			</div>
		</div>
	</div>
	<div class="row col-md-11">
		<div class="input-group">
			<input type="text" id="key" class="form-control"> <span
				class="input-group-btn">
				<button type="button" id="serach" class="btn btn-primary">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>搜索
				</button>
			</span>
		</div>
	</div>
	<div style="clear: both;"></div>
	<div class="cls"></div>
	<table grid-manager="demo-ajaxPageCode"></table>
	<!-- 添加、修改框 -->
	<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">添加用戶</h4>
				</div>
				<form id="data">
					<div class="modal-body">
						<input type="hidden" id="id">
						<div class="row">
							<div class="col-lg-12">
								<div class="form-group" lang="username">
									<label for="username">用户名：</label> <input type="text"
										class="form-control" name="userName" id="userName"
										placeholder="用户名" data-val="true"
										data-val-required="请填写 &#39;用户名&#39;。"> <span
										class="field-validation-error" data-valmsg-for="userName"
										data-valmsg-replace="true"></span>
								</div>
							</div>
							<div class="col-lg-12 hiden">
								<div class="form-group" lang="no">
									<label for="password">密码：</label> <input type="password"
										class="form-control" name="password" id="password"
										placeholder="密码" data-val="true"
										data-val-required="请填写 &#39;密码&#39;。"> <span
										class="field-validation-error" data-valmsg-for="password"
										data-valmsg-replace="true"></span>
								</div>
							</div>
							<div  class="col-lg-12 hiden">
								<div class="form-group" lang="class">
									<label for="truepassword">确认密码：</label> <input type="password"
										class="form-control" id="truepassword" name="truepassword"
										placeholder="确认密码" data-val="true" data-val-equalto="两次密码不匹配。"
										data-val-equalto-other="password"> <span
										class="field-validation-error" data-valmsg-for="truepassword"
										data-valmsg-replace="true"></span>
								</div>
							</div>
							<div  class="col-lg-12 hiden">
								<div class="form-group" lang="denger">
									<label for="denger">用户类型：</label>
									<div class="form-group">
										<label class="radio-inline"> <input type="radio"
											value="0" name="type" checked="checked">管理员 <label
											class="radio-inline"> <input type="radio" value="1"
												name="type">普通用户
										</label>
									</div>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="name">
									<label for="name">姓名：</label> <input type="text"
										class="form-control" name="name" id="name" placeholder="姓名"
										data-val="true" data-val-required="请填写 &#39;姓名&#39;。">
									<span class="field-validation-error" data-valmsg-for="name"
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
								<div class="form-group" lang="phonenumber">
									<label for="phone">电话号码：</label> <input type="text"
										class="form-control" name="phone" id="phone"
										placeholder="电话号码" data-val="true"
										data-val-required="请填写 &#39;电话号码&#39;。"> <span
										class="field-validation-error" data-valmsg-for="phone"
										data-valmsg-replace="true"></span>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="phonenumber">
									<label for="phone">年龄：</label> <input type="text"
										class="form-control" name="age" id="age" placeholder="年龄">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary" id="add">保存</button>
							</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
	<script type="text/javascript">
		function RefreshGridManagerList(keyword) {
			$(".table-div").remove();
			$(".page-toolbar").remove();
			$(".cls")
					.append('<table grid-manager="demo-ajaxPageCode"></table>');
			init(keyword);
		}
		$("#serach").click(function(){
			var keyword=$("#key").val();
			if(keyword!=undefined&&keyword!=null&&keyword.trim()!=""){
				RefreshGridManagerList(keyword);
			}
		});
		$("#add").click(function() {
			if (!$('#data').valid()) {
				return;
			}
			layui.use('layer', function() {
				layer = layui.layer;
				var id = $("#id").val();
				var url;
				var msg;
				var data;
				if (id == "") {
					url = "user/register";
					msg = "添加成功";
					data = $("#data").serialize();
				} else {
					url = "user/update";
					msg = "修改成功";
					data = $("#data").serialize() + "&id=" + id;
				}

				$.ajax({
					url : url,
					type : "POST",
					data : data,
					success : function(data) {
						$("#myModal").modal('hide');
						layer.msg(msg);
						$("#id").val("");
						document.getElementById("data").reset();
						RefreshGridManagerList("");
					}
				});
			});
		});

		//删除
		function deleteInfo(ob) {
			layui.use('layer', function() {
				layer = layui.layer;
				layer.confirm("确认要删除吗，删除后不能恢复", {
					title : "删除确认"
				}, function(index) {

					$.ajax({
						url : "user/detele",
						type : "POST",
						data : {
							'id' : ob
						},
						success : function(data) {
							if (data == 'ok') {
								layer.msg('删除成功');
								RefreshGridManagerList("");
							}
						}
					});

					layer.close(index);

				});
				/* */
			})

		}

		//更新信息
		function updateInfo(id) {
			$.ajax({
				url : 'user/findById',
				data : {
					'id' : id
				},
				typr : "post",
				success : function(data) {
					data = JSON.parse(data);
					for (k in data) {
						$("#" + k).val(data[k]);
					}
					$("#myModal").modal('show');
					$(".hiden").hide()
					$("span.field-validation-error").hide();
				}
			});
		}
	</script>
</body>
</html>