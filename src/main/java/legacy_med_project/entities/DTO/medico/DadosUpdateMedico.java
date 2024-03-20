package legacy_med_project.entities.DTO.medico;

import jakarta.validation.constraints.NotNull;
import legacy_med_project.entities.DTO.endereco.DadosCadastroEndereço;

public record DadosUpdateMedico(
		@NotNull
		Long id, 
		String nome, 
		String telefone, 
		DadosCadastroEndereço endereco
		) {

}
