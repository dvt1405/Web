<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert product</title>
</head>
<body>
	<form action="addProductServlet" method="post">
		<div style="flex-direction: row">
			<p>
				Name: <input type="text" name="name">
		</div>
		<div style="flex-direction: row">
			<p>
				Description: <input type="text" name="description">
		</div>
		<div style="flex-direction: row">
			<p>
				Price ($): <input type="number" name="price">
		</div>
		<div style="flex-direction: row">
			<p>
				UrlImage: <input type="text" name="urlImage">
		</div>

		<input type="submit" value="OK">
	</form>
</body>
</html>