package br.com.loucadora.nostalgicstore.nostalgicstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Question;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Record;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Research;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Response;
import br.com.loucadora.nostalgicstore.nostalgicstore.repositories.RecordsRepository;
import br.com.loucadora.nostalgicstore.nostalgicstore.repositories.ResearchesRepository;

@Service
public class RecordsService {

	@Autowired
	private RecordsRepository repository;
	
	public Record create(Record record) {
		return repository.save(record);
	}

	public Record find(Integer id) {
		return repository.findById(id).get(); 
	}

	public List<Record> all() {
		return repository.findAll();
	}

}
