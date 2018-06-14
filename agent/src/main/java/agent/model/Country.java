package agent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "type")
@XmlRootElement(name = "country")
public class Country implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement(name="id", required=true)
	private Long id;

	@Column
	@XmlElement(name="code", required=true)
	private String code;
	
	@NotNull
	@Column(unique = true)
	@XmlElement(name="name", required=true)
	private String name;
	

	public Country() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
