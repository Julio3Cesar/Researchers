package br.com.loucadora.nostalgicstore.nostalgicstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Researcher;
import br.com.loucadora.nostalgicstore.nostalgicstore.repositories.ResearchersRepository;

import static java.util.Collections.emptyList;


@Service
public class ResearchersService implements UserDetailsService{
	
	@Autowired
	private ResearchersRepository repository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Researcher create(Researcher researcher) {
		if(researcher.getPassword() != null && researcher.getPassword().length() > 7 && researcher.getId() == null)
			researcher.setPassword(bCryptPasswordEncoder.encode(researcher.getPassword()));
		return repository.save(researcher);
	}

	public Researcher find(Integer id) {
		return repository.findById(id).get();
	}

	public List<Researcher> all() {
		return repository.findAll();
	}
	
	public void deleteByEmail(String email) {
		repository.deleteById(repository.findByEmail(email).getId());
	}
	
	public Researcher update(Researcher researcher) {
		return repository.save(researcher);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Researcher applicationUser = repository.findByEmail(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getEmail(), applicationUser.getPassword(), emptyList());
	}

	public Researcher findByemail(String email) {
		return repository.findByEmail(email);
	}
}
