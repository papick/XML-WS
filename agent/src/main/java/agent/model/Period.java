package agent.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import agent.model.Accommodation;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "period")
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

	public Period() {
		// TODO Auto-generated constructor stub
	}

	public Period(Long id, Date from, Date to, Accommodation accomodation) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.accomodation = accomodation;
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
