package agent.resource.response;

import agent.model.Agent;

public class LogInResponse {

	private Agent agent;
	
	private Long idCore;

	public LogInResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogInResponse(Agent agent) {
		super();
		this.agent = agent;
	}

	public LogInResponse(Agent agent, Long idCore) {
		super();
		this.agent = agent;
		this.idCore = idCore;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Long getIdCore() {
		return idCore;
	}

	public void setIdCore(Long idCore) {
		this.idCore = idCore;
	}

	
	
}
