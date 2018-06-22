package agent.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.Accommodation;
import agent.model.Price;
import agent.repository.AccomodationRepository;
import agent.repository.PriceRepository;
import agent.service.dto.PriceDTO;
import agent.service.dto.PriceListDTO;

@RestController
@RequestMapping(value = "/api/price")
public class PriceResource {
	
	@Autowired
	private AccomodationRepository accomodationRepository;
	
	@Autowired
	private PriceRepository priceRepository;
	
	
	@PostMapping("/create-price-list/{idAccomodation}")
	public void createPriceList(@RequestBody PriceListDTO priceListDTO, @PathVariable Long idAccomodation) {
		
		
		Accommodation accomodation = accomodationRepository.findOne(idAccomodation);
		
		
		for(PriceDTO priceDTO : priceListDTO.getPrices()) {
			
			Price price = new Price();
			price.setAccomodation(accomodation);
			price.setMonth(priceDTO.getMonth());
			price.setSum(priceDTO.getSum());
			
			priceRepository.save(price);
			
		}
		
		
	}

}
