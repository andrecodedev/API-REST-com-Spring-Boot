package com.example.demo.repositories_estoque;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domains_pratos.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

	@Query("SELECT a FROM Atendimento a WHERE a.animal.id = :animalId ORDER BY a.dataRegistro DESC")
	List<Atendimento> buscarHistoricoPorAnimalId(@Param("animalId") Long animalId);
}
