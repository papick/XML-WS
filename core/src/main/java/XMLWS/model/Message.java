package XMLWS.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message")
public class Message implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private User sender;

	@OneToOne
	private Agent recipient;

	private String text;


	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(Long id, User sender, Agent recipient, String text) {
		super();
		this.id = id;
		this.sender = sender;
		this.recipient = recipient;
		this.text = text;
	}

	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Agent getRecipient() {
		return recipient;
	}

	public void setRecipient(Agent recipient) {
		this.recipient = recipient;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
