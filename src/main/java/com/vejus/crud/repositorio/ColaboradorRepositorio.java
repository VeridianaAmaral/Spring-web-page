package com.vejus.crud.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vejus.crud.modelo.Colaborador;

public interface ColaboradorRepositorio extends JpaRepository<Colaborador, Long> {
	List<Colaborador> findByNomeContainingIgnoreCase(String nome);
	
}
