package agent.service.dto;

public class AccommodationDTO {

	private String image;

	private String description;

	private int capacity;

	private double price;

	private String type;

	// private List<AdditionalService> additionalService;

	private Long idAgent;

	// podaci za hotel

	private String name;

	private String city;

	private String address;

	private String category;

	public AccommodationDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(Long idAgent) {
		this.idAgent = idAgent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
