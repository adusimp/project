<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="flex items-center justify-center min-h-screen bg-gray-100">
<% String message = (String) request.getAttribute("message");%>
		<% if (message == null) {
			message = "";
		}%>
    <div class="bg-white p-8 rounded-lg shadow-md w-full max-w-sm">
        <h1 class="text-3xl font-bold mb-2">Login</h1>
        <p class="text-gray-600 mb-6">to get started</p>
        <form action="<%=request.getContextPath()%>/sign-in" method = "post">
            <div class="mb-4">
                <input type="text" name="username" placeholder="username" class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>
            <div class="mb-4">
                <input type="password" name="password" placeholder="Password" class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>
            <div class="mb-6 text-right">
                <a href="#" class="text-gray-600">Forgot Password?</a>
            </div>
            <button type="submit" class="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700">Continue</button>
        </form>
        <div class="mt-6 text-center">
            <p class="text-red-600">${message }</p>
        </div>
        <div class="mt-6 text-center">
            <p class="text-gray-600">New User? <a href="<%=request.getContextPath()%>/sign-up" class="text-black font-bold">Register</a></p>
        </div>
    </div>
</body>
</html>