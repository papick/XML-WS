package agent.resource;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.service.ReservationService;
import agent.service.dto.ReservationDTO;

@RestController
@RequestMapping(value = "/api/reservation")
public class ReservationResource {

	@Autowired
	private ReservationService reservationService;

	@PostMapping("/create-reservation")
	public void createReservation(@RequestBody ReservationDTO reservationDTO) throws ParseException {

		reservationService.create(reservationDTO);

	}

}
