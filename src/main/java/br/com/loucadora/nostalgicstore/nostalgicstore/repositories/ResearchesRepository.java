package br.com.loucadora.nostalgicstore.nostalgicstore.repositories;

import org.springframework.stereotype.Repository;
import br.com.loucadora.nostalgicstore.nostalgicstore.models.Research;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ResearchesRepository extends JpaRepository<Research, Integer>{ 
}
