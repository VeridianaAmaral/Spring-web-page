package com.vejus.crud.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vejus.crud.modelo.Colaborador;
import com.vejus.crud.servico.ColaboradorServico;

import jakarta.validation.Valid;

@Controller
public class ColaboradorControle {

	@Autowired
	private ColaboradorServico colaboradorServico;
	
	@GetMapping("/")
	public String listarColaboradores(Model model) {
		List<Colaborador> colaborador = colaboradorServico.buscarTodosColaboradores();
		model.addAttribute("itens",colaborador);
		return "/lista";
	}
	
	@PostMapping("/buscar")
	public String buscarColaboradores(Model model, @Param("nome") String nome) {
		if(nome ==null) {
			return "redirect:/";
		}
		List<Colaborador> colaborador = colaboradorServico.buscarColaboradorPorNome(nome);
		model.addAttribute("itens",colaborador);
		return "/lista";
	}
	
	@GetMapping("/novo")
	public String novoColaborador(Model model) {
		model.addAttribute("item", new Colaborador());
		return "/novo-colaborador";
	}
	
	@PostMapping("/gravar")
	public String gravarColaborador(@ModelAttribute("item") @Valid Colaborador colaborador, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/novo colaborador";
		}
		colaboradorServico.criarColaborador(colaborador);
		attributes.addFlashAttribute("mensagem", "Gravado com sucesso");
		return "redirect:/novo";
	}
	
}
