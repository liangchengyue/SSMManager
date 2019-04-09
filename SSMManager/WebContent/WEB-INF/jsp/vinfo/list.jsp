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
		table.GM({
			ajax_url : 'vinfo/list',
			ajax_type : 'POST',
			query : {
				pluginId : 1,
				'keyword' : '123'
			},
			supportAjaxPage : true,
			supportCheckbox : false,
			columnData : [ {
				key : 'carowner',
				text : '车主'
			}, {
				key : 'vlicense',
				text : '行驶证编号'
			},{
				key : 'vnumber',
				text : '车辆编号'
			}, , {
				key : 'model',
				text : '车型'
			}, {
				key : 'color',
				text : '车色'
			}, {
				key : 'engine',
				text : '发动机型号'
			}, {
				key : 'pcapacity',
				text : '装载人数'
			}, {
				key : 'createtime',
				text : '制造日期'
			},{
				key : 'displacement',
				text : '发动机排量'
			},{
				key : 'quality',
				text : '总质量'
			},{
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
	        }]
	        
		});
	}
</script>
</head>
<body style="margin: 20px">
	<div class="row">
		<div class="col-md-10">
			<h3>车辆信息列表</h3>
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
					<h4 class="modal-title">添加车辆信息</h4>
				</div>
				<form id="data">
					<div class="modal-body">
					<input type="hidden" id="id">
						<div class="row">
							<div class="col-lg-12">
								<div class="form-group" lang="carowner">
									<label for="carowner">车主：</label> <input type="text"
										class="form-control" name="carowner" id="carowner"
										placeholder="车主">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="vlicense">
									<label for="vlicense">行驶证编号：</label> <input type="text"
										class="form-control" name="vlicense" id="vlicense"
										placeholder="行驶证编号">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="vnumber">
									<label for=vnumber>车辆编号：</label> <input type="text"
										class="form-control" name="vnumber" id="vnumber"
										placeholder="车辆编号">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="model">
									<label for="model">车型：</label> <input type="text"
										class="form-control" name="model" id="model"
										placeholder="车型">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="color">
									<label for="color">车色：</label> <input type="text"
										class="form-control" name="color" id="color"
										placeholder="车色">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="engine">
									<label for="engine">发动机型号：</label> <input type="text"
										class="form-control" name="engine" id="engine"
										placeholder="发动机型号">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="pcapacity">
									<label for="pcapacity">装载人数：</label> <input
										type="text" class="form-control" name="pcapacity"
										id="pcapacity" placeholder="装载人数">
								</div>
							</div>
							<div class="col-lg-12">
								<div class="form-group" lang="createtime">
									<label for="createtime">制造日期：</label> <input
										type="date" class="form-control" name="createtime" id="createtime"
										placeholder="制造日期">
								</div>
								<div class="col-lg-12">
								<div class="form-group" lang="displacement">
									<label for="displacement">发动机排量：</label> <input
										type="text" class="form-control" name="displacement" id="displacement"
										placeholder="发动机排量">
								</div>
							<div class="col-lg-12">
							  <div class="form-group" lang="quality">
								<label for="quality">总质量：</label> <input
									type="text" class="form-control" name="quality" id="quality"
									placeholder="总质量">
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
		$(".cls").append('<table grid-manager="demo-ajaxPageCode"></table>');
		init(keyword);
	}
		$("#add").click(function() {
			layui.use('layer', function() {
				layer = layui.layer;
				var id=$("#id").val();
			var url;
			var msg;
			var data;
			console.log(id);
			if(id==""){
				url="vinfo/regist";
				msg="添加成功";
				data=$("#data").serialize();
			}else{
				url="vinfo/update";
				msg="修改成功";
				data=$("#data").serialize()+"&id="+id;
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
						url : "vinfo/detele",
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
		function updateInfo(id){
			$.ajax({
				url:'vinfo/findVInfoById',
				data:{'id':id},
				typr:"post",
				success:function(data){
					data=JSON.parse(data);
					for(k in data){
						$("#"+k).val(data[k]);
					}
					$("#myModal").modal('show');
				}
			});
		}
	</script>
</body>
</html>