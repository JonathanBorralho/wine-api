package br.com.wine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wine.domain.model.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long>, LojaRepositoryQueries {

}
