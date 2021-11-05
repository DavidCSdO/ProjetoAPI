package org.serratec.backend.ProjetoFinal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String rua;
	@NotBlank
	private String cidade;
	@NotBlank
	private String bairro;
	@NotBlank
	private String CEP;
	@NotBlank
	private String estado;
	@NotBlank
	private String numero;
	@NotBlank
	private String complemento;
	
}
