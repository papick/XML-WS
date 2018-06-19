package XMLWS.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import XMLWS.model.Addition;
import XMLWS.model.Agent;
import XMLWS.model.Category;
import XMLWS.model.City;
import XMLWS.model.TypeAccomodation;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accomodation")
public class Accommodation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;
	
	@Column
	private String image;

	@Column
	private String description;

	@Column
	private int capacity;

	@OneToOne
	private TypeAccomodation type;

	@ManyToMany
	private List<Addition> additions;
	
	@OneToOne
	private City city;

	@Column
	private String address;

	@OneToOne
	private Agent agent;

	@OneToOne
	private Category category;
	
	@Column
	private Long idAgentApp;
	
	


	

	public Accommodation() {
	}

	public Accommodation(String image, String description, int capacity,  TypeAccomodation type,
			String name, City city, String address, Agent agent, Category category) {
		super();
		this.image = image;
		this.description = description;
		this.capacity = capacity;
		this.type = type;
		this.name = name;
		this.city = city;
		this.address = address;
		this.agent = agent;
		this.category = category;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getIdAgentApp() {
		return idAgentApp;
	}

	public void setIdAgentApp(Long idAgentApp) {
		this.idAgentApp = idAgentApp;
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

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

}
