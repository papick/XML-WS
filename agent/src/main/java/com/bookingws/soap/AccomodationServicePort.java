
package com.bookingws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0-SNAPSHOT
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AccomodationServicePort", targetNamespace = "http://bookingws.com/soap")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AccomodationServicePort {


    /**
     * 
     * @param getAgentRequest
     * @return
     *     returns com.bookingws.soap.GetAgentResponse
     */
    @WebMethod
    @WebResult(name = "getAgentResponse", targetNamespace = "http://bookingws.com/soap", partName = "getAgentResponse")
    public GetAgentResponse getAgent(
        @WebParam(name = "getAgentRequest", targetNamespace = "http://bookingws.com/soap", partName = "getAgentRequest")
        GetAgentRequest getAgentRequest);

    /**
     * 
     * @param getMessagesRequest
     * @return
     *     returns com.bookingws.soap.GetMessagesResponse
     */
    @WebMethod
    @WebResult(name = "getMessagesResponse", targetNamespace = "http://bookingws.com/soap", partName = "getMessagesResponse")
    public GetMessagesResponse getMessages(
        @WebParam(name = "getMessagesRequest", targetNamespace = "http://bookingws.com/soap", partName = "getMessagesRequest")
        GetMessagesRequest getMessagesRequest);

    /**
     * 
     * @param confirmReservationRequest
     * @return
     *     returns com.bookingws.soap.ConfirmReservationResponse
     */
    @WebMethod
    @WebResult(name = "confirmReservationResponse", targetNamespace = "http://bookingws.com/soap", partName = "confirmReservationResponse")
    public ConfirmReservationResponse confirmReservation(
        @WebParam(name = "confirmReservationRequest", targetNamespace = "http://bookingws.com/soap", partName = "confirmReservationRequest")
        ConfirmReservationRequest confirmReservationRequest);

    /**
     * 
     * @param getCategoriesRequest
     * @return
     *     returns com.bookingws.soap.GetCategoriesResponse
     */
    @WebMethod
    @WebResult(name = "getCategoriesResponse", targetNamespace = "http://bookingws.com/soap", partName = "getCategoriesResponse")
    public GetCategoriesResponse getCategories(
        @WebParam(name = "getCategoriesRequest", targetNamespace = "http://bookingws.com/soap", partName = "getCategoriesRequest")
        GetCategoriesRequest getCategoriesRequest);

    /**
     * 
     * @param addPeriodRequest
     * @return
     *     returns com.bookingws.soap.AddPeriodResponse
     */

    /**
     * 
     * @param getReservationsRequest
     * @return
     *     returns com.bookingws.soap.GetReservationsResponse
     */
    @WebMethod
    @WebResult(name = "getReservationsResponse", targetNamespace = "http://bookingws.com/soap", partName = "getReservationsResponse")
    public GetReservationsResponse getReservations(
        @WebParam(name = "getReservationsRequest", targetNamespace = "http://bookingws.com/soap", partName = "getReservationsRequest")
        GetReservationsRequest getReservationsRequest);

    /**
     * 
     * @param getAdditionsRequest
     * @return
     *     returns com.bookingws.soap.GetAdditionsResponse
     */
    @WebMethod
    @WebResult(name = "getAdditionsResponse", targetNamespace = "http://bookingws.com/soap", partName = "getAdditionsResponse")
    public GetAdditionsResponse getAdditions(
        @WebParam(name = "getAdditionsRequest", targetNamespace = "http://bookingws.com/soap", partName = "getAdditionsRequest")
        GetAdditionsRequest getAdditionsRequest);

    /**
     * 
     * @param deleteAccomodationRequest
     * @return
     *     returns com.bookingws.soap.DeleteAccomodationResponse
     */
    @WebMethod
    @WebResult(name = "deleteAccomodationResponse", targetNamespace = "http://bookingws.com/soap", partName = "deleteAccomodationResponse")
    public DeleteAccomodationResponse deleteAccomodation(
        @WebParam(name = "deleteAccomodationRequest", targetNamespace = "http://bookingws.com/soap", partName = "deleteAccomodationRequest")
        DeleteAccomodationRequest deleteAccomodationRequest);

    /**
     * 
     * @param getTypesAccomodationRequest
     * @return
     *     returns com.bookingws.soap.GetTypesAccomodationResponse
     */
    @WebMethod
    @WebResult(name = "getTypesAccomodationResponse", targetNamespace = "http://bookingws.com/soap", partName = "getTypesAccomodationResponse")
    public GetTypesAccomodationResponse getTypesAccomodation(
        @WebParam(name = "getTypesAccomodationRequest", targetNamespace = "http://bookingws.com/soap", partName = "getTypesAccomodationRequest")
        GetTypesAccomodationRequest getTypesAccomodationRequest);

    /**
     * 
     * @param addAccomodationRequest
     * @return
     *     returns com.bookingws.soap.AddAccomodationResponse
     */
    @WebMethod
    @WebResult(name = "addAccomodationResponse", targetNamespace = "http://bookingws.com/soap", partName = "addAccomodationResponse")
    public AddAccomodationResponse addAccomodation(
        @WebParam(name = "addAccomodationRequest", targetNamespace = "http://bookingws.com/soap", partName = "addAccomodationRequest")
        AddAccomodationRequest addAccomodationRequest);

    /**
     * 
     * @param sendResponseRequest
     * @return
     *     returns com.bookingws.soap.SendResponseResponse
     */
    @WebMethod
    @WebResult(name = "sendResponseResponse", targetNamespace = "http://bookingws.com/soap", partName = "sendResponseResponse")
    public SendResponseResponse sendResponse(
        @WebParam(name = "sendResponseRequest", targetNamespace = "http://bookingws.com/soap", partName = "sendResponseRequest")
        SendResponseRequest sendResponseRequest);

    /**
     * 
     * @param getUserRequest
     * @return
     *     returns com.bookingws.soap.GetUserResponse
     */
    @WebMethod
    @WebResult(name = "getUserResponse", targetNamespace = "http://bookingws.com/soap", partName = "getUserResponse")
    public GetUserResponse getUser(
        @WebParam(name = "getUserRequest", targetNamespace = "http://bookingws.com/soap", partName = "getUserRequest")
        GetUserRequest getUserRequest);

    /**
     * 
     * @param agentAuthenticationRequest
     * @return
     *     returns com.bookingws.soap.AgentAuthenticationResponse
     */
    @WebMethod
    @WebResult(name = "agentAuthenticationResponse", targetNamespace = "http://bookingws.com/soap", partName = "agentAuthenticationResponse")
    public AgentAuthenticationResponse agentAuthentication(
        @WebParam(name = "agentAuthenticationRequest", targetNamespace = "http://bookingws.com/soap", partName = "agentAuthenticationRequest")
        AgentAuthenticationRequest agentAuthenticationRequest);

    /**
     * 
     * @param setCountryRequest
     * @return
     *     returns com.bookingws.soap.SetCountryResponse
     */
    @WebMethod
    @WebResult(name = "setCountryResponse", targetNamespace = "http://bookingws.com/soap", partName = "setCountryResponse")
    public SetCountryResponse setCountry(
        @WebParam(name = "setCountryRequest", targetNamespace = "http://bookingws.com/soap", partName = "setCountryRequest")
        SetCountryRequest setCountryRequest);

    /**
     * 
     * @param getCountriesRequest
     * @return
     *     returns com.bookingws.soap.GetCountriesResponse
     */
    @WebMethod
    @WebResult(name = "getCountriesResponse", targetNamespace = "http://bookingws.com/soap", partName = "getCountriesResponse")
    public GetCountriesResponse getCountries(
        @WebParam(name = "getCountriesRequest", targetNamespace = "http://bookingws.com/soap", partName = "getCountriesRequest")
        GetCountriesRequest getCountriesRequest);

    /**
     * 
     * @param getCountryRequest
     * @return
     *     returns com.bookingws.soap.GetCountryResponse
     */
    @WebMethod
    @WebResult(name = "getCountryResponse", targetNamespace = "http://bookingws.com/soap", partName = "getCountryResponse")
    public GetCountryResponse getCountry(
        @WebParam(name = "getCountryRequest", targetNamespace = "http://bookingws.com/soap", partName = "getCountryRequest")
        GetCountryRequest getCountryRequest);

    /**
     * 
     * @param getCitiesRequest
     * @return
     *     returns com.bookingws.soap.GetCitiesResponse
     */
    @WebMethod
    @WebResult(name = "getCitiesResponse", targetNamespace = "http://bookingws.com/soap", partName = "getCitiesResponse")
    public GetCitiesResponse getCities(
        @WebParam(name = "getCitiesRequest", targetNamespace = "http://bookingws.com/soap", partName = "getCitiesRequest")
        GetCitiesRequest getCitiesRequest);

}
