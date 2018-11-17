package br.com.loucadora.nostalgicstore.nostalgicstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Question;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Record;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Research;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Alternative;
import br.com.loucadora.nostalgicstore.nostalgicstore.repositories.AlternativesRepository;
import br.com.loucadora.nostalgicstore.nostalgicstore.repositories.RecordsRepository;
import br.com.loucadora.nostalgicstore.nostalgicstore.repositories.ResearchesRepository;

@Service
public class RecordsService {

	@Autowired
	private RecordsRepository repository;
	@Autowired
	private AlternativesRepository alternativesRepository;
	
	public Record create(Record record) {
		List<Alternative> aux = new ArrayList<>();
		for(Alternative alternative : record.getAlternatives()) {
			aux.add(alternativesRepository.findById(alternative.getId()).get());
		}
		record.setAlternatives(aux);
		return repository.save(record);
	}

	public Record find(Integer id) {
		return repository.findById(id).get(); 
	}

	public List<Record> allByResearchId(Integer researchId) {
		return repository.findByResearchId(researchId);
	}
}
