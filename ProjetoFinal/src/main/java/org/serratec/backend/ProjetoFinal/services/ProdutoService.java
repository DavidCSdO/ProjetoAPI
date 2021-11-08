package org.serratec.backend.ProjetoFinal.services;

import org.serratec.backend.ProjetoFinal.domain.Produto;
import org.serratec.backend.ProjetoFinal.repositories.ProdutoRepository;
import org.serratec.backend.ProjetoFinal.domain.Categoria;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	public void inserirProduto(Produto produtoQueVemDoController) {
        repository.saveAndFlush(produtoQueVemDoController);
    }
	
	public List<Produto> retornaTodosOsProdutos() {
        return repository.findAll();
    }
	
	@Transactional
    public Produto atualizarPessoa(Long idDoProdutoASerAtualizado, Produto produtoComOsNovosDados) {
		Produto produtoQueEstaNoBanco = repository.findById(idDoProdutoASerAtualizado).get();
        if (produtoComOsNovosDados.getNomeProduto() != null) {
        	produtoQueEstaNoBanco.setNomeProduto(produtoComOsNovosDados.getNomeProduto());
        }
        if (produtoComOsNovosDados.getDescricaoProduto() != null) {
        	produtoQueEstaNoBanco.setDescricaoProduto(produtoComOsNovosDados.getDescricaoProduto());
        }
        if (produtoComOsNovosDados.getValorUnitario() != null) {
        	produtoQueEstaNoBanco.setValorUnitario(produtoComOsNovosDados.getValorUnitario());
        }
        if (produtoComOsNovosDados.getCategoria() != null) {
        	produtoQueEstaNoBanco.setCategoria(produtoComOsNovosDados.getCategoria());
        }
        return produtoQueEstaNoBanco;
    }
	
	public void deletarProdutoPorId(Long idDoProdutoASerDeletado) {
        repository.deleteById(idDoProdutoASerDeletado);
    }
}