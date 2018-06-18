package XMLWS.model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "availability")
public class Availability {
	
	
		@XmlElement(required = true)
	    private Accommodation accomodation;
		
	    @XmlElement(required = true)
	    @XmlSchemaType(name = "date")
	    private XMLGregorianCalendar date;
	    
	    
	    public Availability() {
			// TODO Auto-generated constructor stub
		}


		public Availability(Accommodation accomodation, XMLGregorianCalendar date) {
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


		public XMLGregorianCalendar getDate() {
			return date;
		}


		public void setDate(XMLGregorianCalendar date) {
			this.date = date;
		}
	    
	    
		
		
}
