package XMLWS.dto;

public class VoteDTO {

	private String username;
	private String idAccomodation;
	private String vote;

	public VoteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VoteDTO(String username, String idAccomodation, String vote) {
		super();
		this.username = username;
		this.idAccomodation = idAccomodation;
		this.vote = vote;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdAccomodation() {
		return idAccomodation;
	}

	public void setIdAccomodation(String idAccomodation) {
		this.idAccomodation = idAccomodation;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

}
