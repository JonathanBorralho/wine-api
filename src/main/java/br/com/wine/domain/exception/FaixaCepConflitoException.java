package br.com.wine.domain.exception;

public class FaixaCepConflitoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FaixaCepConflitoException(String mensagem) {
		super(mensagem);
	}

}
