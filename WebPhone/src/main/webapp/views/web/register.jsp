<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="bg-white p-8 rounded-lg shadow-md w-full max-w-md">
        <h2 class="text-3xl font-bold mb-2">Signup</h2>
        <p class="text-gray-600 mb-6">to get started</p>
        <form action="<%=request.getContextPath() %>/sign-up" method="post" >
            <div class="mb-4">
                <input type="text" name="username" placeholder="Username" class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>

            <div class="mb-4">
                <input type="password" name="password" placeholder="Password" class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>
            <div class="mb-4">
                <input type="password" name="cf_password" placeholder="Confirm Password" class="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>
            
            <button type="submit" class="w-full bg-blue-600 text-white p-3 rounded-lg hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500">Continue</button>
        </form>
        <p class="text-center text-red-500 mt-6">${message }</p>
        <p class="text-center text-gray-600 mt-6">Already registered? <a href="<%=request.getContextPath()%>/sign-in" class="text-blue-600">Login</a></p>
    </div>
</body>
</html>