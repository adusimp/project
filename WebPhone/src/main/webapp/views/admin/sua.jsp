<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="p-4 sm:ml-64">
<form action="<%=request.getContextPath()%>/admin-product?route=sua" method="post" >
    <table border="1">
        <tr>
            <td>Tên</td>
            <td><input name="name" type="text" value="${product.name}" ></td>
        </tr>
        <tr>
            <td>Hình ảnh</td>
            <td> 
            	<div class="w-full">
                	<img class="w-20 mx-auto size-20" src="${product.img }" alt="">
            	</div>
                     </td>
            <td><input name="img" type="file" src="${product.img }" ></td>
        </tr>
        <tr>
            <td>Giá</td>
            <td><input name="price" type="text" value="${product.price}" ></td>
        </tr>
        <tr>
            <td>Số lượng</td>
            <td><input name="sl" type="text" value="${product.sl}"></td>
        </tr>
        <tr>
            <td>Mô tả</td>
            <td><input name="des" type="text" value="${product.des}"></td>
        </tr>
        <tr>
            <td>Loại</td>
            <td><input name="category_name" type="text" value="${product.category}"></td>
        </tr>
        	
        <tr>
        	<td> <input type="hidden" name="id_sp" value="${product.id}"  > </td>
        	<td><input type="submit" value="Sửa"  ></td>
        </tr>
    </table>
</form>
</div>