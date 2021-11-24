<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css">
<script type="text/javascript" src="/webjars/jquery/2.1.3/dist/jquery.min.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
	<%@ page import="java.io.*" %>
	<%@ page import="java.net.*" %>
	<%
		StringBuffer stringBuffer=new StringBuffer();
		String jsonString=null;
		
		String apiUrl="https://api.themoviedb.org/3/movie/"
				+"370172?"
				+"api_key=68ec3922f6c79f2f0574d8af0cce9fa8&language=KO";
		URL url=new URL(apiUrl);
		HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
		urlConnection.connect();
		BufferedInputStream bis=new BufferedInputStream(urlConnection.getInputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(bis, "UTF-8"));
		String result;
		while((result=br.readLine())!=null) {
			stringBuffer.append(result);
		}
		
		jsonString=stringBuffer.toString();
		
		int overviewStart=jsonString.indexOf("overview");
		int overviewEnd=jsonString.indexOf("popularity");
		String overview=jsonString.substring(overviewStart+11, overviewEnd-3);
		
		int titleStart=jsonString.indexOf("\"title");
		int titleEnd=jsonString.lastIndexOf("video");
		String title=jsonString.substring(titleStart+9, titleEnd-3);
		
		int posterStart=jsonString.indexOf("poster_path", overviewEnd);
		int posterEnd=jsonString.indexOf("production_companies");
		String poster=jsonString.substring(posterStart+14, posterEnd-3);
		
		//System.out.println(overview);
		//System.out.println(title);	
		//System.out.println(poster);
	%>
	
	<%
		String imageUrl="https://image.tmdb.org/t/p/original"
			+poster;
	%>
<meta charset="EUC-KR">
<title><%=title %></title>
<style rel="stylesheet" type="text/css">
	*{
		margin: 0px auto;
		padding: 0px;
		width: 1200px;
	}
	.movieDetail{
		background-color: yellow;
		height: 550px;
		overflow: hidden;
	}
	.topBlank{
		margin: 0px;
		padding: 0px;
		height: 50px;
	}
	.posterImg{
		height: 450x;
		width: 300px;
		float: left;
		clear: both;
		margin-right: 30px;
	}
	.title{
		margin-top: 20px;
		margin-bottom: 50px;
	}
</style>
</head>
<body>
	<div class="movieDetail">
		<div class="topBlank"></div>
		<img class="posterImg" alt="poster" src="<%=imageUrl%>">
		<h2 class="title"><%=title %></h2>
		<h2>개요</h2>
		<p class="overview"><%=overview %></p>
	</div>
	<form action="/detail/update_action" method="post" >
		<textarea name="detailcontent" rows="8" style="resize: none;">${detailOne.detailcontent }</textarea>
		<input type="hidden" name="detailno" value="${detailOne.detailno }">
		<button type="submit" style="width: 80px; height: 40px; float: right; clear: both;">입 력</button>
	</form>
	<c:forEach items="${detailList }" var="bean">
		<table class="table table-bordered">
			<tr>
				<td>${bean.detailid }</td>
				<td>${bean.detailnalja }</td>
			</tr>
			<tr>
				<td colspan="2">${bean.detailcontent }</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>