package legacy_med_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import legacy_med_project.entities.DTO.login.DadosLogin;

@RestController
@RequestMapping("/login")
public class AutenticationController {

	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody @Valid DadosLogin dados) {
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
		manager.authenticate(token);
		
		return ResponseEntity.ok().build();
	}
}
