package org.serratec.backend.ProjetoFinal.Controllers;

import org.serratec.backend.ProjetoFinal.domain.Produto;
import org.serratec.backend.ProjetoFinal.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserirProduto(@Valid @RequestBody Produto produtoQueVemDoFront) {
		produtoService.inserirProduto(produtoQueVemDoFront);
    }
	
	@GetMapping
    public List<Produto> retornaTodosOsProdutos() {
        return produtoService.retornaTodosOsProdutos();
    }
	
	@PutMapping("{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable("id") Long idDoProdutoQueEPassadoNaUrl, @Valid @RequestBody Produto produtoQueVemDoCorpoDaRequisicao) {
		Produto produtoQueVemComoRespostaDoService = produtoService.atualizarProduto(idDoProdutoQueEPassadoNaUrl, produtoQueVemDoCorpoDaRequisicao);
        return ResponseEntity.ok().body(produtoQueVemComoRespostaDoService);
    }
	@DeleteMapping(value = "{id}")
    public ResponseEntity<?> deletarProdutoPorId(@PathVariable("id") Long idDoProdutoQueEPassadoNaUrl) {
		produtoService.deletarProdutoPorId(idDoProdutoQueEPassadoNaUrl);
        return ResponseEntity.ok().build();
    }
}