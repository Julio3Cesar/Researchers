package br.com.loucadora.nostalgicstore.nostalgicstore.repositories;

import org.springframework.stereotype.Repository;

import br.com.loucadora.nostalgicstore.nostalgicstore.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RecordsRepository extends JpaRepository<Record, Integer>{ 
}
