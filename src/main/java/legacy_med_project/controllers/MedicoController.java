package legacy_med_project.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import legacy_med_project.entities.Medico;
import legacy_med_project.entities.DTO.DadosCadastroMedico;
import legacy_med_project.entities.DTO.DadosListagemCompletaMedico;
import legacy_med_project.entities.DTO.DadosListagemMedico;
import legacy_med_project.entities.DTO.DadosUpdateMedico;
import legacy_med_project.services.MedicoServices;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	@Autowired
	MedicoServices service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosListagemCompletaMedico> insert(@Valid @RequestBody DadosCadastroMedico medico, UriComponentsBuilder builder) {
		Medico entity = service.insert(new Medico(medico));
		URI uri = builder.path("medicos/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosListagemCompletaMedico(entity));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DadosListagemCompletaMedico> listagemPorId(@PathVariable Long id) throws Exception{
		Medico medico = service.listagemPorId(id);
		return ResponseEntity.ok(new DadosListagemCompletaMedico(medico));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosListagemCompletaMedico> atualizar(@Valid @RequestBody DadosUpdateMedico dados) throws Exception {
		Medico medico = service.atualizar(dados);
		return ResponseEntity.ok(new DadosListagemCompletaMedico(medico));
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity desativar(@PathVariable Long id) throws Exception {
		service.desativar(id);
		return ResponseEntity.noContent().build();
	}
}
