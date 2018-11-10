package br.com.loucadora.nostalgicstore.nostalgicstore.repositories;

import org.springframework.stereotype.Repository;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AlternativesRepository extends JpaRepository<Alternative, Integer>{ 
}
