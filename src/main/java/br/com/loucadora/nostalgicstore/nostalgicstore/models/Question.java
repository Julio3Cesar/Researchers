package br.com.loucadora.nostalgicstore.nostalgicstore.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "RESEARCH_ID", nullable = false)
	@JsonBackReference
	private Research research;
	
	@NotNull
	private String question;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="question", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Alternative> alternatives;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Research getResearch() {
		return this.research;
	}

	public void setResearch(Research research) {
		this.research = research;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Alternative> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<Alternative> alternatives) {
		this.alternatives = alternatives;
	}
}
