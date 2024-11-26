<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/taglib.jsp" %>

<div class="p-4 sm:ml-64">
<a href="<%=request.getContextPath() %>/admin-product?route=them">thêm</a>
        <table border="1" class="w-[100%] text-center">
             <tr class="bg-blue-100">
                 <td class="">Ten</td>
                 <td>Hình ảnh</td>
                 <td>Giá</td>
                 <td>Số lượng</td>
                 <td>Mô tả</td>
                 <td colspan="2"></td>
             </tr>
             <c:forEach var = "product" items ="${productList }">
             	<tr class="border-b">
                 <td>${product.name}</td>
                 <td>
                    <div class="w-full">
                        <img class="w-20 mx-auto size-20" src="${product.img }" alt="">
                    </div>
                 </td>
                 <td>${product.price }</td>
                 <td>${product.sl }</td>
                 <td>${product.des}</td>
                 <td><a href="<%=request.getContextPath() %>/admin-product?route=sua&id_sp=${product.id}">sửa</a></td>
                 <td><a href="<%=request.getContextPath() %>/admin-product?route=xoa&id_sp=${product.id}">xóa</a></td>
             </tr>
             	
             </c:forEach>
        </table>   
     </div>