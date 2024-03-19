package legacy_med_project.config;

import org.springframework.validation.FieldError;

public record DadosErroValidacao (String field, String message){

	public DadosErroValidacao(FieldError error) {
		this(error.getField(), error.getDefaultMessage());
	}
}
