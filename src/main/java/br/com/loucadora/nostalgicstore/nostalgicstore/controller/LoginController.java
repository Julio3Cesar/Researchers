package br.com.loucadora.nostalgicstore.nostalgicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Researcher;
import br.com.loucadora.nostalgicstore.nostalgicstore.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private final LoginService service;

    public LoginController(LoginService service) {
		this.service = service;
	}

    @RequestMapping(method = RequestMethod.POST)
    public String postAutentica(Researcher researcher) {
		return this.service.login(researcher);
    }
}
