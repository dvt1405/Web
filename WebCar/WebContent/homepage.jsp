<%@page import="model.User"%>
<%@page import="DAO.UserDAO"%>
<%@page import="model.entity"%>
<%@page import="DAO.BrandDAO"%>
<%@page import="model.Brand"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Auto Car</title>
<!-- ---------------------c s s---------------------------- -->
<link rel="stylesheet" type="text/css" href="./HomePage.css">
<link rel="stylesheet" href="./header.css">
<link rel="stylesheet" href="./footer.css">
<!-- ---------------------Icons---------------------- -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Web Car</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="body">
		<%
			ArrayList<entity> listBrand = new BrandDAO().selectAll();
			for (int i = 0; i < listBrand.size(); i++) {
				Brand b = new Brand();
				b = (Brand) listBrand.get(i);
		%>

		<div class="showroom" id="Ducati">
			<a href="productServlet/login"> <img src="<%=b.getAvatar()%>" alt="">
				<div class="text-block">
					<h4><%=b.getShortName() %></h4>
					<p><%=b.getShortName() %> is a brand of top the most favorite car's brand in the world!</p>
					<p>Headquarter: <%=b.getHeadQuater() %></p>
				</div>
				<div class="carDetail">
					<p class="text"><%=b.getName()%></p>
				</div>
			</a>
		</div>

		<%
			}
		%>

	</div>



	<%@include file="footer.jsp"%>>
</body>
</html>