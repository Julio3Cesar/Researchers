package br.com.loucadora.nostalgicstore.nostalgicstore.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Question is required!")
	private String qeustion;
	
	@NotNull(message = "Possible Responses is required!")
	@OneToMany(targetEntity= Response.class)
	private List<Response> possibleResponses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQeustion() {
		return qeustion;
	}

	public void setQeustion(String qeustion) {
		this.qeustion = qeustion;
	}

	public List<Response> getPossibleResponses() {
		return possibleResponses;
	}

	public void setPossibleResponses(List<Response> possibleResponses) {
		this.possibleResponses = possibleResponses;
	}

}