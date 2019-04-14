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
					ajax_url : 'place/list',
					ajax_type : 'POST',
					query : {
						pluginId : 1,
						'keyword' : keyword
					},
					supportAjaxPage : true,
					supportCheckbox : false,
					columnData : [
							{
								key : 'address',
								text : '地址'
							},
							{
								key : 'money',
								text : '费用'
							},
							{
								key : 'state',
								text : '状态'
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
			<h3>车位信息列表</h3>
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
					<h4 class="modal-title">添加车位</h4>
				</div>
				<form id="data">
					<div class="modal-body">
						<input type="hidden" id="id">
						<div class="row">
							<div class="col-lg-12">
								<div class="form-group" lang="content">
									<label for="userid">用户：</label> <input type="textarea"
										class="form-control" name="userid" id="userid"
										placeholder="用户" data-val="true"
										data-val-required="请填写 &#39;用户&#39;。"> <span
										class="field-validation-error" data-valmsg-for="userid"
										data-valmsg-replace="true"></span>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="username">
									<label for="title">地址：</label> <input type="text"
										class="form-control" name="address" id="address"
										placeholder="地址" data-val="true"
										data-val-required="请填写 &#39;地址&#39;。"> <span
										class="field-validation-error" data-valmsg-for="address"
										data-valmsg-replace="true"></span>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="content">
									<label for="phone">费用：</label> <input type="textarea"
										class="form-control" name="money" id="money" placeholder="费用"
										data-val="true" data-val-required="请填写 &#39;费用&#39;。">
									<span class="field-validation-error" data-valmsg-for="费用"
										data-valmsg-replace="true"></span>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="content">
									<label for="phone">费用：</label> <input type="textarea"
										class="form-control" name="money" id="money" placeholder="费用"
										data-val="true" data-val-required="请填写 &#39;费用&#39;。">
									<span class="field-validation-error" data-valmsg-for="费用"
										data-valmsg-replace="true"></span>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary" id="add">保存</button>
							</div>
						</div>
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
		$("#serach").click(
				function() {
					var keyword = $("#key").val();
					if (keyword != undefined && keyword != null
							&& keyword.trim() != "") {
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
					url = "place/add";
					msg = "添加成功";
					data = $("#data").serialize();
				} else {
					url = "place/update";
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
						url : "place/detele",
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
				url : 'place/findById',
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