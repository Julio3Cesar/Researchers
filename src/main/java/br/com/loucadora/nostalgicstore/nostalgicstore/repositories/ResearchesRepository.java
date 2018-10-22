package br.com.loucadora.nostalgicstore.nostalgicstore.repositories;

import org.springframework.stereotype.Repository;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Researcher;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ResearchesRepository extends JpaRepository<Researcher, Integer>{ 

}
