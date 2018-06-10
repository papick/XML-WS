package XMLWS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import XMLWS.model.TypeAccomodation;

@Service
public interface TypeAccomodationService {
	
	public List<TypeAccomodation> getAllTypes();
	
	public TypeAccomodation getType(Long id);
	
	public TypeAccomodation addType(TypeAccomodation ta);
	
	public TypeAccomodation modifyType(TypeAccomodation ta, Long id);
	
	public void deleteType(Long id);

}
