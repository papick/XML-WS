package XMLWS.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class VoteForAccomdoation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String vote;

	@OneToOne
	private User user;

	@OneToOne
	private Accommodation accomodation;

	public VoteForAccomdoation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VoteForAccomdoation(String vote, User user, Accommodation accomodation) {
		super();
		this.vote = vote;
		this.user = user;
		this.accomodation = accomodation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Accommodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accommodation accomodation) {
		this.accomodation = accomodation;
	}

}
