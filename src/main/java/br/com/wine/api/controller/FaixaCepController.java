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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
		final FaixaCep faixaCepSalva = faixaCepService.salvar(faixaCep);
		return ResponseEntity.ok(faixaCepSalva);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody FaixaCep faixaCep) {
		final FaixaCep faixaCepSalva = faixaCepService.atualizar(id, faixaCep);
		return ResponseEntity.ok(faixaCepSalva);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		faixaCepService.excluir(id);
	}
}
