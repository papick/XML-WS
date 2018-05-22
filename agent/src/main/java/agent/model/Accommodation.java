package agent.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
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

	@ManyToOne
	private TypeAccomodation type;

	@ManyToMany
	private List<AdditionalService> additionalService;

	public Accommodation() {
	}

	public Accommodation(String image, String description, int capacity, double price,
			TypeAccomodation type, List<AdditionalService> additionalService) {
		super();
		this.image = image;
		this.description = description;
		this.capacity = capacity;
		this.price = price;
		this.type = type;
		this.additionalService = additionalService;
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
