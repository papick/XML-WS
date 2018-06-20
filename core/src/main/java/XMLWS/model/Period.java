package XMLWS.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "period")
public class Period {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 1, max = 20)
	private String fromDate;

	@Size(min = 1, max = 20)
	private String toDate;

	@OneToOne
	private Accommodation accomodation;

	public Period() {
		// TODO Auto-generated constructor stub
	}

	public Period(Long id, String fromDate, String toDate, Accommodation accomodation) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.accomodation = accomodation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Accommodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accommodation accomodation) {
		this.accomodation = accomodation;
	}

	
	
	
	
	
	

}
