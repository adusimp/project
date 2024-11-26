package com.WebPhone.dao;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.WebPhone.model.Category;
import com.WebPhone.model.Product;

public class ProductDao {
	
	Connection con=null;
	Statement st=null;
	
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb", "root", "moichoigame2");
			st = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Lấy danh sách sản phẩm
	public ArrayList<Product> getProducts() {
		ArrayList<Product> productList = new ArrayList();
		try {
			Statement sts = con.createStatement();
			ResultSet rs = sts.executeQuery("select *from products");
			ResultSetMetaData rsmd = rs.getMetaData();
			int col = rsmd.getColumnCount();
			while(rs.next()) {
				Product product = new Product();
				
				product.setId(Integer.parseInt(rs.getString(1)));
				product.setName(rs.getString(2));
				product.setImg(rs.getString(3));
				product.setPrice(rs.getString(4));
				product.setSl(Integer.parseInt(rs.getString(5)));
				product.setDes(rs.getString(6));
			
				productList.add(product);
				
					
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
		
	}
	//lấy id bằng tên của category
	public int getIdCategoryByName(String name) {
		int id =0;
		try {
			
			ResultSet rs = st.executeQuery("select categories.id_category from categories where name_category ='"+name+"'");
			rs.next();
			id=Integer.parseInt(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id ;
	}
	//Thêm 1 sản phẩm vào bảng
	public void addProduct(String name,String img,String price,int sl,String des,int id_category) {
		PreparedStatement pst = null;
		try {
			
			pst= con.prepareStatement("insert into products value( null,?,?,?,?,?,?)");
			pst.setString(1,name);
			pst.setString(2,"img/"+img);
			pst.setString(3,price);
			pst.setInt(4,sl);
			pst.setString(5,des);
			pst.setInt(6,id_category);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(img);
			System.out.println(pst);
		}
	}
	//Lấy một sản phẩm bằng id
	public Product getProductById(int id) {
		
		Product p = new Product();
		try {
			ResultSet rs = st.executeQuery("select*from products where id_product="+id);
			rs.next();
			p.setId(Integer.parseInt(rs.getString(1)));
			p.setName(rs.getString(2));
			p.setImg(rs.getString(3));
			p.setPrice(rs.getString(4));
			p.setSl(Integer.parseInt(rs.getString(5)));
			p.setDes(rs.getString(6));
			p.setCategory(getCategoryNameById(Integer.parseInt(rs.getString(7)))); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
	//Lấy tên bằng id của category
	public String getCategoryNameById(int id) {
		
		String name = "";
		try {
			
			ResultSet rs = st.executeQuery("select name_category from categories where id_category="+id);
			rs.next();
			name =rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	}
	//Sửa 1 sản phẩm
	public void updateProduct(int id_sp,String name,String img,String price,int sl,String des,String name_category) {
		PreparedStatement pst=null;
		String sql ="Update products "
					+"set name_product =?,"
					+ "img_product=?,"
					+ "price_product=?,"
					+ "sl_product=?,"
					+"des_product=?,"
					+"id_category=? "
					+"where id_product=?"
				;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, "img/"+img);
			pst.setString(3, price);
			pst.setInt(4,sl);
			pst.setString(5, des);
			pst.setInt(6, getIdCategoryByName(name_category));
			pst.setInt(7, id_sp);
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(pst);
		}
		
	}
	//Xóa 1 sản phẩm 
	public void deleteProduct(int id_sp) {
		try {
			st.execute("delete from products where id_product = "+id_sp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Lấy id và tên của category
	public ArrayList<Category> getCategory() {
		ArrayList<Category> cate = new ArrayList<>();
		try {
			ResultSet rs = st.executeQuery("select*from categories");
			while(rs.next()) {
				Category category = new Category();
				category.setId(Integer.parseInt(rs.getString(1)));
				category.setName(rs.getString(2));
				cate.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(st);
			e.printStackTrace();
		}
		return cate;
	}
	
}
