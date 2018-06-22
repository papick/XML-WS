package XMLWS.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.model.User;
import XMLWS.service.UserService;

@RestController
@RequestMapping(value="/api")
public class ClientController {
	
	@Autowired
	private UserService userService;

	@PostMapping(value="/login", consumes="application/json" )
	public ResponseEntity<User> login(@RequestBody User logUser, HttpSession session){
		User user = userService.getUser(logUser.getUsername());
		if(user == null || !logUser.getPassword().equals(user.getPassword())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		System.out.println(user.getUsername());
		session.setAttribute("loggedUser", user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PostMapping(value="/register", consumes="application/json" )
	public ResponseEntity<Void> register(@RequestBody User user){
		System.out.println("registrovan");
		userService.addUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="/logout", consumes="application/json" )
	public ResponseEntity<Void> register(HttpSession session){
		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
