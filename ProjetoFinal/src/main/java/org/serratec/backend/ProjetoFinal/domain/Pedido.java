package org.serratec.backend.ProjetoFinal.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataPedido;
	
	private long quantidade;

	private LocalDateTime dataEnvio;
	
	private LocalDateTime dataEntrega;
	
	private List<Produto> produtos;
	
	private BigDecimal valorFinal;
	
	private Cliente cliente;
	
	
}

