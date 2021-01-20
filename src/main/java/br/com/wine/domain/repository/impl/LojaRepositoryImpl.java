package br.com.wine.domain.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import br.com.wine.domain.model.Loja;
import br.com.wine.domain.repository.LojaRepositoryQueries;

@Repository
public class LojaRepositoryImpl implements LojaRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Optional<Loja> findByCEP(Integer cep) {
		final String jpql = "select l from Loja l left join l.faixasCep fc"
				+ " where ?1 between fc.faixaInicio and fc.faixaFim";

		try {
			final Loja loja = manager
					.createQuery(jpql, Loja.class)
					.setParameter(1, cep)
					.getSingleResult();

			return Optional.of(loja);
		} catch (PersistenceException e) {
			return Optional.empty();
		}
	}

}
