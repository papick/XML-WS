package XMLWS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import XMLWS.model.User;
import XMLWS.repository.UserRepository;
import XMLWS.service.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User getUser(Long id) {
		return userRepo.findOne(id);
	}

	@Override
	public User editUser(User user,Long id) {
		User edited = userRepo.findOne(id);
		edited.setEmail(user.getEmail());
		edited.setPassword(user.getPassword());
		edited.setUsername(user.getUsername());
		return userRepo.save(edited);
	}

	@Override
	public void deleteUser(Long id) {
		User userForDeleting = userRepo.findOne(id);
		userRepo.delete(userForDeleting);
	}

}
