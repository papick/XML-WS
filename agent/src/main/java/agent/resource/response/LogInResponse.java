package agent.resource.response;

import agent.model.Agent;

public class LogInResponse {

	private Agent agent;

	public LogInResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogInResponse(Agent agent) {
		super();
		this.agent = agent;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
