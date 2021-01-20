package br.com.wine.domain.exception;

public class FaixaCepConflitoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FaixaCepConflitoException() {
		super("As faixas inicial ou final já foram cadastradas");
	}

	public FaixaCepConflitoException(String mensagem) {
		super(mensagem);
	}

}
