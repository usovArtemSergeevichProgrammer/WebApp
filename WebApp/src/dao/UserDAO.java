package dao;

import java.util.List;

import model.User;

public interface UserDAO {

	boolean createUser(User user);
	boolean deleteUser(User user);
	boolean updateUser(User user);
	User getUserByLogin(User user);
	List<User> getAllUsers();
	
}
