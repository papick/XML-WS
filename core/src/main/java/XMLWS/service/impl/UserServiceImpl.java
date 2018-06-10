package XMLWS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import XMLWS.model.User;
import XMLWS.repository.UserRepository;
import XMLWS.service.UserService;

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
		edited.setStatus(user.getStatus());
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
		newUser.setStatus("active");
		return userRepo.save(newUser);
	}

	@Override
	public void blockUser(Long id) {
		User u = userRepo.findOne(id);
		if (u.getStatus() == "active") {
			u.setStatus("blocked");
		}
	}

	@Override
	public void activateUser(Long id) {
		User u = userRepo.findOne(id);
		if (u.getStatus() == "blocked") {
			u.setStatus("active");

		}
	}

	@Override
	public List<User> getActive() {
		List<User> activeUsers = new ArrayList<>();
		List<User> users = this.getAllUsers();

		for (User u : users) {
			if (u.getStatus() == "active") {
				activeUsers.add(u);
			}
		}

		return activeUsers;
	}

	@Override
	public List<User> getBlocked() {
		List<User> blockedUsers = new ArrayList<>();
		List<User> users = this.getAllUsers();

		for (User u : users) {
			if (u.getStatus() == "blocked") {
				blockedUsers.add(u);
			}
		}

		return blockedUsers;
	}
}