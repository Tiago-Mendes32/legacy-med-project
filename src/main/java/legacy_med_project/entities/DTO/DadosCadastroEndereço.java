package legacy_med_project.entities.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereço(
		
		@NotBlank
		String logradouro, 
		
		@NotBlank
		String bairro, 
		
		@NotBlank
		@Pattern(regexp = "\\d{8}")
		String cep, 
		
		@NotBlank
		String cidade, 
		
		@NotBlank
		String uf, 
		
		String complemento, 
		
		String numero) {
}
