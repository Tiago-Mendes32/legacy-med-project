package legacy_med_project.entities.DTO;

import legacy_med_project.entities.Cliente;

public record DadosListagemCliente(Long id, String nome, String email, String cpf) {

	public DadosListagemCliente(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf());
	}
}
