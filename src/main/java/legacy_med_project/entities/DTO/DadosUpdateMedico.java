package legacy_med_project.entities.DTO;

import jakarta.validation.constraints.NotNull;

public record DadosUpdateMedico(
		@NotNull
		Long id, 
		String nome, 
		String telefone, 
		DadosCadastroEndereço endereco
		) {

}
