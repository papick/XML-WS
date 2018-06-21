package agent.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookingws.soap.AccomodationService;
import com.bookingws.soap.AccomodationServicePort;
import com.bookingws.soap.AddPeriodRequest;
import com.bookingws.soap.AddPeriodResponse;

import agent.model.Accommodation;
import agent.model.Period;
import agent.model.Reservation;
import agent.repository.AccomodationRepository;
import agent.repository.PeriodRepository;
import agent.repository.ReservationRepository;
import agent.service.dto.ReservationDTO;

@Transactional
@Service
public class ReservationService {

	@Autowired
	private PeriodRepository periodRepository;

	@Autowired
	private AccomodationRepository accomodationRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	public void create(ReservationDTO reservationDTO) throws ParseException {

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date fromDate = date.parse(reservationDTO.getFrom());

		java.util.Date toDate = date.parse(reservationDTO.getTo());

		String[] parse = reservationDTO.getAccomodation().split("/");
		String accomodationIdString = parse[0];
		Long accomodationId = Long.parseLong(accomodationIdString);
		Accommodation accomodation = accomodationRepository.findOne(accomodationId);

		ArrayList<Period> periods = (ArrayList<Period>) periodRepository.findByAccomodation(accomodation);

		boolean stop = false;
		for (int i = 0; i < periods.size(); i++) {

			java.util.Date fromPeriod = date.parse(periods.get(i).getFromDate());
			java.util.Date toPeriod = date.parse(periods.get(i).getToDate());

			if (fromDate.after(fromPeriod) && fromDate.before(toPeriod)) {
				throw new IllegalArgumentException("Period is busy !!!");
			} else if (toDate.after(fromPeriod) && toDate.before(toPeriod)) {
				throw new IllegalArgumentException("Period is busy !!!");
			} else if (stop == false) {

				Period period = new Period();

				period.setFromDate(reservationDTO.getFrom());
				period.setToDate(reservationDTO.getTo());

				period.setAccomodation(accomodation);

				periodRepository.save(period);
				stop = true;

			}
		}

		if (periods.isEmpty() == true)

		{
			Period period = new Period();

			period.setFromDate(reservationDTO.getFrom());
			period.setToDate(reservationDTO.getTo());

			period.setAccomodation(accomodation);

			periodRepository.save(period);
			
			AccomodationService accomodationService = new AccomodationService();
			AccomodationServicePort accomodationServicePort = accomodationService.getAccomodationServicePortSoap11();
			
			AddPeriodRequest request = new AddPeriodRequest();
			request.setPeriod(period);
			AddPeriodResponse response = accomodationServicePort.addPeriod(request);
			
			

		}
	}

	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	public void confirmeReservation(Long id) {
		Reservation reservation = reservationRepository.findOne(id);
		if(reservation == null){
			throw new IllegalArgumentException("No reservation !!!");
		}
		reservation.setConfirmed(true);
		reservationRepository.save(reservation);
	}

}
