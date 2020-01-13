package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.UserDAO;
import model.User;
import utils.JDBCUtils;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean createUser(User user) {
		Connection conn = JDBCUtils.getConnection();
		Statement stmt = null;
		try {
			conn.createStatement();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("INSERT INTO USERS.USER (NAME, PASSWORD, EMAIL) VALUES ('" + user.getName()
					+ "', '" + user.getPass() + "', '" + user.getEmail() + "');");
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
//		String sql = "DELETE FROM USERS.USER WHERE NAME='" + user.getName() + "'";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn.createStatement();
//			stmt = conn.createStatement();
//		
//			if (result == 1) {
//				return true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByLogin(User user) {
		String sql = "SELECT * FROM USERS.USER WHERE NAME=? AND PASSWORD=?";
		//UID, NAME, PASSWORD, EMAIL

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JDBCUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPass());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				User userFromDB = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				System.out.println("USER FOUND -> " + userFromDB);

				return userFromDB;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
		// User userResult = null;
		// Connection conn = JDBCUtils.getConnection();
		// Statement stmt = null;
		//
		// try {
		// //conn.createStatement();
		// stmt = conn.createStatement();
		// ResultSet rs = stmt.executeQuery("SELECT * FROM USERS.USER WHERE
		// NAME='" + user.getName() + "'");
		// if(rs.next()){
		// userResult = new User();
		// userResult.setId(rs.getInt("UID"));
		// userResult.setName(rs.getString("NAME"));
		// userResult.setPass(rs.getString("PASSWORD"));
		// userResult.setEmail(rs.getString("EMAIL"));
		// }else{
		// System.out.println("No such user found name in Table= " +
		// user.getName());
		// }
		// JDBCUtils.release(conn, stmt, null);
		//
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return userResult;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
