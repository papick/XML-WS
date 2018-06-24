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

import XMLWS.dto.ResDTO;
import XMLWS.model.Accommodation;
import XMLWS.model.Agent;
import XMLWS.model.Period;
import XMLWS.model.Reservation;
import XMLWS.model.ReservationAgent;
import XMLWS.model.User;
import XMLWS.repository.AccomodationRepository;
import XMLWS.repository.AgentRepository;
import XMLWS.repository.PeriodRepository;
import XMLWS.repository.ReservationAgentRepository;
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

	@Autowired
	private ReservationAgentRepository reservationAgentRepository;

	@Autowired
	private AgentRepository agentRepository;

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

	@Autowired
	private AccomodationRepository accR;
	
	@Autowired
	private PeriodRepository pr;
	@PostMapping("/new")
	public ResponseEntity<Reservation> newReservation(@RequestBody ResDTO reservation) {
		/*
		 * User user = (User)session.getAttribute("loggedUser"); if(user ==
		 * null) { return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); }
		 */
	/*	if (reservation.getPeriod() == null || reservation.isConfirmed()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		// check avaibility!!! TODO
		List<Period> allPeriods = periodService
				.getAllPeriodsByAccomodation(reservation.getPeriod().getAccomodation().getId());

		Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = Date.valueOf(reservation.getPeriod().getFromDate());
			toDate = Date.valueOf(reservation.getPeriod().getToDate());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		for (Period period : allPeriods) {
			Date from = Date.valueOf(period.getFromDate());
			Date to = Date.valueOf(period.getToDate());
			if (fromDate.compareTo(to) <= 0 && toDate.compareTo(from) >= 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}*/
		
		Period p = new Period();
		p.setFromDate(reservation.getFromDate());
		p.setToDate(reservation.getToDate());
		Accommodation acc = accR.findOne(Long.parseLong(reservation.getIdAccomodation()));
		p.setAccomodation(acc);
		pr.save(p);
		

		Reservation r = new Reservation();
		User user = userRepository.findByUsername(reservation.getUsername());
		r.setUser(user);
		r.setPeriod(p);
		r.setConfirmed(false);
	//	Period period = periodService.addPeriod(reservation.getPeriod());
		System.out.println(
				"aaaaaaa" + p.getAccomodation().getName() + p.getAccomodation().getAgent().getUsername());
		//reservation.setPeriod(period);
		//Reservation newReservation = service.addReservation(reservation);

		reservationRepository.save(r);
		  ReservationAgent resAgent = new ReservationAgent();
		  resAgent.setReservation(r);
		  resAgent.setAgent(p.getAccomodation().getAgent());
		  reservationAgentRepository.save(resAgent);
		  
		 

		return new ResponseEntity<Reservation>(r, HttpStatus.CREATED);
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
