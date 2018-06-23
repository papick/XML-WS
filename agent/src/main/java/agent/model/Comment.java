package agent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String text;

	@NotNull
	private String nameOfUser; // pri dodavanju da se setuje na ime ulogovanog
								// klijenta

	@ManyToOne
	private Accommodation accommodation;

	private boolean approved; // pri dodavanju setuje se na false

	public Comment() {
	}

	public Comment(String text, String nameOfUser, Accommodation accommodation, boolean approved) {
		super();
		this.text = text;
		this.nameOfUser = nameOfUser;
		this.accommodation = accommodation;
		this.approved = approved;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNameOfUser() {
		return nameOfUser;
	}

	public void setNameOfUser(String nameOfUser) {
		this.nameOfUser = nameOfUser;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

}
