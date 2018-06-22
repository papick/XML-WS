package XMLWS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.Period;
import XMLWS.model.Reservation;
import XMLWS.repository.PeriodRepository;
import XMLWS.repository.ReservationRepository;
import XMLWS.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private PeriodRepository periodRepository;

	@Override
	public Reservation addReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public void removeReservation(Long id) {
		Reservation reservation = reservationRepository.findOne(id);
		Period period = reservation.getPeriod();

		reservationRepository.delete(id);
		periodRepository.delete(period);
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
