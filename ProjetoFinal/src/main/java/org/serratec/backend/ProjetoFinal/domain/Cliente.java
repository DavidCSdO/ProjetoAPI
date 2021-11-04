package org.serratec.backend.ProjetoFinal.domain;

import java.time.LocalDate;
import javax.persistence.*;
import java.util.Objects;


import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cliente {
	
	@Column(length = 50)
	@ApiModelProperty(value = "nome do cliente")
	private String nome;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id")
	private Long id;
	
	@Column
	@ApiModelProperty(value = "cpf do cliente", required = true)
	private String cpf;
	
	@Column
	@ApiModelProperty(value = "email do cliente", required = true)
	private String email;
	
	@Column
	@ApiModelProperty(value = "nascimento do cliente")
	private LocalDate dataNascimento;
	
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataNascimento, email, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id);
	}

}
