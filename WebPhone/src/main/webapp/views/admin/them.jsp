<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="p-4 sm:ml-64">
<form action="<%=request.getContextPath()%>/admin-product?route=them" method="post">
    <table border="1">
        <tr>
            <td>Tên</td>
            <td><input type="text" name ="name"></td>
        </tr>
        <tr>
            <td>Hình ảnh</td>
            <td><input type="file" name ="img"></td>
        </tr>
        <tr>
            <td>Giá</td>
            <td><input type="text" name="price" ></td>
        </tr>
        <tr>
            <td>Số lượng</td>
            <td><input type="text" name ="sl"></td>
        </tr>
        <tr>
            <td>Mô tả</td>
            <td><input type="text" name ="des"></td>
        </tr>
        <tr>
            <td>Loại</td>
            <td><input type="text" name ="name_category"></td>
        </tr>
        <tr>
        	<td><input type="submit" ></td>
        </tr>
    </table>
</form>
</div>