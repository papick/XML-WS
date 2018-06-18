package agent.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import agent.model.Accommodation;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "availability")
public class Availability {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
	
		@XmlElement(required = true)
		@ManyToOne
	    private Accommodation accomodation;
		
	    @XmlElement(required = true)
	    @XmlSchemaType(name = "date")
	    private Date date;
	    
	    
	    public Availability() {
			// TODO Auto-generated constructor stub
		}


		public Availability(Accommodation accomodation, Date date) {
			super();
			this.accomodation = accomodation;
			this.date = date;
		}


		public Accommodation getAccomodation() {
			return accomodation;
		}


		public void setAccomodation(Accommodation accomodation) {
			this.accomodation = accomodation;
		}


		public Date getDate() {
			return date;
		}


		public void setDate(Date date) {
			this.date = date;
		}
		
}
