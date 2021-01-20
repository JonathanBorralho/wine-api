package br.com.wine.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class FaixaCep {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_loja", nullable = false)
	private Loja loja;
	
	@NotNull
	@Column(name = "faixa_inicio")
	private Integer faixaInicio;
	
	@NotNull
	@Column(name = "faixa_fim")
	private Integer faixaFim;
}
