package legacy_med_project.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionResponseController{

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> handleEntityNotFoundException(EntityNotFoundException ex,
			HttpServletRequest request) {
		StandardError standardError = new StandardError(
				LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(), 
				HttpStatus.NOT_FOUND.getReasonPhrase(), 
				ex.getMessage(), 
				request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}
	
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<StandardError_NotValidArguments> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
				HttpServletRequest request) {
			StandardError_NotValidArguments standardError = new StandardError_NotValidArguments(
					LocalDateTime.now(), 
					HttpStatus.BAD_REQUEST.value(), 
					HttpStatus.BAD_REQUEST.getReasonPhrase(), 
					ex.getMessage(), 
					request.getRequestURI(),
					ex.getFieldErrors().stream().map(DadosErroValidacao::new).toList()
					);
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
		}
}