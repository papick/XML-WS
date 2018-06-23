package XMLWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.model.Price;
import XMLWS.service.PriceService;

@RestController
@RequestMapping(value = "/api/accomodations/{id}/prices")
public class PriceController {


	@Autowired
	private PriceService priceService;
	
	@GetMapping
	public List<Price> getAccomodations(@PathVariable Long id) {
		
		return priceService.getPricesByAccomodation(id);
	}
}
