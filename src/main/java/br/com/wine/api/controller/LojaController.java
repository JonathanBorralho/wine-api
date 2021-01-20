package br.com.wine.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wine.domain.model.Loja;
import br.com.wine.domain.repository.LojaRepository;

@RestController
@RequestMapping("/lojas")
public class LojaController {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@GetMapping
	public List<Loja> listar() {
		return lojaRepository.findAll();
	}
	
	@GetMapping("/cep/{cep}")
	public ResponseEntity<Loja> buscarPorCep(Integer cep) {
		return ResponseEntity.of(lojaRepository.findByCEP(cep));
	}
}
