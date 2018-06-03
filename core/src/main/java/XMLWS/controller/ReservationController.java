package XMLWS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.model.Reservation;
import XMLWS.service.ReservationService;

@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationController {

	
	@Autowired
	private ReservationService service;
	@PostMapping()
	public ResponseEntity<Void> newReservation(@RequestBody Reservation reservation) {
		service.addReservation(reservation);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
