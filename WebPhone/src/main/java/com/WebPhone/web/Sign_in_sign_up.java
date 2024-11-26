package com.WebPhone.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebPhone.dao.UserDao;
import com.WebPhone.model.User;

@WebServlet(urlPatterns = {"/sign-in","/sign-up"})
public class Sign_in_sign_up extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getServletPath();
		if(url.equals("/sign-in"))
			req.getRequestDispatcher("views/web/login.jsp").forward(req, resp);
		else
			req.getRequestDispatcher("views/web/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getServletPath();
		if(url.equals("/sign-up")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String cf_password = req.getParameter("cf_password");
			if(password.equals(cf_password)) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				userDao.addUser(username, cf_password);
				req.getRequestDispatcher("views/web/login.jsp").forward(req, resp);
			}else {
				req.setAttribute("message", "mật khẩu và nhập lại mật khẩu không đúng");
				req.getRequestDispatcher("views/web/register.jsp").forward(req, resp);
			}
			
		}else if(url.equals("/sign-in")) {
			String username= req.getParameter("username");
			String password = req.getParameter("password");
			ArrayList<String> user = userDao.login(username);
			if(user.isEmpty()) {
				req.setAttribute("message", "tài khoản không tồn tại");
				req.getRequestDispatcher("views/web/login.jsp").forward(req, resp);
			}else {
				if(!user.get(1).equals(password)) {
					req.setAttribute("message", "mật khẩu không đúng");
					req.getRequestDispatcher("views/web/login.jsp").forward(req, resp);
				}else {
					req.setAttribute("user", user.get(0));
					
					
					resp.sendRedirect(req.getContextPath()+"/home-page?user="+user.get(0));
					
				}
			}
		}
	}
	
}
