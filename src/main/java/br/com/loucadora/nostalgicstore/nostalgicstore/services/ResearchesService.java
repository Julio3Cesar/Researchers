package br.com.loucadora.nostalgicstore.nostalgicstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Research;
import br.com.loucadora.nostalgicstore.nostalgicstore.repositories.ResearchesRepository;

@Service
public class ResearchesService {

	@Autowired
	private ResearchesRepository repository;
	
	public Research create(Research research) {
		return repository.save(research);
	}

}
