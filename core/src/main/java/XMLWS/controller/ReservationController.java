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

import XMLWS.model.Period;
import XMLWS.model.Reservation;
import XMLWS.model.User;
import XMLWS.service.PeriodService;
import XMLWS.service.ReservationService;
import XMLWS.service.UserService;

@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationController {

	
	@Autowired
	private ReservationService service;
	
	@Autowired 
	private PeriodService periodService;
	
	@Autowired 
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<Reservation>> getAllReservationsByUser(HttpSession session) {
		User user = (User)session.getAttribute("loggedUser");
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		List<Reservation> reservations = service.getReservationByUser(user.getId());
		return new ResponseEntity<List<Reservation>>(reservations,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Reservation>> getReservationByUser( @PathVariable Long id,HttpSession session) {
		User user = userService.getUser(id);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<Reservation> reservations = service.getReservationByUser(id);
		return new ResponseEntity<List<Reservation>>(reservations,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Reservation> newReservation(@RequestBody Reservation reservation,HttpSession session) {
		/*User user = (User)session.getAttribute("loggedUser");
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}*/
		if(reservation.getPeriod() == null || reservation.isConfirmed()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		//check avaibility!!! TODO
		User user = userService.getUser(reservation.getUser().getUsername());
		reservation.setUser(user);
		Period period = periodService.addPeriod(reservation.getPeriod());
		reservation.setPeriod(period);
		Reservation newReservation = service.addReservation(reservation);
		return new ResponseEntity<Reservation>(newReservation, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> cancelReservation(@PathVariable Long id,HttpSession session) {
		User user = (User)session.getAttribute("loggedUser");
		Reservation reservationDelete = service.getReservation(id);
		if(reservationDelete == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(user == null || reservationDelete.getUser().getUsername().equals(user.getUsername())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		service.removeReservation(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
