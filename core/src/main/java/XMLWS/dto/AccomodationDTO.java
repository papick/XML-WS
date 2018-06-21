package XMLWS.dto;

import java.util.List;

import XMLWS.model.Accommodation;
import XMLWS.model.Addition;
import XMLWS.model.Category;
import XMLWS.model.City;
import XMLWS.model.Period;
import XMLWS.model.TypeAccomodation;

public class AccomodationDTO {
	
	private Long id;
	private String name;
	private String image;
	private String description;
	private int capacity;
	private TypeAccomodation type;
	private List<Addition> additions;
	private City city;
	private String address;
	private Category category;
	private List<Period> periods;
	
	
	
	public AccomodationDTO(Accommodation accomodation , List<Period> periods) {
		super();
		this.id = accomodation.getId();
		this.name = accomodation.getName();
		this.image = accomodation.getImage();
		this.description = accomodation.getDescription();
		this.capacity = accomodation.getCapacity();
		this.type = accomodation.getType();
		this.additions = accomodation.getAdditions();
		this.city = accomodation.getCity();
		this.address = accomodation.getAddress();
		this.category = accomodation.getCategory();
		this.periods = periods;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public TypeAccomodation getType() {
		return type;
	}
	public void setType(TypeAccomodation type) {
		this.type = type;
	}
	public List<Addition> getAdditions() {
		return additions;
	}
	public void setAdditions(List<Addition> additions) {
		this.additions = additions;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Period> getPeriods() {
		return periods;
	}
	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
	
	

}
