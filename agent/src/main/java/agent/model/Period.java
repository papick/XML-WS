package agent.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Period {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Date from;

	@NotNull
	private Date to;

	@ManyToOne
	private Accommodation accomodation;

	public Period(Date from, Date to, Accommodation accomodation) {
		super();
		this.from = from;
		this.to = to;
		this.accomodation = accomodation;
	}

	public Period() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public Accommodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accommodation accomodation) {
		this.accomodation = accomodation;
	}

}
