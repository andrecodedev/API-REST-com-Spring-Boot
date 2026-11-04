package com.example.demo.repositories_estoque;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domains_pratos.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {

	@Query("SELECT v FROM Vacina v WHERE v.animal.id = :animalId ORDER BY v.dataAplicacao DESC")
	List<Vacina> buscarPorAnimalId(@Param("animalId") Long animalId);
}
