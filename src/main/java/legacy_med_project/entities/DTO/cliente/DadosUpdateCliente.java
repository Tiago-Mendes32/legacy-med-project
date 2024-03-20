package legacy_med_project.entities.DTO.cliente;

import jakarta.validation.constraints.NotNull;
import legacy_med_project.entities.DTO.endereco.DadosCadastroEndereço;

public record DadosUpdateCliente(
		@NotNull
		Long id, 
		String nome, 
		String telefone, 
		DadosCadastroEndereço endereco
		) {

}
