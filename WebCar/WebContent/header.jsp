<%@page import="servlet.loginServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Auto Car</title>
<!-- ---------------------Css---------------------------- -->
<link rel="stylesheet" type="text/css" href="./HomePage.css">
<link rel="stylesheet" href="./header.css">
<link rel="stylesheet" href="./footer.css">
<!-- ---------------------Icons---------------------- -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="header">
		<div class="logo">
			<h1>
				<a href="/WebCar/">Auto Car</a>
			</h1>
		</div>
		<div id="myHomeMenu" class="myMenu">
			<a href="javascript:void(0)" class="closebtn" onclick="closeMenu()">
				&times; </a>
			<div class="myMenuContent">
				<a class="iconss" href="/WebCar/"> Home </a> 
				<a href="/WebCar/productServlet">Products</a> 
				<a href="/WebCar/newServlet">News</a> <a
					href="#Ducati">Contact</a>
			</div>
		</div>
		<a class="iconMenu" onclick="openMenu()"> &#9776; Menu </a>
	</div>
	<ul class="title">
		<li class="itemTitle"><a class="" href="/WebCar"> Home</a></li>
		<li class="itemTitle"><a class="" href="/WebCar/productServlet">Products</a>
		</li>
		<li class="itemTitle"><a href="/WebCar/newServlet">News</a></li>
		<li class="itemTitle"><a href=#Footer>Footer</a></li>
	</ul>
	<script>
		function openMenu() {
			document.getElementById("myHomeMenu").style.width = "30%";
			if (window.innerWidth <= 600) {
				document.getElementById("myHomeMenu").style.width = "100%";
			}
		}

		function closeMenu() {
			document.getElementById("myHomeMenu").style.width = "0%"
		}

		function gotoTest() {
			window.location.href = "./Web_Car.html";
		}
	</script>
</body>
</html>