package agent.resource.response;

import java.util.List;

import agent.model.City;

public class ResponseCities {

	private List<City> cities;

	public ResponseCities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseCities(List<City> cities) {
		super();
		this.cities = cities;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	

}
