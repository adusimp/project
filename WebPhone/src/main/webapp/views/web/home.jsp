<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "/common/taglib.jsp" %>
    <div class="flex w-[100%] py-5">
        <div class="w-[20%] pl-5">
            <p class="font-semibold text-2xl pb-5">Category</p>
            <ul>
            	<c:forEach var="category" items="${categoryList}" >
            		<li>
                    	<a href="">${category.name}</a>
                	</li>
            	</c:forEach>
                
               
            </ul>
        </div>
        <div class="w-[80%] grid sm:grid-cols-1 md:grid-cols-2 lg:grid-cols-5 gap-3">
        	<c:forEach var="product" items="${productList}" >
        		<div class="card text-center border-2 rounded-md">
                	<a href="<%=request.getContextPath()%>/home-page?route=sp_ct&id_sp=${product.id}">
                    	<img src="${product.img }" alt="">
                    	<p class="font-semibold text-[20px]">${product.name }</p>
                    	<p>${product.price }</p>
                	</a>
                	<div class="flex gap-3 p-3 w-full justify-center">
                    	<button class="bg-[#ffc107] text-white p-2 rounded-md hover:scale-105">Thêm giỏ hàng</button>
                	</div>
            	</div>   
        	</c:forEach>
             
           
            
        </div>
    </div>