package agent.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.Period;
import agent.service.PeriodService;

@RestController
@RequestMapping(value = "/api/period")
public class PeriodsResource {

	@Autowired
	private PeriodService periodService;

	@GetMapping("/all-periods")
	public ResponseEntity<List<Period>> getPeriods() {
		List<Period> periods = periodService.getAllPeriods();
		return new ResponseEntity<>(periods, HttpStatus.OK);

	}

}