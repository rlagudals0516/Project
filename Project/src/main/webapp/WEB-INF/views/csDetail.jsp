<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>고객센터</title>
<link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css">
<script type="text/javascript" src="/webjars/jquery/2.1.3/dist/jquery.min.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('.update_btn').click(function(){
			window.location="http://localhost:8080/cs/update?csno=${detail.csno}";
		});
		$('.delete_btn').click(function(){
			window.location="http://localhost:8080/cs/delete?csno=${detail.csno}";
		});
	});
</script>
<style type="text/css">
	*{
		margin: 0px auto;
		padding: 0px;
		width: 1200px;
	}	
	button{
		width: 100px;
		height: 40px;
		border: 0px;
		border-radius: 12px;
		background-color: #aaaa;
		color: white;
	}
	textarea {
		resize: none;
	}
</style>
</head>
<body>
	<h3 class="page-header">${detail.cssub }</h3>
	${detail.csid } ${detail.csnalja }<br>
	<textarea rows="20" cols="">${detail.cscontent }</textarea>
	<button class="update_btn">수정</button>
	<button class="delete_btn">삭제</button>
</body>
</html>