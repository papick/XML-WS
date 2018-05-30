package agent;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import agent.model.Accommodation;
import agent.service.AccomodationService;

@SpringBootApplication
public class AgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentApplication.class, args);
		
		try {
			URL url = new URL("http://localhost:8888/accomodationService");
			QName qname = new QName("http://www.ftn.uns.ac.rs/booking", "accomodationService");
			Service service = Service.create(url, qname);
			AccomodationService accService = service.getPort(AccomodationService.class);
			Accommodation acc = new Accommodation();
			acc.setCapacity(3);
			accService.create(acc);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
