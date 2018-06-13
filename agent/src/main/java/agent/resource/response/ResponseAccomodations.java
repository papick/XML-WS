package agent.resource.response;

import java.util.ArrayList;

import agent.model.Accommodation;

public class ResponseAccomodations {

	private ArrayList<Accommodation> accomodations;

	public ResponseAccomodations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseAccomodations(ArrayList<Accommodation> accomodations) {
		super();
		this.accomodations = accomodations;
	}

	public ArrayList<Accommodation> getAccomodations() {
		return accomodations;
	}

	public void setAccomodations(ArrayList<Accommodation> accomodations) {
		this.accomodations = accomodations;
	}

}
