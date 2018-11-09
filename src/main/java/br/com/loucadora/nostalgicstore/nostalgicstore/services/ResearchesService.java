package br.com.loucadora.nostalgicstore.nostalgicstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Question;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Research;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Alternative;
import br.com.loucadora.nostalgicstore.nostalgicstore.repositories.ResearchersRepository;
import br.com.loucadora.nostalgicstore.nostalgicstore.repositories.ResearchesRepository;

@Service
public class ResearchesService {

	@Autowired
	private ResearchesRepository repository;
	@Autowired
	private ResearchersRepository researchersRepository;
	
	public Research create(Research research) {
		research.setResearcher(researchersRepository.findByEmail(research.getResearcher().getEmail()));
		for(Question q : research.getQuestions()) {
			q.setResearch(research);
			for(Alternative r : q.getAlternatives()) {
				r.setQuestion(q);
			}
		}
		return repository.save(research);
	}

	public Research find(Integer id) {
		return repository.findById(id).get(); 
	}

	public List<Research> all(Integer researcherId) {
		List<Research> researches = repository.findByResearcherId(researcherId);
		if(researches.isEmpty()) {
			researches = repository.findAll();
		}
		return researches;
	}
}
