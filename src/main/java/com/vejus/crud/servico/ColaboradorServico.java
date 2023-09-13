package com.vejus.crud.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vejus.crud.modelo.Colaborador;
import com.vejus.crud.repositorio.ColaboradorRepositorio;

@Service
public class ColaboradorServico {

	@Autowired
	private ColaboradorRepositorio colaboradorRepositorio;
	
	public Colaborador criarColaborador(Colaborador colaborador) {
		return colaboradorRepositorio.save(colaborador);
	}
	
	public List<Colaborador> buscarTodosColaboradores(){
		return colaboradorRepositorio.findAll();
	}
	
	public List<Colaborador> buscarColaboradorPorNome(String nome){
		return colaboradorRepositorio.findByNomeContainingIgnoreCase(nome);
	}
	
}
