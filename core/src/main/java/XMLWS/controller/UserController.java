package XMLWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		for(User u:activeUsers){
			System.out.println(u.getUsername());
		}

		return new ResponseEntity<List<User>>(activeUsers, HttpStatus.OK);
	}
	
	@GetMapping("/get-blocked-users")
	public ResponseEntity<List<User>> getBlockedUsers() {
		
		List<User> blockedUsers = us.getBlocked();

		return new ResponseEntity<List<User>>(blockedUsers, HttpStatus.OK);
	}

}