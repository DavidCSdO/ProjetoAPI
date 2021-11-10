package org.serratec.backend.ProjetoFinal.domain;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private long idProduto;
	
	@NotBlank()
    @Size(max = 80, min = 5, message = "Nome deve conter entre {min} e {max} caracteres.")
    @Column(length = 80, nullable = false)
	private String nomeProduto;
	
	@NotBlank()
    @Size(max = 100, min = 4, message = "Nome deve conter entre {min} e {max} caracteres.")
    @Column(length = 100, nullable = false)
	private String descricaoProduto;
	
	@NotBlank()
	@Column(length = 50, nullable = false, name = "Valor unitario")
	private BigDecimal valorUnitario;
	
	private Categoria categoria;

	public Produto() {
		super();
	}

	public Produto(long idProduto, String nomeProduto, String descricaoProduto, BigDecimal valorUnitario, Categoria categoria) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.valorUnitario = valorUnitario;
		this.categoria = categoria;
	}

	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Id do Produto: " + idProduto 
				+ "\nProduto: " + nomeProduto 
				+ "\nDescrição: "	+ descricaoProduto 
				+ "\nValor Unitario: " + valorUnitario 
				+ "\nCategoria: " + categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, descricaoProduto, idProduto, nomeProduto, valorUnitario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descricaoProduto, other.descricaoProduto)
				&& idProduto == other.idProduto && Objects.equals(nomeProduto, other.nomeProduto)
				&& Objects.equals(valorUnitario, other.valorUnitario);
	}
}