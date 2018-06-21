package XMLWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.model.User;
import XMLWS.service.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@GetMapping("/get-active-users")
	public ResponseEntity<List<User>> getActiveUsers() {
		
		List<User> activeUsers = us.getActive();

		return new ResponseEntity<List<User>>(activeUsers, HttpStatus.OK);
	}
	
	@GetMapping("/get-blocked-users")
	public ResponseEntity<List<User>> getBlockedUsers() {
		
		List<User> blockedUsers = us.getBlocked();

		return new ResponseEntity<List<User>>(blockedUsers, HttpStatus.OK);
	}
	
	@GetMapping("/get-all-users")
	public ResponseEntity<List<User>> getAllUsers() {
		
		List<User> allUsers = us.getAllUsers();

		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}
	
	@PostMapping("/add-user")
	public ResponseEntity<User> addUser(@RequestBody User u) {

		User userForAdd = us.addUser(u);
		return new ResponseEntity<User>(userForAdd, HttpStatus.OK);
	}
	
	@PutMapping("/edit-user/{id}")
	public ResponseEntity<User> editUser(@PathVariable Long id,@RequestBody User u) {
		return new ResponseEntity<User>(us.editUser(u, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-user/{id}")
	public void deleteUser(@PathVariable Long id) {
		us.deleteUser(id);
	}
	
	@PutMapping("/activate-user/{id}")
	public void activateUser(@PathVariable Long id) {
		us.activateUser(id);
	}
	
	@PutMapping("/block-user/{id}")
	public void blockUser(@PathVariable Long id) {
		us.blockUser(id);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username) {
		
		User user = us.getUser(username);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}