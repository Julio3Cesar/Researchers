package br.com.loucadora.nostalgicstore.nostalgicstore.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Research {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Researcher Author is required!")
	@OneToOne
	private Researcher researcherAuthor;
	
	@OneToMany(targetEntity = Question.class)
	@NotNull(message = "Question is required!")
	private List<Question> questions;
	
	@OneToMany(targetEntity = QuestionResponse.class)
	private List<QuestionResponse> questionResponses;
	
	@NotNull(message = "Is anonymous? is required!")
	private Boolean isAnonymous;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Researcher getResearcherAuthor() {
		return researcherAuthor;
	}

	public void setResearcherAuthor(Researcher researcherAuthor) {
		this.researcherAuthor = researcherAuthor;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<QuestionResponse> getQuestionResponses() {
		return questionResponses;
	}

	public void setQuestionResponses(List<QuestionResponse> questionResponses) {
		this.questionResponses = questionResponses;
	}

	public Boolean getIsAnonymous() {
		return isAnonymous;
	}

	public void setIsAnonymous(Boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
}