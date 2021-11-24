<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		$('.reset_btn').click(function(){
			window.location="http://localhost:8080/cs";
		});
	});
</script>
<style rel="stylesheet" type="text/css">
	*{
		margin: 0px auto;
		padding: 0px;
		width: 1200px;
	}
	textarea{
		resize: none;	
	}
	button{
		width: 100px;
		height: 40px;
		background-color: #aaaaaa;
		border: 0px;
		border-radius: 12px;
		color: white;
	}
</style>
</head>
<body>
	<h3 class="page-header">글쓰기</h3>
	<form action="insert_action" method="post">
		<span style="font-weight: bold">글 제목</span><br><input style="width: 600px;" type="text" name="cssub"><br><br>
		<textarea rows="20" cols="" name="cscontent"></textarea><br>
		아아디<input type="text" name="csid"><br><br>
		<button type="submit">입력</button>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button class="reset_btn" type="reset">취소</button>
	</form>
</body>
</html>