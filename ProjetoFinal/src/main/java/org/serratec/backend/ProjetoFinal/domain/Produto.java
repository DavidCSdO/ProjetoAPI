package org.serratec.backend.ProjetoFinal.domain;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	@Column
	private String nome;
	@Column
	private String descricao;
	@Column(name = "Valor unitario")
	private BigDecimal valorUnitario;
	
	
	private Categoria categoria;
	
	

}
