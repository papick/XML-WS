package XMLWS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import XMLWS.model.Price;

@Service
public interface PriceService {
	public List<Price> getPricesByAccomodation(Long id);
}
