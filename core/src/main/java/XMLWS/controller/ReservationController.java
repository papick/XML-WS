package XMLWS.controller;

import java.sql.Date;
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
import XMLWS.repository.ReservationRepository;
import XMLWS.repository.UserRepository;
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

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@GetMapping
	public ResponseEntity<List<Reservation>> getAllReservationsByUser(HttpSession session) {
		User user = (User) session.getAttribute("loggedUser");
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		List<Reservation> reservations = service.getReservationByUser(user.getId());
		return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
	}

	@GetMapping("/user/{username}")
	public ResponseEntity<List<Reservation>> getReservationByUser(@PathVariable String username) {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		List<Reservation> reservations = reservationRepository.findByUser(user);
		return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Reservation> newReservation(@RequestBody Reservation reservation, HttpSession session) {
		/*
		 * User user = (User)session.getAttribute("loggedUser"); if(user ==
		 * null) { return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); }
		 */
		if (reservation.getPeriod() == null || reservation.isConfirmed()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		// check avaibility!!! TODO
		List<Period> allPeriods = periodService.getAllPeriodsByAccomodation(reservation.getPeriod().getAccomodation().getId());
	
		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = Date.valueOf(reservation.getPeriod().getFromDate());
		    toDate = Date.valueOf(reservation.getPeriod().getToDate());
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		for(Period period : allPeriods) {
			System.out.println("from : " + period.getFromDate() + " to : " + period.getToDate());
			Date from =  Date.valueOf(period.getFromDate());
			Date to =  Date.valueOf(period.getToDate());
			if( fromDate.compareTo(to) <= 0  &&  toDate.compareTo(from) >= 0 ) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		
		User user = userService.getUser(reservation.getUser().getUsername());
		reservation.setUser(user);
		Period period = periodService.addPeriod(reservation.getPeriod());
		reservation.setPeriod(period);
		Reservation newReservation = service.addReservation(reservation);
		return new ResponseEntity<Reservation>(newReservation, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> cancelReservation(@PathVariable Long id) {

		Reservation reservationDelete = service.getReservation(id);
		if (reservationDelete == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		service.removeReservation(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
