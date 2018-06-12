package XMLWS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "users")
@XmlRootElement
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 1, max = 20)
	@Column(unique = true, nullable = false)
	private String username;

	@Size(min = 3, max = 20)
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	@Email
	private String email;
	
	private boolean active;

	public User() {
	}

	public User(String username, String password, String email, boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.active=active;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", status="
				+ active + "]";
	}

}
