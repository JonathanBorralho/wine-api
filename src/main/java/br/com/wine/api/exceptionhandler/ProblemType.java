package br.com.wine.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	FAIXA_CEP_CONFLITO("/faixa-cep-conflito", "Faixa Cep já em uso");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "https://wine.com.br" + path;
		this.title = title;
	}
	
}

