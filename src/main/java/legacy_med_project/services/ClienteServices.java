package legacy_med_project.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import legacy_med_project.entities.Cliente;
import legacy_med_project.entities.Medico;
import legacy_med_project.entities.DTO.DadosListagemCliente;
import legacy_med_project.entities.DTO.DadosListagemMedico;
import legacy_med_project.entities.DTO.DadosUpdateCliente;
import legacy_med_project.repositories.ClienteRepository;

@Service
public class ClienteServices {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente insert(Cliente Cliente) {
		return repository.save(Cliente);
	}

	public Page<DadosListagemCliente> findAll(Pageable pageable) {
		return repository.findAllByAtivoTrue(pageable).map(DadosListagemCliente::new);
	}

	public Cliente atualizar(DadosUpdateCliente dados) throws Exception {
		Cliente cliente = repository.findById(dados.id()).orElseThrow(() -> new Exception("Object not found"));
		cliente = atualizarInformacoes(cliente, dados);
		return cliente;
	}

	private Cliente atualizarInformacoes(Cliente cliente, DadosUpdateCliente dados) {
		if(dados.nome() != null) {cliente.setNome(dados.nome());}
		if(dados.telefone() != null) {cliente.setTelefone(dados.telefone());}
		if(dados.endereco() != null) {cliente.getEndereco().atualizar(dados.endereco());}
		
		return repository.save(cliente);
	}
	
	public void desativar(Long id) throws Exception {
		Cliente cliente = repository.findById(id).orElseThrow(() -> new Exception("Object not found"));
		cliente.desativar();
	}
	
	public Cliente listagemPorId(Long id) throws Exception{
		return repository.findById(id).orElseThrow(() -> new Exception("Object not found"));
	}

}
