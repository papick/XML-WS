package agent.service.dto;

public class ReservationDTO {

	private String accomodation;
	private String from;
	private String to;

	public ReservationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservationDTO(String accomodation, String from, String to) {
		super();
		this.accomodation = accomodation;
		this.from = from;
		this.to = to;
	}

	public String getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(String accomodation) {
		this.accomodation = accomodation;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
