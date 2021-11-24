<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css">
<script type="text/javascript" src="/webjars/jquery/2.1.3/dist/jquery.min.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('.insert_btn').click(function(){
			window.location="http://localhost:8080/cs/insert";
		});
	});
</script>
<style rel="stylesheet" type="text/css">
	*{
		margin: 0px auto;
		padding: 0px;
		width: 1200px;
	}
	tr{
		text-align: center;
	}
	.table_no{
		width: 150px;
	}
	a{
		text-decoration: none;
		color: black;
	}
</style>
</head>
<body>
	<h3 class="page-header">고객센터</h3>
	<table class="table table-bordered">
		<tr style="font-weight: bold; background-color: #aaaaaa; color: white">
			<td class="table_no">글순서</td>
			<td class="table_sub">글제목</td>
			<td class="table_id">글쓴이</td>
			<td class="table_nalja">작성일</td>
		</tr>
		<c:forEach items="${list}" var="bean">
			<tr>
				<td class="table_no"><a href="/cs/detail?csno=${bean.csno}">${bean.csno }</a></td>
				<td class="table_sub"><a href="/cs/detail?csno=${bean.csno}">${bean.cssub }</a></td>
				<td class="table_id"><a href="/cs/detail?csno=${bean.csno}">${bean.csid }</a></td>
				<td class="table_nalja"><a href="/cs/detail?csno=${bean.csno}">${bean.csnalja }</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="insert_btn">
		<button 
			style="height:40px; width: 100px; background-color: #aaaaaa" class="btn btn-secondary" type="button">
			<span style="color: white;">글쓰기</span>
		</button>
	</div>
</body>
</html>