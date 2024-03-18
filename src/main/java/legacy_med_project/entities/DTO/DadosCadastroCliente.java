package legacy_med_project.entities.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
		
		@NotBlank
		String nome,
		
		@NotBlank
		@Email
		String email,
		
		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String telefone,
		
		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String cpf,
		
		@NotNull @Valid
		DadosCadastroEndereço endereco) 
{
}
