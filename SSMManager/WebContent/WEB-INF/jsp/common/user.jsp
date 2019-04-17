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
		onclick="page('/SSMManager/user/toUpdate', '信息修改')">信息完善</button>
	</c:if>
	<script src="../resource/js/jquery.min.js?v=2.1.4"></script>
	<script src="../resource/js/bootstrap.min.js?v=3.3.5"></script>
	<script src="../resource/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="../resource/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="../resource/js/plugins/layer/layer.min.js"></script>
	<script src="../resource/js/hplus.min.js?v=4.0.0"></script>
	<script type="../text/javascript" src="resource/js/contabs.min.js"></script>
	<script src="../resource/js/plugins/pace/pace.min.js"></script>
	<script src="../resource/js/common.js"></script>
</body>
</html>