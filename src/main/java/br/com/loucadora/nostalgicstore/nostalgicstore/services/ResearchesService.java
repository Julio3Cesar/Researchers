package br.com.loucadora.nostalgicstore.nostalgicstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Question;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Research;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Response;
import br.com.loucadora.nostalgicstore.nostalgicstore.repositories.ResearchesRepository;

@Service
public class ResearchesService {

	@Autowired
	private ResearchesRepository repository;
	
	public Research create(Research research) {
		for(Question q : research.getQuestions()) {
			q.setResearch(research);
			for(Response r : q.getResponses()) {
				r.setQuestion(q);
			}
		}
		return repository.save(research);
	}

}
