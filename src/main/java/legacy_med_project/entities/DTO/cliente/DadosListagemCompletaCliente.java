package legacy_med_project.entities.DTO.cliente;

import legacy_med_project.entities.Cliente;
import legacy_med_project.entities.DTO.endereco.DadosListagemEndereço;

public record DadosListagemCompletaCliente(
		Long id,
		String nome,
		String email, 
		String telefone,
		String cpf,
		
		DadosListagemEndereço endereco) {
	
	public DadosListagemCompletaCliente(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf(), new DadosListagemEndereço(cliente.getEndereco()));
	}
}
