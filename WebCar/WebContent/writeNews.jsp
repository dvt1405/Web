<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="writeNewsServlet" method="post">
		<div style="flex-direction: row">
			<p>
				Title: <input type="text" name="title">
		</div>
		<div style="flex-direction: row">
			<p>
				Content: <input type="text" name="content" height="100px" multiple="multiple">
				
		</div>
		<div style="flex-direction: row">
			<p>
				UrlImage: <input type="text" name="urlImage">
		</div>

		<input type="submit" value="OK">
	</form>
</body>
</html>