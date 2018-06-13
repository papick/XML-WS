package agent.resource.response;

import java.util.ArrayList;

import agent.model.Additional;

public class ResponseAditionalServices {

	private ArrayList<Additional> services;

	public ResponseAditionalServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseAditionalServices(ArrayList<Additional> services) {
		super();
		this.services = services;
	}

	public ArrayList<Additional> getServices() {
		return services;
	}

	public void setServices(ArrayList<Additional> services) {
		this.services = services;
	}

}
