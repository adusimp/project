package com.WebPhone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebPhone.dao.ProductDao;

@WebServlet(urlPatterns = {"/home-page"})
public class HomeController extends HttpServlet {
	ProductDao productDao = new ProductDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String route = req.getParameter("route");
		String user = req.getParameter("user");
		if(user==null)
			user="";
		if(route== null)
			route="sp";
		if(route.equals("sp")) {
			req.setAttribute("categoryList", productDao.getCategory());
			req.setAttribute("productList", productDao.getProducts());
			req.setAttribute("user", user);
			req.setAttribute("route", route);
			req.getRequestDispatcher("views/web/index.jsp").forward(req, resp);
		}else if(route.equals("sp_ct")) {
			int id_sp = Integer.parseInt(req.getParameter("id_sp"));
			req.setAttribute("product", productDao.getProductById(id_sp));
			req.setAttribute("route", route);
			req.setAttribute("user", user);
			req.getRequestDispatcher("views/web/index.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
