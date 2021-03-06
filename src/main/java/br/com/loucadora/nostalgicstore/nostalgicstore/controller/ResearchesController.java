package br.com.loucadora.nostalgicstore.nostalgicstore.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Research;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.response.ErrorResponse;
import br.com.loucadora.nostalgicstore.nostalgicstore.services.ResearchesService;

@CrossOrigin(origins = "*", allowedHeaders = "Content-Type",methods= {RequestMethod.DELETE, RequestMethod.OPTIONS,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.PATCH,RequestMethod.POST,RequestMethod.PUT,RequestMethod.TRACE})
@RestController
@RequestMapping("/researches")
public class ResearchesController {

	private ResearchesService researchesService;

	public ResearchesController(ResearchesService researchesService) {
		this.researchesService = researchesService;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Research research) {
		try {
			return new ResponseEntity<Research>(researchesService.create(research), HttpStatus.CREATED);
		}catch(ConstraintViolationException e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse().preconditionFailed(e.getConstraintViolations()), HttpStatus.PRECONDITION_FAILED);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id) {
		return new ResponseEntity<Research>(researchesService.find(id), HttpStatus.OK);
	}

	@GetMapping("/index/email/{researchEmail}")
	public ResponseEntity<?> indexByEmail(@PathVariable String researchEmail) {
		return new ResponseEntity<List<Research>>(researchesService.findByResearcherEmail(researchEmail), HttpStatus.OK);
	}
	
	@GetMapping("/index/{researchId}")
	public ResponseEntity<?> index(@PathVariable Integer researchId) {
		return new ResponseEntity<List<Research>>(researchesService.all(researchId), HttpStatus.OK);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> destroy(@PathVariable Integer id) {
		researchesService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Research research) {
		return new ResponseEntity<Research>(researchesService.update(research), HttpStatus.OK);
	}
}
