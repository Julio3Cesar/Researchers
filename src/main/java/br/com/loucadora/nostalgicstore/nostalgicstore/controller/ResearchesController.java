package br.com.loucadora.nostalgicstore.nostalgicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.loucadora.nostalgicstore.nostalgicstore.model.Researcher;
import br.com.loucadora.nostalgicstore.nostalgicstore.services.ResearchesService;

@RestController
@RequestMapping("/researches")
public class ResearchesController {
	
	@Autowired
	private ResearchesService researchesService;

	public ResearchesController(ResearchesService researchesService) {
		this.researchesService = researchesService;
	}


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Researcher researcher) {
		return new ResponseEntity<Researcher>(researchesService.create(researcher), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> show(@PathVariable Integer id) {
		return new ResponseEntity<Researcher>(researchesService.find(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> index() {
		return new ResponseEntity<List<Researcher>>(researchesService.all(), HttpStatus.OK);
	}
}
