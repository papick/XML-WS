//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.17 at 11:39:32 PM CEST 
//


package com.bookingws.soap;

import javax.xml.bind.annotation.XmlRegistry;

import XMLWS.model.Country;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bookingws.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bookingws.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCountriesRequest }
     * 
     */
    public GetCountriesRequest createGetCountriesRequest() {
        return new GetCountriesRequest();
    }

    /**
     * Create an instance of {@link SetCountryRequest }
     * 
     */
    public SetCountryRequest createSetCountryRequest() {
        return new SetCountryRequest();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link SetCountryResponse }
     * 
     */
    public SetCountryResponse createSetCountryResponse() {
        return new SetCountryResponse();
    }

    /**
     * Create an instance of {@link GetCountriesResponse }
     * 
     */
    public GetCountriesResponse createGetCountriesResponse() {
        return new GetCountriesResponse();
    }

    /**
     * Create an instance of {@link GetCountryRequest }
     * 
     */
    public GetCountryRequest createGetCountryRequest() {
        return new GetCountryRequest();
    }

    /**
     * Create an instance of {@link GetCountryResponse }
     * 
     */
    public GetCountryResponse createGetCountryResponse() {
        return new GetCountryResponse();
    }

    /**
     * Create an instance of {@link Agent }
     * 
     */
    public Agent createAgent() {
        return new Agent();
    }

    /**
     * Create an instance of {@link Period }
     * 
     */
    public Period createPeriod() {
        return new Period();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }

    /**
     * Create an instance of {@link TypeAccomodation }
     * 
     */
    public TypeAccomodation createTypeAccomodation() {
        return new TypeAccomodation();
    }

    /**
     * Create an instance of {@link Accomodation }
     * 
     */
    public Accomodation createAccomodation() {
        return new Accomodation();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Addition }
     * 
     */
    public Addition createAddition() {
        return new Addition();
    }

}