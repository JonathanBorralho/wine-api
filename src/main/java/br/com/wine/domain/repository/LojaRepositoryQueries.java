package br.com.wine.domain.repository;

import java.util.Optional;

import br.com.wine.domain.model.Loja;

public interface LojaRepositoryQueries {
	Optional<Loja> findByCEP(Integer cep);
}
