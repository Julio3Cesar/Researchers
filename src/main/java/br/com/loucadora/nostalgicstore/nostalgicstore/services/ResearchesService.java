package br.com.loucadora.nostalgicstore.nostalgicstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Researcher;
import br.com.loucadora.nostalgicstore.nostalgicstore.repositories.ResearchesRepository;

@Service
public class ResearchesService {
	
	@Autowired
	private ResearchesRepository repository;

	public Researcher create(Researcher researcher) {
		return repository.save(researcher);
	}

	public Researcher find(Integer id) {
		return repository.findById(id).get();
	}

	public List<Researcher> all() {
		return repository.findAll();
	}

}
