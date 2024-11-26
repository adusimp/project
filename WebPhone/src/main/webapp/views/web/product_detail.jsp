<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "/common/taglib.jsp" %>
<div class="grid grid-cols-2 bg-gray-100 m-0 md:m-10">
        <div class="w-full items-center justify-center">
            <img class="w-full p-10" src="${product.img }" alt="">       
        </div>
        <div class="p-10">
            <p class="text-3xl font-bold pb-5">${product.name }</p>
            <div class="flex pb-2">
                <i class='bx bxs-star text-[#ffc107]'></i>
                <i class='bx bxs-star text-[#ffc107]'></i>
                <i class='bx bxs-star'></i>
                <i class='bx bxs-star'></i>
            </div>
            <p class="text-sm pb-5">999 reviews</p>
            <div class="flex gap-x-4 text-3xl font-semibold pb-5">
                <p>GIÁ HIỆN TẠI:</p>
                <p class="text-[#ffc107]">${product.price }</p>
            </div>
            <div class="flex gap-x-4 pb-5">
                <p class="font-semibold">Số lượng đặt mua</p>
                <input type="text" name="" id="" class="border-2 rounded-lg">
            </div>
            <button class="px-4 py-2 bg-[#ffc107] rounded-lg text-white">Thêm vào giỏ hàng</button>
        </div>
    </div>
    <hr>
    <div class="bg-gray-100 p-5 m-0 md:m-10">
        <p class="text-3xl font-semibold pb-5">Thông tin về chi tiết sản phẩm</p>
        <p>${product.des }</p>
    </div>