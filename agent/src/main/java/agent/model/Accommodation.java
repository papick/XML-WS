package agent.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Accommodation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String image;

	private String description;

	@NotNull
	private int capacity;

	@NotNull
	private double price;

	@OneToOne
	private TypeAccomodation type;

	@ManyToMany
	private List<AdditionalService> additionalService;

	// podaci za hotel

	@NotNull
	private String name;

	@OneToOne
	private City city;

	private String address;

	@OneToOne
	private User agent;

	@OneToOne
	private Category category;

	public Accommodation() {
	}

	public Accommodation(String description, int capacity, double price, TypeAccomodation type, String name, City city,
			String address, User agent, Category category) {
		super();
		this.description = description;
		this.capacity = capacity;
		this.price = price;
		this.type = type;
		this.name = name;
		this.city = city;
		this.address = address;
		this.agent = agent;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public User getAgent() {
		return agent;
	}

	public void setAgent(User agent) {
		this.agent = agent;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public TypeAccomodation getType() {
		return type;
	}

	public void setType(TypeAccomodation type) {
		this.type = type;
	}

	public List<AdditionalService> getAdditionalService() {
		return additionalService;
	}

	public void setAdditionalService(List<AdditionalService> additionalService) {
		this.additionalService = additionalService;
	}

}
