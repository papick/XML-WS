package agent.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.City;
import agent.resource.response.ResponseCities;
import agent.service.CityService;

@RestController
@RequestMapping(value = "/api/city")
public class CityResource {

	@Autowired
	private CityService cityService;

	@GetMapping("/all-cities")
	public ResponseEntity<ResponseCities> getCities() {

		ArrayList<City> cities = cityService.getAllCities();

		return new ResponseEntity<>(new ResponseCities(cities), HttpStatus.OK);
	}
}
