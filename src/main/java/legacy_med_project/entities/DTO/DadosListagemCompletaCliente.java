package legacy_med_project.entities.DTO;

import legacy_med_project.entities.Cliente;

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
