package com.WebPhone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao {
	Connection con;
	Statement st;
	
	public UserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb", "root", "moichoigame2");
			st = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addUser(String username, String password) {
		try {
			st.execute("insert into users (username,password) values('"+username+"','"+password+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(st);
		}
		
	}
	public ArrayList<String> login(String username){
		ArrayList<String> user = new ArrayList<>();
		try {
			ResultSet rs = st.executeQuery("select*from users where username='"+username+"'");
			rs.next();
			user.add(rs.getString(2));
			user.add(rs.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("select*from users where username="+username);
			e.printStackTrace();
		}
		return user;
	}
}
