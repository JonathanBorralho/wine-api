package br.com.wine.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wine.domain.exception.FaixaCepConflitoException;
import br.com.wine.domain.model.FaixaCep;
import br.com.wine.domain.repository.FaixaCepRepository;

@Service
public class FaixaCepService {
	
	@Autowired
	private FaixaCepRepository faixaCepRepository;
	
	public FaixaCep salvar(FaixaCep faixaCep) throws FaixaCepConflitoException {
		if (faixaCepRepository.jaPossuiFaixa(faixaCep)) {
			throw new FaixaCepConflitoException("As faixas inicial ou final já foram cadastradas");
		}
		return faixaCepRepository.save(faixaCep);
	}
}
