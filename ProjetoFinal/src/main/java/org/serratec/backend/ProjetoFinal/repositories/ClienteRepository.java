package org.serratec.backend.ProjetoFinal.repositories;

import org.serratec.backend.ProjetoFinal.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Cliente findByEmail(String email);
	Cliente findByNome(String nome);
}