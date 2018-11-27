<%@page import="model.News"%>
<%@page import="model.entity"%>
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
<link rel="stylesheet" type="text/css" href="./HomePage.css">
<link rel="stylesheet" href="./header.css">
<link rel="stylesheet" href="./footer.css">
<link rel="stylesheet" href="./news.css">
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="news">
		<div class="body-news">
			<div class="filter-news">
				<div>
					<h1>News</h1>
				</div>
				<div class="filter-btns">
					<button class="btn">Latest</button>
					<button class="btn">Top views</button>
					<button class="btn">Hot</button>
				</div>
			</div>
			<div class="header-news">
				<div class="test"></div>
				<div class="big-news">
					<!-- <img src="./IMG/backgroundCar4.PNG" alt=""> -->
					<div class="big-news-detail">
						<!-- <span>On each category you can set a Category template style</span>
                        <p>Sep 10 2018</p> -->
					</div>
				</div>
				<div class="top-news">
					<div class=""></div>
					<div class=""></div>
					<div class=""></div>
					<div class=""></div>
				</div>
			</div>
			<div class="list-news">
				<div class="list-right">
					<%
						ArrayList<News> listNews = (ArrayList<News>) request.getAttribute("listNews");
						if (listNews != null) {
							for (int i = 0; i < 5; i++) {
					%>
					<div class="column-list">
						<div><span><%=listNews.get(2*i).getTitle() %></span></div>
						<div><span><%=listNews.get(2*i +1).getTitle() %></span></div>
					</div>
					<%
						}
						}
					%>
				

				</div>
				
				<div class="list-left"></div>

			</div>
			<div class="number-page">
				
				<div class="number-page-left">
					<button><</button>
					<button>1</button>
					<button>2</button>
					<button>3</button>
					<button>></button>
				</div>
				<div class="number-page-right">
					<button>1</button>
					<button>2</button>
					<button>3</button>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>