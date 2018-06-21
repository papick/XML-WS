package XMLWS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.Period;
import XMLWS.repository.PeriodRepository;
import XMLWS.service.PeriodService;

@Service
public class PeriodServiceImpl implements PeriodService {
	
	@Autowired 
	private PeriodRepository periodRepository;
	
	public List<Period> getAllPeriodsByAccomodation(Long accomodationId){
		return periodRepository.findByAccomodationId(accomodationId);
	}

	@Override
	public Period addPeriod(Period period) {
		return periodRepository.save(period);
	}
	
	
}
