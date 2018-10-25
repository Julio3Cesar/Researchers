package br.com.loucadora.nostalgicstore.nostalgicstore.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Research;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.response.ErrorResponse;
import br.com.loucadora.nostalgicstore.nostalgicstore.services.ResearchesService;

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
}
