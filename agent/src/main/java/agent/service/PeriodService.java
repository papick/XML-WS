package agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.model.Period;
import agent.repository.PeriodRepository;

@Service
public class PeriodService {

	@Autowired
	private PeriodRepository periodRepository;

	public List<Period> getAllPeriods() {
		return periodRepository.findAll();
	}

}
