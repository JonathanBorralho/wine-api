package br.com.wine.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wine.domain.exception.EntidadeNaoEncontradaException;
import br.com.wine.domain.exception.FaixaCepConflitoException;
import br.com.wine.domain.model.FaixaCep;
import br.com.wine.domain.repository.FaixaCepRepository;

@Service
public class FaixaCepService {
	
	@Autowired
	private FaixaCepRepository faixaCepRepository;
	
	public FaixaCep buscarOuFalhar(Long id) throws EntidadeNaoEncontradaException {
		return faixaCepRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Faixa de CEP não encontrada"));
	}

	public FaixaCep salvar(FaixaCep faixaCep) throws FaixaCepConflitoException {
		if (faixaCepRepository.jaPossuiFaixa(faixaCep)) {
			throw new FaixaCepConflitoException();
		}
		return faixaCepRepository.save(faixaCep);
	}

	public FaixaCep atualizar(Long id, FaixaCep faixaCep) {
		final FaixaCep oldFaixaCep = buscarOuFalhar(id);
		BeanUtils.copyProperties(faixaCep, oldFaixaCep, "id");
		if (faixaCepRepository.jaPossuiFaixa(oldFaixaCep, oldFaixaCep.getId())) {
			throw new FaixaCepConflitoException();
		}
		return faixaCepRepository.save(oldFaixaCep);
	}

	public void excluir(Long id) throws EntidadeNaoEncontradaException {
		final FaixaCep faixaCep = buscarOuFalhar(id);
		faixaCepRepository.delete(faixaCep);
	}
}
