package org.serratec.backend.ProjetoFinal.services;

import org.serratec.backend.ProjetoFinal.domain.Cliente;
import org.serratec.backend.ProjetoFinal.repositories.ClienteRepository;
import org.serratec.backend.ProjetoFinal.exeption.EmailException;
import org.serratec.backend.ProjetoFinal.config.MailConfig;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private MailConfig mailConf;
	
	public void inserirCliente(Cliente clienteQueVemDoController) throws EmailException{
		Cliente cliente = clienteRepository.findByEmail(clienteQueVemDoController.getEmail());
		if(cliente != null) {
			throw new EmailException("Cliente com este e-mail já existe no cadastro.");			
		}		
		clienteQueVemDoController.setSenha(criptografiaService.criptografar(clienteQueVemDoController.getSenha()));
		Cliente clienteSalvo =  clienteRepository.save(clienteQueVemDoController);
		mailConf.sendMail(clienteSalvo.getEmail(), "Cadastro de usuário", clienteSalvo.toString());
		return clienteSalvo;
    }
	
	public List<Cliente> retornaTodosOsClientes() {
        return clienteRepository.findAll();
    }
	
	@Transactional
    public Cliente atualizarCliente(Long idDoClienteASerAtualizado, Cliente clienteComOsNovosDados) {
		Cliente clienteQueEstaNoBanco = clienteRepository.findById(idDoClienteASerAtualizado).get();
        if (clienteComOsNovosDados.getNome() != null) {
        	clienteQueEstaNoBanco.setNome(clienteComOsNovosDados.getNome());
        }
        if (clienteComOsNovosDados.getCpf() != null) {
        	clienteQueEstaNoBanco.setCpf(clienteComOsNovosDados.getCpf());
        }
        if (clienteComOsNovosDados.getEmail() != null) {
        	clienteQueEstaNoBanco.setEmail(clienteComOsNovosDados.getEmail());
        }
        if (clienteComOsNovosDados.getDataNascimento() != null) {
        	clienteQueEstaNoBanco.setDataNascimento(clienteComOsNovosDados.getDataNascimento());
        }
        //TODO : atualizar Endereço
        /*
        if (clienteComOsNovosDados.getDataNascimento() != null) {
        	clienteQueEstaNoBanco.setDataNascimento(clienteComOsNovosDados.getDataNascimento());
        }
        */
        return clienteQueEstaNoBanco;
    }
	
	public void deletarClientePorId(Long idDoClienteASerDeletado) {
		clienteRepository.deleteById(idDoClienteASerDeletado);
    }
}