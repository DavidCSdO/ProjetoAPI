package org.serratec.backend.ProjetoFinal.Controllers;

	
	import java.util.List;
	import java.util.Optional;

	import javax.management.loading.ClassLoaderRepository;

import org.serratec.backend.ProjetoFinal.domain.Cliente;
import org.serratec.backend.ProjetoFinal.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

	@RestController
	@RequestMapping("/clientes")
	public class ClienteController {
		
		@Autowired
		private ClienteRepository clienteRepository;
		
		@GetMapping
		public List<Cliente> listar(){
			return clienteRepository.findAll();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Cliente> buscar(@PathVariable Long id){
			Optional<Cliente> cliente = clienteRepository.findById(id);
			if (cliente.isPresent()) {
				return ResponseEntity.ok(cliente.get());
			}
			return ResponseEntity.notFound().build();
		}
		
		@PutMapping("/att/{id}")
		@ApiResponses(value = {
					@ApiResponse(code = 201, message = "Cliente adicionado"),
					@ApiResponse(code = 401, message = "Erro de autenticação"),
					@ApiResponse(code = 403, message = "Cliente adicionado"),
					@ApiResponse(code = 404, message = "Recurso não encontrado")
		})
		public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
			if (!clienteRepository.existsById(id)){
				return ResponseEntity.notFound().build();
		}
			cliente.setId(id);
			cliente = clienteRepository.save(cliente);
			return ResponseEntity.ok(cliente);
		}
		
		@DeleteMapping("/dl/{id}")
		public ResponseEntity<Void> remover (@PathVariable Long id) {
			if (!clienteRepository.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			clienteRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		
		@PostMapping("/add")
		@ResponseStatus(code = HttpStatus.CREATED)
		public Cliente inserir(@RequestBody Cliente cliente) {
			clienteRepository.saveAndFlush(cliente);
			return cliente;
		}
	}


