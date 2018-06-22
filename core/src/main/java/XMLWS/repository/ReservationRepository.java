package XMLWS.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import XMLWS.model.Reservation;
import XMLWS.model.User;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{
	public List<Reservation> findByUserId(Long Id);
	public List<Reservation> findByUser(User user);
	
}
