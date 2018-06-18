
package com.bookingws.soap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import agent.model.TypeAccomodation;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="typesAccomodation" type="{http://bookingws.com/soap}typeAccomodation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "typesAccomodation"
})
@XmlRootElement(name = "getTypesAccomodationResponse")
public class GetTypesAccomodationResponse {

    protected List<TypeAccomodation> typesAccomodation;

    /**
     * Gets the value of the typesAccomodation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typesAccomodation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypesAccomodation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeAccomodation }
     * 
     * 
     */
    public List<TypeAccomodation> getTypesAccomodation() {
        if (typesAccomodation == null) {
            typesAccomodation = new ArrayList<TypeAccomodation>();
        }
        return this.typesAccomodation;
    }

}
