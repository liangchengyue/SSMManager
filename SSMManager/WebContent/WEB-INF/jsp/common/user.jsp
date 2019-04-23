<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../resource/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<style type="text/css">
h2 {
	text-align: center !important;
}
</style>
</head>
<body>
	<h2 style="text-align: center;">欢迎业主：${user.name}</h2>
	<c:if test="${user.phone==null}">
	<button class="btn btn-primary"
		onclick="window.location.href='/SSMManager/user/toUpdate'">信息完善</button>
	</c:if>
	<div style="margin: 20px;">
		<h2 id="title">标题</h2>
		<p id="content">内容</p>
		<span style="text-align: right;display: block;" id="time">yyyy-mm-dd</span>
	</div>
	<div class="pager" style="margin-top: 40px;">
	<a href="javascript:;" onclick="toPre();" >上一条</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:;" onclick="toNext();">下一条</a>
	</div>
	<script src="../resource/js/jquery.min.js?v=2.1.4"></script>
	<script src="../resource/js/bootstrap.min.js?v=3.3.5"></script>
	<script src="../resource/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="../resource/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="../resource/js/plugins/layer/layer.min.js"></script>
	<script src="../resource/js/hplus.min.js?v=4.0.0"></script>
	<script type="../text/javascript" src="resource/js/contabs.min.js"></script>
	<script src="../resource/js/plugins/pace/pace.min.js"></script>
	<script src="../resource/js/common.js"></script>
	<script type="text/javascript">
	var count=-1;
	var cpage=1;
	$(function(){
		init();
	})
	function toPre() {
		if(cpage==1){
			alert("已经是最新一条了");
			return;
		}
		cpage--;
		init();
	}
	function toNext() {
		if(cpage==count){
			alert("已经是最后一条了");
			return;
		}
		cpage++;
		init();
	}
	function init(){
		
		
		$.ajax({
			url:'/SSMManager/notice/list',
			data:{
				'pSize':1,
				'takeNum':1,
				'cPage':cpage
			},
			type:'POST',
			success:function(data){
				data = JSON.parse(data);
				var record=data.data[0];
				$("#title").html(record.title);
				$("#content").html(record.content);
				$("#time").html(record.time);
				count=data.totals;
				if(count==0){
					alert("暂无数据");
				}
			}
			})
	}
	</script>
</body>
</html>