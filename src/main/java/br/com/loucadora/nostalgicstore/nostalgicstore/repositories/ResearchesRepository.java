package br.com.loucadora.nostalgicstore.nostalgicstore.repositories;

import org.springframework.stereotype.Repository;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Research;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Researcher;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ResearchesRepository extends JpaRepository<Research, Integer>{ 
	List<Research> findByResearcherId(Integer researcherId);
}
