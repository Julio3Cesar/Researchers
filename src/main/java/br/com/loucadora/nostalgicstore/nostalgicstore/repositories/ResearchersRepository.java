package br.com.loucadora.nostalgicstore.nostalgicstore.repositories;

import org.springframework.stereotype.Repository;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Researcher;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ResearchersRepository extends JpaRepository<Researcher, Integer>{ 
	Researcher findByEmail(String email);
}
