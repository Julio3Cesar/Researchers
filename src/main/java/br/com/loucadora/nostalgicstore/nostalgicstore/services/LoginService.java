package br.com.loucadora.nostalgicstore.nostalgicstore.services;

import java.io.UnsupportedEncodingException;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Researcher;

//@Service
public class LoginService {

	public String login(Researcher researcher) {
		
		if(researcher == null) return null; 
		
		try {
			String s = token(researcher);
			return s;
		} catch (IllegalArgumentException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String token(Researcher u) throws IllegalArgumentException, UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        return JWT.create()
                .withClaim("user", u.getEmail())
                .sign(algorithm);
    }
}