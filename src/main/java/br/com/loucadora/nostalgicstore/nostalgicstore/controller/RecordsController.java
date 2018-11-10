package br.com.loucadora.nostalgicstore.nostalgicstore.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Record;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Research;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Researcher;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.response.ErrorResponse;
import br.com.loucadora.nostalgicstore.nostalgicstore.services.RecordsService;
import br.com.loucadora.nostalgicstore.nostalgicstore.services.ResearchesService;

@RestController
@RequestMapping("/records")
public class RecordsController {

	private RecordsService recordsService;

	public RecordsController(RecordsService recordsService) {
		this.recordsService = recordsService;
	}
	
	@PostMapping
	public ResponseEntity<?>create(@RequestBody Record record) {
		try {
			return new ResponseEntity<Record>(recordsService.create(record), HttpStatus.CREATED);
		}catch(ConstraintViolationException e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse().preconditionFailed(e.getConstraintViolations()), HttpStatus.PRECONDITION_FAILED);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id) {
		return new ResponseEntity<Record>(recordsService.find(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> index() {
		return new ResponseEntity<List<Record>>(recordsService.all(), HttpStatus.OK);
	}
}
