<%@page import="model.Car"%>
<%@page import="java.util.List"%>
<%@page import="DAO.BrandDAO"%>
<%@page import="model.Brand"%>
<%@page import="DAO.UserDAO"%>
<%@page import="model.entity"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Products</title>
<!-- ---------------------Css---------------------------- -->
<link rel="stylesheet" type="text/css" href="./HomePage.css">
<link rel="stylesheet" href="./header.css">
<link rel="stylesheet" href="./footer.css">
<link rel="stylesheet" href="product.css">
<!-- ---------------------Icons---------------------- -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<%
		ArrayList<Car> listCar = (ArrayList<Car>) request.getAttribute("list");
	%>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="body_products">
		<div class="container-searchbox">
			<div class="search-products">
				<div>
					<p>
						<select name="Choose a brand" id="">
							<option class="product-name">BMW></option>
						</select>

					</p>
				</div>
				<div>
					<p>
						<select name="Choose a car" id="" disabled="disabled">
							<option value="">BMW i10</option>
							<option value="">BMW i9</option>
							<option value="">BMW i8</option>
							<option value="">BMW i7</option>
							<option value="">BMW i6</option>
							<option value="">BMW i5</option>
						</select>
					</p>

				</div>
				<div>
					<p>
						<select name="Choose a brand" id="">
							<option value="">Under 1000$</option>
							<option value="">1000$ - 2000$</option>
							<option value="">2000$ - 3000$</option>
							<option value="">4000$ - 5000$</option>
							<option value="">More than 5000$</option>
						</select>
					</p>

				</div>
				<button onclick="onclick()">Filter</button>

			</div>
		</div>

		<div class="list-products">
			<div class="row-products">
				<%
					for (int i = 0; i < listCar.size(); i++) {
				%>
				
				<div class="product-card">
				<a class="tu" href="productServlet/login">
					<img src="<%=listCar.get(i).getImage()%>" alt="Product">
					<div class="product-name" id='<%=listCar.get(i).getId()%>'><%=listCar.get(i).getName()%></div>
				</a>
				</div>

				<%
					}
				%>
			</div>
		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		function onclick() {
			alert("Click")
		}
	</script>
</body>
</html>