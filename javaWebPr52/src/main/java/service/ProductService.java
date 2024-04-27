package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Product;
import model.User;
import config.Connect;

public class ProductService {
	public static ArrayList<Product> findAll(){
		ArrayList<Product> products = new ArrayList<Product>();
		
		
		try {
			Connection connection = Connect.openConnect();
			
			ResultSet rs = connection.createStatement().executeQuery("select*from products");
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				products.add(product);
			}
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return products;
	}
	
public static Product findById(int id){
		
		Product product = new Product();

		try {
			Connection connection = Connect.openConnect();
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from products where id = ?");
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}
	
	public static void save(Product product) {
		try {
			Connection connection = Connect.openConnect();
//			connection.createStatement().execute("insert into 'products' ('name','price') values (' "
//					+ product.getName() +"','" + product.getPrice());
			
			PreparedStatement preparedStatement = 
					connection.prepareStatement("insert into `products`(`name`, `price`) values (?,?)");
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void update(Product product) {
		try {
			Connection connection = Connect.openConnect();	
			PreparedStatement preparedStatement = 
			connection.prepareStatement("UPDATE `products` SET `name` = ?, `price` = ? WHERE `id`= ?");
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setInt(3, product.getId());
			System.out.println("đã cập nhật");
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void delete(int id) {
		try {
			Connection connection = Connect.openConnect();	
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE id = ?");
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Product> search(String name){
		ArrayList<Product> products = new ArrayList<Product>();
		
		
		try {
			Connection connection = Connect.openConnect();
			ResultSet rs = connection.createStatement().executeQuery("Select * FROM products WHERE name like '%"+ name +"%'");
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				products.add(product);
			}
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return products;
	}
	

		public static ArrayList<Product> searchname(int id){
			ArrayList<Product> products = new ArrayList<Product>();
			
			
			try {
				Connection connection = Connect.openConnect();
				
				ResultSet rs = connection.createStatement().executeQuery("select*from products where category_id = "+id+"");
				
				while (rs.next()) {
					Product product = new Product();
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getDouble("price"));
					products.add(product);
				}
				connection.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return products;
		}
		
		public static void afterInsert() {
			try {
				Connection connection = Connect.openConnect();	
				PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products JOIN categories ON LEFT(products.name,LENGTH(categories.nameProduct)) = categories.nameProduct SET products.category_id = categories.id WHERE products.id > 0;");
				
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}