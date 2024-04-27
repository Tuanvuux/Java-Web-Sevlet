package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.Connect;
import model.Product;
import model.User;

public class UserService {
	public static User findByUsernameAndPassword(String username,String password){
		User user;
		try {
			Connection connection = Connect.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * FROM users WHERE username = ? and password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs =preparedStatement.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("username"));;
				user.setPassword(rs.getString("password"));
				return user;
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public static void register(User user) {
		try {
			Connection connection = Connect.openConnect();
//			connection.createStatement().execute("insert into 'products' ('name','price') values (' "
//					+ product.getName() +"','" + product.getPrice());
			
			PreparedStatement preparedStatement = 
					connection.prepareStatement("insert into `users`(`username`, `password`) values (?,?)");
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static User checkByUsername(String username){
		User user;
		try {
			Connection connection = Connect.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * FROM users WHERE username = ?");
			preparedStatement.setString(1, username);
			ResultSet rs =preparedStatement.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("username"));;
				user.setPassword(rs.getString("password"));
				return user;
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	

}
