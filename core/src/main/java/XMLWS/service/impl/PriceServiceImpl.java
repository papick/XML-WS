package XMLWS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.Price;
import XMLWS.repository.PriceRepository;
import XMLWS.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;
	@Override
	public List<Price> getPricesByAccomodation(Long id) {
		return priceRepository.findByAccomodationId(id);
	}

}
