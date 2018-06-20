package agent.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agent.model.Accommodation;
import agent.model.Period;
import agent.repository.AccomodationRepository;
import agent.repository.PeriodRepository;
import agent.service.dto.ReservationDTO;

@Transactional
@Service
public class ReservationService {

	@Autowired
	private PeriodRepository periodRepository;

	@Autowired
	private AccomodationRepository accomodationRepository;

	public void create(ReservationDTO reservationDTO) throws ParseException {

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date fromDate = date.parse(reservationDTO.getFrom());

		java.util.Date toDate = date.parse(reservationDTO.getTo());

		ArrayList<Period> periods = (ArrayList<Period>) periodRepository.findAll();

		for (int i = 0; i < periods.size(); i++) {

			java.util.Date fromPeriod = date.parse(periods.get(i).getFromDate());
			java.util.Date toPeriod = date.parse(periods.get(i).getToDate());

			if (fromDate.after(fromPeriod) && fromDate.before(toPeriod)) {
				throw new IllegalArgumentException("Period is busy !!!");
			} else if (toDate.after(fromPeriod) && toDate.before(toPeriod)) {
				throw new IllegalArgumentException("Period is busy !!!");
			} else {

				Period period = new Period();

				period.setFromDate(reservationDTO.getFrom());
				period.setToDate(reservationDTO.getTo());

				String[] parse = reservationDTO.getAccomodation().split("/");
				String accomodationIdString = parse[0];
				Long accomodationId = Long.parseLong(accomodationIdString);

				Accommodation accomodation = accomodationRepository.findOne(accomodationId);
				period.setAccomodation(accomodation);

				periodRepository.save(period);

			}
		}

		if (periods.isEmpty() == true)

		{
			Period period = new Period();

			period.setFromDate(reservationDTO.getFrom());
			period.setToDate(reservationDTO.getTo());

			String[] parse = reservationDTO.getAccomodation().split("/");
			String accomodationIdString = parse[0];
			Long accomodationId = Long.parseLong(accomodationIdString);

			Accommodation accomodation = accomodationRepository.findOne(accomodationId);
			period.setAccomodation(accomodation);

			periodRepository.save(period);

		}
	}

}
