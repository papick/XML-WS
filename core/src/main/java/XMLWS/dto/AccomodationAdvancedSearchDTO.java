package XMLWS.dto;

import java.util.List;

import XMLWS.model.Addition;
import XMLWS.model.Category;
import XMLWS.model.TypeAccomodation;

public class AccomodationAdvancedSearchDTO extends AccomodationSearchDTO {
	private List<Category> categories;
	private List<TypeAccomodation> types;
	private List<Addition> additions;
	
	
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<TypeAccomodation> getTypes() {
		return types;
	}
	public void setTypes(List<TypeAccomodation> types) {
		this.types = types;
	}
	public List<Addition> getAdditions() {
		return additions;
	}
	public void setAdditions(List<Addition> additions) {
		this.additions = additions;
	}
	
	public boolean hasCategory(Category category) {
		if(categories == null || categories.isEmpty()) {
			return true;
		}
		for(Category c : categories) {
			if(c.getId() == category.getId()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasType(TypeAccomodation type) {
		if(types == null || types.isEmpty()) {
			return true;
		}
		for(TypeAccomodation t : types) {

			if(t.getId() == type.getId()) {
				return true;
			}
		}
		return false;
	}
	public boolean hasAdditons(List<Addition> additionsSearch) {
		if(additions == null || additions.isEmpty()) {
			return true;
		}
		int number= 0;
		for(Addition a : additions) {
			for(Addition a2 : additionsSearch) {
				if(a.getId() == a2.getId()) {
					number++;
					break;
				}
			}
			
		}
		
		return number == additionsSearch.size();
	}
	
	
	
	
}
