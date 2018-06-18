package agent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import agent.model.Accommodation;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "price")
public class Price {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   
	@ManyToOne
    private Accommodation accomodation;

    private String month;
    
    
    public Price() {
		// TODO Auto-generated constructor stub
	}


	public Price(long id, Accommodation accomodation, String month) {
		super();
		this.id = id;
		this.accomodation = accomodation;
		this.month = month;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Accommodation getAccomodation() {
		return accomodation;
	}


	public void setAccomodation(Accommodation accomodation) {
		this.accomodation = accomodation;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}
}
