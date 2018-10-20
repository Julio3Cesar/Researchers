package br.com.loucadora.nostalgicstore.nostalgicstore.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TestsController {

	@RequestMapping("/test")
	public String test() {
		return "Hello Worldasdfasdfas";
	}

}
