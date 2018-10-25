package br.com.loucadora.nostalgicstore.nostalgicstore.models;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

@Entity
public class QuestionResponse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Interviewee interviewee;
	
	@OneToMany @JoinTable(name="Responses_Relationship")
    @MapKeyColumn(name="question_id")
	private Map<Question, Response> responses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Interviewee getInterviewee() {
		return interviewee;
	}

	public void setInterviewee(Interviewee interviewee) {
		this.interviewee = interviewee;
	}

	public Map<Question, Response> getResponses() {
		return responses;
	}

	public void setResponses(Map<Question, Response> responses) {
		this.responses = responses;
	}
}
