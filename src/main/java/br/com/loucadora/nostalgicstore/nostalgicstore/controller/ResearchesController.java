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
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Researcher;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.response.ErrorResponse;
import br.com.loucadora.nostalgicstore.nostalgicstore.services.ResearchesService;

@RestController
@RequestMapping("/researchers")
public class ResearchesController {
	
	private ResearchesService researchesService;

	public ResearchesController(ResearchesService researchesService) {
		this.researchesService = researchesService;
	}

	@PostMapping("/sign-up")
	public ResponseEntity<?> create(@RequestBody Researcher researcher) {
		try {
			return new ResponseEntity<Researcher>(researchesService.create(researcher), HttpStatus.CREATED);
		}catch(ConstraintViolationException e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse().preconditionFailed(e.getConstraintViolations()), HttpStatus.PRECONDITION_FAILED);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id) {
		return new ResponseEntity<Researcher>(researchesService.find(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> index() {
		return new ResponseEntity<List<Researcher>>(researchesService.all(), HttpStatus.OK);
	}
}