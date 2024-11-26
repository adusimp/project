package com.WebPhone.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebPhone.dao.ProductDao;

@WebServlet(urlPatterns = {"/admin-product"})
public class ProductController extends HttpServlet {
	ProductDao productDao = new ProductDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String route = req.getParameter("route");
		if(route==null)
			route="sp";
		if(route.equals("sua")) {
			int id_sp =Integer.parseInt(req.getParameter("id_sp")) ;
			
			req.setAttribute("route", route);
			req.setAttribute("product",productDao.getProductById(id_sp));
			req.getRequestDispatcher("views/admin/index.jsp").forward(req, resp);
		}else if(route.equals("sp")) {
			
			req.setAttribute("productList", productDao.getProducts());
			req.setAttribute("route", "sp");
			
			RequestDispatcher rd = req.getRequestDispatcher("views/admin/index.jsp");
			rd.forward(req, resp);
		}
		else if(route.equals("them")) {
			req.setAttribute("route", "them");
			RequestDispatcher rd = req.getRequestDispatcher("views/admin/index.jsp");
			rd.forward(req, resp);
		}else if(route.equals("xoa")) {
			
			int id_sp = Integer.parseInt(req.getParameter("id_sp"));
			productDao.deleteProduct(id_sp);
			
			req.setAttribute("productList", productDao.getProducts());
			req.setAttribute("route", "sp");
			
			RequestDispatcher rd = req.getRequestDispatcher("views/admin/index.jsp");
			rd.forward(req, resp);
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String route = req.getParameter("route");
		if(route==null)
			route="sp";
		
		if(route.equals("them")) {
			String name = req.getParameter("name");
			String img = req.getParameter("img");
			String price = req.getParameter("price");
			int sl = Integer.parseInt(req.getParameter("sl"));
			String des = req.getParameter("des");
			int id_category = productDao.getIdCategoryByName(req.getParameter("name_category"));
			
			productDao.addProduct(name, img, price, sl, des, id_category);
			req.setAttribute("route", "sp");
			doGet(req, resp);
		}else if(route.equals("sua")) {
			
			int id_sp = Integer.parseInt(req.getParameter("id_sp"));
			String name = req.getParameter("name");
			String img = req.getParameter("img");
			String price = req.getParameter("price");
			int sl = Integer.parseInt(req.getParameter("sl"));
			String des = req.getParameter("des");
			String name_category = req.getParameter("category_name");
			productDao.updateProduct(id_sp, name, img, price, sl, des, name_category);
			
			req.setAttribute("route", "sp");
			req.setAttribute("productList", productDao.getProducts());
			req.getRequestDispatcher("views/admin/index.jsp").forward(req, resp);
			
		}
		
	}

}
