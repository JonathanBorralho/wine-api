package br.com.wine.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wine.domain.model.Loja;
import br.com.wine.domain.repository.LojaRepository;
import br.com.wine.domain.service.LojaService;

@RestController
@RequestMapping("/lojas")
public class LojaController {
	
	@Autowired
	private LojaRepository lojaRepository;

	@Autowired
	private LojaService lojaService;

	@GetMapping
	public List<Loja> listar() {
		return lojaRepository.findAll();
	}
	
	@GetMapping("/cep/{cep}")
	public Loja buscarPorCep(@PathVariable Integer cep) {
		return lojaService.buscarPorCEP(cep);
	}
}
