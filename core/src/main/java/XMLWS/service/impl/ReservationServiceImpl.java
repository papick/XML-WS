package XMLWS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.Reservation;
import XMLWS.repository.ReservationRepository;
import XMLWS.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public void addReservation(Reservation reservation) {
		reservationRepository.save(reservation);
	}

	@Override
	public void removeReservation(Long id) {
		reservationRepository.delete(id);
	}

	@Override
	public void updateReservation(Reservation reservation) {
		reservationRepository.save(reservation);	
	}

	@Override
	public Reservation getReservation(Long id) {
		
		return reservationRepository.findOne(id);
	}

	@Override
	public List<Reservation> getReservationByUser(Long userId) {
		return reservationRepository.findByUserId(userId);
	}

	@Override
	public List<Reservation> getAllReservation() {
		List<Reservation> reservations = new ArrayList<>();
		reservationRepository.findAll().forEach(reservations::add);
		return reservations;
	}

}
