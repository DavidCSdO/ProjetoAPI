package org.serratec.backend.ProjetoFinal.Controllers;

import javax.validation.Valid;

import org.serratec.backend.ProjetoFinal.Repositoryes.CategoriaRepository;
import org.serratec.backend.ProjetoFinal.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	@ApiOperation(value = "Criar nova categoria")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "retornar todos"),
			@ApiResponse(code = 40, message = "request error"),
	})
	public Categoria criate(@Valid @RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
		
		
	}

}
