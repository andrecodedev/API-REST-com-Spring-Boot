package com.example.demo.repositories_estoque;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domains_pratos.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

	@Query("SELECT a FROM Animal a WHERE a.tutor.id = :tutorId")
	List<Animal> buscarPorTutorId(@Param("tutorId") Long tutorId);
}
