package XMLWS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import XMLWS.model.Reservation;

@Service
public interface ReservationService {
	public void addReservation(Reservation reservation);
	public void removeReservation(Long id);
	public void updateReservation(Reservation reservation);
	public Reservation getReservation(Long id);
	public List<Reservation> getReservationByUser(Long userID);
	public List<Reservation> getAllReservation();
}
