package com.example.demo.repositories_estoque;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domains_pratos.Consulta;
import com.example.demo.domains_pratos.StatusConsulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

	@Query("""
			SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END
			FROM Consulta c
			WHERE c.veterinario.id = :veterinarioId
			  AND c.dataHora = :dataHora
			  AND c.status = :status
			""")
	boolean existeAgendamentoNoHorario(
			@Param("veterinarioId") Long veterinarioId,
			@Param("dataHora") LocalDateTime dataHora,
			@Param("status") StatusConsulta status);

	@Query("SELECT c FROM Consulta c WHERE c.animal.id = :animalId ORDER BY c.dataHora DESC")
	List<Consulta> buscarPorAnimalId(@Param("animalId") Long animalId);

	@Query("SELECT c FROM Consulta c WHERE c.veterinario.id = :veterinarioId ORDER BY c.dataHora DESC")
	List<Consulta> buscarPorVeterinarioId(@Param("veterinarioId") Long veterinarioId);
}
