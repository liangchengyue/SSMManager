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
<script src="resource/js/bootstrap.min.js"></script>
<script src="resource/js/common.js"></script>
<script type="text/javascript"
	src="resource/plugins/grid_manager/GridManager.min.js"></script>
<script type="text/javascript" src="resource/layui/layui.js"></script>
<script type="text/javascript">
	$(function() {
		init();
	})

	function init() {
		var table = document
				.querySelector('table[grid-manager="demo-ajaxPageCode"]');
		table
				.GM({
					ajax_url : 'user/list',
					ajax_type : 'POST',
					query : {
						pluginId : 1,
						'keyword' : '123'
					},
					supportAjaxPage : true,
					supportCheckbox : false,
					columnData : [
							{
								key : 'number',
								text : '用户名'
							},
							{
								key : 'username',
								text : '登录名'
							},
							{
								key : 'name',
								text : '用户名'
							},
							{
								key : 'password',
								text : '密码'
							},
							{
								key : 'phonenumber',
								text : '联系电话'
							},
							{
								key : 'denger',
								text : '性别'
							},
							{
								key : 'idcard',
								text : '身份证号'
							},
							{
								key : 'address',
								text : '家庭地址'
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
									<label for="username">登录名：</label> <input type="text"
										class="form-control" name="username" id="username"
										placeholder="登录名">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="name">
									<label for="name">姓名：</label> <input type="text"
										class="form-control" name="name" id="name" placeholder="姓名">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="denger">
									<label for="denger">性别：</label> <input type="radio"
										name="denger" value="false">男 <input type="radio"
										name="denger" value="true">女
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="name">
									<label for="idcard">身份证名：</label> <input type="text"
										class="form-control" name="idcard" id="idcard"
										placeholder="身份证名">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="address">
									<label for="address">地址：</label> <input type="text"
										class="form-control" name="address" id="address"
										placeholder="地址">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="number">
									<label for="number">职工编号：</label> <input type="text"
										class="form-control" name="number" id="number"
										placeholder="职工编号">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="phonenumber">
									<label for="phonenumber">电话号码：</label> <input type="text"
										class="form-control" name="phonenumber" id="phonenumber"
										placeholder="电话号码">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="no">
									<label for="password">密码：</label> <input type="password"
										class="form-control" name="password" id="password"
										placeholder="密码">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="class">
									<label for="truepassword">确认密码：</label> <input type="password"
										class="form-control" id=""
										truepassword""
										placeholder="确认密码">
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
		$("#add").click(function() {
			layui.use('layer', function() {
				layer = layui.layer;
				var id = $("#id").val();
				var url;
				var msg;
				var data;
				if (id == "") {
					url = "user/regist";
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
				url : 'user/findUserById',
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
				}
			});
		}
	</script>
</body>
</html>