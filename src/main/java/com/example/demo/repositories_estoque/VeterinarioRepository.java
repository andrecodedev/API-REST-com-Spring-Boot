package com.example.demo.repositories_estoque;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domains_pratos.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
