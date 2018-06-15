package XMLWS.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.model.Reservation;
import XMLWS.model.User;
import XMLWS.service.ReservationService;

@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationController {

	
	@Autowired
	private ReservationService service;
	
	@GetMapping("/user")
	public ResponseEntity<List<Reservation>> getAllReservationByUser(HttpSession session) {
		User user = (User)session.getAttribute("loggedUser");
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		List<Reservation> reservations = service.getReservationByUser(user.getId());
		return new ResponseEntity<List<Reservation>>(reservations,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reservation> getReservation( @PathVariable Long id) {
		Reservation reservation = service.getReservation(id);
		return new ResponseEntity<Reservation>(reservation,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Reservation> newReservation(@RequestBody Reservation reservation) {
		
		Reservation newReservation = service.addReservation(reservation);
		return new ResponseEntity<Reservation>(newReservation, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> cancelReservation(@PathVariable Long id) {
		service.removeReservation(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
