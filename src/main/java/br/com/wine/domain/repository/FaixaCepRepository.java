package br.com.wine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wine.domain.model.FaixaCep;

public interface FaixaCepRepository extends JpaRepository<FaixaCep, Long>, FaixaCepRepositoryQueries {

}
