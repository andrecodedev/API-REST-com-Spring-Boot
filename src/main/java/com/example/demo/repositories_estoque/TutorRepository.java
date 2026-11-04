package com.example.demo.repositories_estoque;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domains_pratos.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
