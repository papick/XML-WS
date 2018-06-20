package agent.resource.response;

import java.util.List;

import agent.model.Addition;

public class ResponseAditionalServices {

	private List<Addition> services;

	public ResponseAditionalServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public ResponseAditionalServices(List<Addition> services) {
		super();
		this.services = services;
	}



	public List<Addition> getServices() {
		return services;
	}

	public void setServices(List<Addition> services) {
		this.services = services;
	}

	

}
