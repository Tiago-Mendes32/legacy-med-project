package legacy_med_project.entities.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import legacy_med_project.entities.Especialidade;

public record DadosCadastroMedico(
		
		@NotBlank
		String nome,
		
		@NotBlank
		@Email
		String email, 
		
		@NotBlank
		String telefone,
		
		@NotBlank
		@Pattern(regexp = "\\d{4,6}")
		String crm,
		
		@NotNull
		Especialidade especialidade, 
		
		@NotNull @Valid
		DadosCadastroEndereço endereco) {
}
