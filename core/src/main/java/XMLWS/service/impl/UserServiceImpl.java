package XMLWS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.User;
import XMLWS.repository.UserRepository;
import XMLWS.service.UserService;

@Service
public class UserServiceImpl implements UserService {

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
	public User editUser(User user, Long id) {
		User edited = userRepo.findOne(id);
		edited.setEmail(user.getEmail());
		edited.setPassword(user.getPassword());
		edited.setUsername(user.getUsername());
		edited.setActive(user.isActive());
		return userRepo.save(edited);
	}

	@Override
	public void deleteUser(Long id) {
		User userForDelete = userRepo.findOne(id);
		if (userForDelete == null) {
			throw new IllegalArgumentException("Tried to delete non-existant user");
		}
		userRepo.delete(userForDelete);
	}

	@Override
	public User addUser(User u) {
		User newUser = new User();
		newUser.setEmail(u.getEmail());
		newUser.setPassword(u.getPassword());
		newUser.setUsername(u.getUsername());
		newUser.setActive(true);
		return userRepo.save(newUser);
	}

	@Override
	public void blockUser(Long id) {
		User u = userRepo.findOne(id);
		if (u.isActive() == true) {
			u.setActive(false);
		}
	}

	@Override
	public void activateUser(Long id) {
		User u = userRepo.findOne(id);
		if (u.isActive() == false) {
			u.setActive(true);
		}
	}

	@Override
	public List<User> getActive() {
		List<User> activeUsers = new ArrayList<User>();
		List<User> users = this.getAllUsers();

		for (User u : users) {
			if (u.isActive() == true) {
				activeUsers.add(u);
			}
		}

		return activeUsers;
	}

	@Override
	public List<User> getBlocked() {
		List<User> blockedUsers = new ArrayList<User>();
		List<User> users = this.getAllUsers();

		for (User u : users) {
			if (u.isActive() == false) {
				blockedUsers.add(u);
			}
		}

		return blockedUsers;
	}
}