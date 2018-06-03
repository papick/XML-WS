package XMLWS;

import javax.xml.ws.Endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import XMLWS.service.impl.AccomodationServiceImp;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
		
		//Endpoint.publish("http://localhost:8888/accomodationService", new AccomodationServiceImp());
	}
}
