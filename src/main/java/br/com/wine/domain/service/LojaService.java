package br.com.wine.domain.service;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wine.domain.exception.EntidadeNaoEncontradaException;
import br.com.wine.domain.model.Loja;
import br.com.wine.domain.repository.LojaRepository;

@Service
public class LojaService {
	
	private static final String LOJA_NAO_ENCONTRADA_POR_CEP = "Loja não encontrada para o CEP: %d";
	
	@Autowired
	private LojaRepository lojaRepository;
	
	public Loja buscarPorCEP(Integer cep) throws EntidadeNaoEncontradaException {
		return lojaRepository
				.findByCEP(cep)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(format(LOJA_NAO_ENCONTRADA_POR_CEP, cep)));
	}
}
