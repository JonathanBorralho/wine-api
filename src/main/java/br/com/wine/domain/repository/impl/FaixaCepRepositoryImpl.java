package br.com.wine.domain.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.wine.domain.model.FaixaCep;
import br.com.wine.domain.repository.FaixaCepRepositoryQueries;

@Repository
public class FaixaCepRepositoryImpl implements FaixaCepRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean jaPossuiFaixa(FaixaCep faixaCep) {
		final String jpql = "select count(fc) from FaixaCep fc "
				+ " where :faixaInicio between fc.faixaInicio and fc.faixaFim "
				+ " or :faixaFim between fc.faixaInicio and fc.faixaFim";
		return manager
				.createQuery(jpql, Long.class)
				.setParameter("faixaInicio", faixaCep.getFaixaInicio())
				.setParameter("faixaFim", faixaCep.getFaixaFim())
				.getSingleResult() > 0;
	}

	@Override
	public boolean jaPossuiFaixa(FaixaCep faixaCep, Long faixaCepExcecaoId) {
		final String jpql = "select count(fc) from FaixaCep fc "
				+ " where fc.id <> :faixaCepExcecaoId and ("
				+ " :faixaInicio between fc.faixaInicio and fc.faixaFim "
				+ " or :faixaFim between fc.faixaInicio and fc.faixaFim)";
		return manager
				.createQuery(jpql, Long.class)
				.setParameter("faixaCepExcecaoId", faixaCepExcecaoId)
				.setParameter("faixaInicio", faixaCep.getFaixaInicio())
				.setParameter("faixaFim", faixaCep.getFaixaFim())
				.getSingleResult() > 0;
	}

}
