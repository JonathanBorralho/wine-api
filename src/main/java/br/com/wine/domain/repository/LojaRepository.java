package br.com.wine.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.wine.domain.model.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long> {
	
	@Query("select l from Loja l join l.faixasCep fc where ?1 between fc.faixaInicio and fc.faixaFim")
	Optional<Loja> findByCEP(Integer cep);
}
