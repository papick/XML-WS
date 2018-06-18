package agent.resource.response;

import java.util.ArrayList;

import agent.model.Addition;

public class ResponseAditionalServices {

	private ArrayList<Addition> services;

	public ResponseAditionalServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseAditionalServices(ArrayList<Addition> services) {
		super();
		this.services = services;
	}

	public ArrayList<Addition> getServices() {
		return services;
	}

	public void setServices(ArrayList<Addition> services) {
		this.services = services;
	}

}
