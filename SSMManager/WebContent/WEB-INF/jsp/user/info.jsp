<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
table{
width: 600px;
margin: 0 auto;
background: #ddd;
}
tr {
	line-height: 40px;
}
tr>th{
width: 100px;
text-align: right;
padding-right: 20px;
}
</style>
</head>
<body>
	<h2 style="text-align: center;">个人信息</h2>
	<table>
		<tr>
			<th>姓名:</th>
			<td>${info.uname}</td>
		</tr>
		<tr>
			<th>年龄:</th>
			<td>${info.age}岁</td>
		</tr>
		<tr>
			<th>性别:</th>
			<td>${info.sex}</td>
		</tr>
		<tr>
			<th>电话:</th>
			<td>${info.phone}</td>
		</tr>
		<tr>
			<th>身份证号:</th>
			<td>${info.idcard}</td>
		</tr>
		<tr>
			<th>人数:</th>
			<td>${info.number}人</td>
		</tr>
		<tr>
			<th>门牌号:</th>
			<td>${info.fnumber}</td>
		</tr>
		<tr>
			<th>面积:</th>
			<td>${info.fsize}</td>
		</tr>
		<tr>
			<th>户型:</th>
			<td>${info.ftype}</td>
		</tr>
		<tr>
			<th>停车位置:</th>
			<td>${info.address}</td>
		</tr>
		<tr>
			<th>停车费用:</th>
			<td>${info.money}元/年</td>
		</tr>
	</table>
</body>
</html>