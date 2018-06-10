package XMLWS.service;

import java.util.List;

import org.springframework.stereotype.Service;
import XMLWS.model.User;

@Service
public interface UserService {
	
	public List<User> getAllUsers();
	
	public User getUser(Long id);
	
	public User addUser(User u);
	
	public User editUser(User user,Long id);
	
	public void deleteUser(Long id);
	
	public void blockUser(Long id);
	
	public void activateUser(Long id);
	
	public List<User> getActive();
	
	public List<User> getBlocked();

}