package br.com.loucadora.nostalgicstore.nostalgicstore.controller;

import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Researcher;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.response.ErrorResponse;
import br.com.loucadora.nostalgicstore.nostalgicstore.services.ResearchersService;

@RestController
@RequestMapping("/researchers")
public class ResearchersController {
	
	private ResearchersService researchersService;

	public ResearchersController(ResearchersService researchersService) {
		this.researchersService = researchersService;
	}

	@PostMapping("/sign-up")
	public ResponseEntity<?> create(@RequestBody Researcher researcher) {
		try {
			return new ResponseEntity<Researcher>(researchersService.create(researcher), HttpStatus.CREATED);
		}catch(ConstraintViolationException e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse().preconditionFailed(e.getConstraintViolations()), HttpStatus.PRECONDITION_FAILED);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id) {
		return new ResponseEntity<Researcher>(researchersService.find(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> index() {
		return new ResponseEntity<List<Researcher>>(researchersService.all(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> destroy(@PathVariable Integer id) {
		researchersService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Researcher researcher) {
		return new ResponseEntity<Researcher>(researchersService.update(researcher), HttpStatus.OK);
	}
}