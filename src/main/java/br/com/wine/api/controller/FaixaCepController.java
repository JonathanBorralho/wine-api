package br.com.wine.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.wine.domain.exception.EntidadeNaoEncontradaException;
import br.com.wine.domain.exception.FaixaCepConflitoException;
import br.com.wine.domain.model.FaixaCep;
import br.com.wine.domain.repository.FaixaCepRepository;
import br.com.wine.domain.service.FaixaCepService;

@RestController
@RequestMapping("/faixaCep")
public class FaixaCepController {
	
	@Autowired
	private FaixaCepService faixaCepService;
	
	@Autowired
	private FaixaCepRepository faixaCepRepository;
	
	@GetMapping
	public List<FaixaCep> listar() {
		return faixaCepRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> salvar(@Valid @RequestBody FaixaCep faixaCep) {
		try {
			final FaixaCep faixaCepSalva = faixaCepService.salvar(faixaCep);
			return ResponseEntity.ok(faixaCepSalva);
		} catch (FaixaCepConflitoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		try {
			faixaCepService.excluir(id);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
