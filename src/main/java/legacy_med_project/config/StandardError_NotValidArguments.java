package legacy_med_project.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.validation.FieldError;

public class StandardError_NotValidArguments {

	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	private List<DadosErroValidacao> errors;
	
	public StandardError_NotValidArguments(LocalDateTime timestamp, Integer status, String error, String message, String path, List<DadosErroValidacao> errors) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.errors = errors;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<DadosErroValidacao> getErrors() {
		return errors;
	}

	public void setErrors(List<DadosErroValidacao> errors) {
		this.errors = errors;
	}
}
