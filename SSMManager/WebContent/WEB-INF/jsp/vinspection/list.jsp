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
<script src="resource/js/jquery.min.js"></script>
<script src="resource/js/bootstrap.min.js"></script>
<script src="resource/js/common.js"></script>
<script type="text/javascript"
	src="resource/plugins/grid_manager/GridManager.min.js"></script>
<script type="text/javascript">
	$(function() {
		init();
	})

	function init() {
		var table = document
				.querySelector('table[grid-manager="demo-ajaxPageCode"]');
		table
				.GM({
					ajax_url : 'vinspection/list',
					ajax_type : 'POST',
					query : {
						pluginId : 1,
						'keyword' : '123'
					},
					supportAjaxPage : true,
					supportCheckbox : false,
					columnData : [
							{
								key : 'Ytype',
								text : '年审类型'
							},
							{
								key : 'vnumber',
								text : '车辆编号'
							},
							{
								key : 'carefutime',
								text : '年审时间'
							},
							{
								key : 'pretime',
								text : '上次年审时间'
							},
							{
								key : 'userid',
								text : '用户编号'
							},
							{
								key : 'state',
								text : '年审状态'
							},
							{
								key : 'desc',
								text : '描述'
							},
							{
								key : 'action',
								remind : 'the action',
								width : '100px',
								text : '操作',
								template : function(action, rowObject) {
									return '<a style="color:#337ab7;" href="javascript:;" onclick="deleteInfo(\''
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
			<h3>年审列表</h3>
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
					<h4 class="modal-title">添加年审</h4>
				</div>
				<form id="data">
					<input type="hidden" id="id">
					<div class="modal-body">
						<div class="row">
							<div class="col-lg-12">
								<div class="form-group" lang="Ytype">
									<label for="Ytype">年审类型：</label> <select name="Ytype"
										id="Ytype" class="selectpicker form-control"
										data-live-search="true">
										<option value="">请选择</option>
										<option value="一年一审">一年一审</option>
										<option value="二年二审">二年二审</option>
									</select>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="vnumber">
									<label for="vnumber">车辆牌号：</label> <select name="vnumber"
										id="vnumber" class="selectpicker form-control"
										data-live-search="true">
										<option value="">请选择</option>
									</select>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="carefutime">
									<label for="carefutime">年审时间：</label> <input type="text"
										class="form-control" name="carefutime" id="carefutime"
										placeholder="年审时间">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="pretime">
									<label for="pretime">上次年审时间：</label> <input type="text"
										class="form-control" name="pretime" id="pretime"
										placeholder="上次年审时间">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="userid">
									<label for="userid">用户名称：</label> <select name="userid"
										id="userid" class="selectpicker form-control"
										data-live-search="true">
										<option value="">请选择</option>
									</select>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="state">
									<label for="state">年审状态：</label> <input type="text"
										class="form-control" name="state" id="state"
										placeholder="年审状态">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="desc">
									<label for="desc">描述：</label> <input type="text"
										class="form-control" name="desc" id="desc" placeholder="描述">
								</div>
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
	
		//初始化select
		$(function(){
			SelectInfo("vinspection/findIDAndNumberVinfo", "#vnumber");
			SelectInfo("vinspection/findIDAndNumberUserId", "#userid");
		});
		
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
					url = "vinspection/regist";
					msg = "添加成功";
					data = $("#data").serialize();
				} else {
					url = "vinspection/update";
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
						url : "vinspection/detele",
						type : "POST",
						data : {
							'id' : ob
						},
						success : function(data) {
							console.log(data);
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
				url : 'vinspection/findVInspectionById',
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