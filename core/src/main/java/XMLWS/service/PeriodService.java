package XMLWS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import XMLWS.model.Period;

@Service
public interface PeriodService {
	public List<Period> getAllPeriodsByAccomodation(Long accomodationid) ;
	public Period addPeriod(Period period);

}
