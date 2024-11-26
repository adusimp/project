<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <script src="https://cdn.tailwindcss.com"></script>
    	<% String user = (String) request.getAttribute("user");%>
			<% if (user == null) {
			user = "";
		}%>
    
<script src="js/header.js"></script>
</head>
<body>
	<% String route = (String) request.getAttribute("route");%>
		<% if (route == null) {
			route = "sp";
		}%>
	    <header class="grid grid-cols-2 px-4 py-6 bg-[#ffc107] text-white">
        <div class="text-3xl">Web</div>
        <ul class="flex gap-3 justify-end items-center">
            <li>
                <a href="">Trang chủ</a>
            </li>
            <li>
                <a href="">Sản phẩm</a>
            </li>
            <li>
                <a href="">Giỏ hàng</a>
            </li>
            <li id="user" value="${user }" >
               <ul class="pt-6">
                	<li>${user }</li>
                	<li><a href="" >Đăng xuất</a></li>
               </ul>
            </li>
            <li id="login">
                <a href="<%=request.getContextPath()%>/sign-in">Đăng nhập</a>
            </li>
            
        </ul>
        <script src="js/header.js"></script>
    </header>
	<% if(route == "sp"){%>
 		<%@include file = "/views/web/home.jsp" %>
 	<%} %>
 	<% if(route.equals("sp_ct")){%>
 		<%@include file = "/views/web/product_detail.jsp" %>
 	<%} %>
	<p>${route }</p>
	<p>${user }</p>
</body>

</html>

