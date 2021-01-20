package br.com.wine.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Loja {
	@Id
	private Long id;
	
	/**
	 * Propriedade não é um chave estrangeira para manter simplicidade
	 */
	private String cidade;
	
	private String bairro;
	
	@JsonIgnore
	@OneToMany(mappedBy = "loja")
	private List<FaixaCep> faixasCep;
}
