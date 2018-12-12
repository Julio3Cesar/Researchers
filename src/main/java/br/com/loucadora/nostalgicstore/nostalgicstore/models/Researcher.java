package br.com.loucadora.nostalgicstore.nostalgicstore.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Researcher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Full name can't be null")
	private String fullName;
	
	@NotNull(message = "Email can't be null.")
	@Email(message = "Email invalid.")
	@Column(unique = true)
	private String email;
	
	private String company;
	
	@NotNull(message = "Password can't be null")
	@Size(message = "Minimum characters to password is 8.",min = 8)
	//@JsonBackReference
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="researcher", cascade=CascadeType.ALL)
	@JsonIgnoreProperties({"researcher"})
	private List<Research> researches;

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Research> getResearches() {
		return researches;
	}

	public void setResearches(List<Research> researches) {
		this.researches = researches;
	}
}
