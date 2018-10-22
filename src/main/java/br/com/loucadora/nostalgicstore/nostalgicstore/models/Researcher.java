package br.com.loucadora.nostalgicstore.nostalgicstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Researcher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Name can't be null")
	private String name;
	@NotNull(message = "Email can't be null.")
	@Email(message = "Email invalid.")
	private String email;
	private String company;
	@NotNull(message = "Password can't be null")
	@Size(message = "Minimum characters to password is 8.",min = 8)
	private String password;
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}