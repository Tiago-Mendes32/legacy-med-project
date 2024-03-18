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
import legacy_med_project.entities.Cliente;
import legacy_med_project.entities.DTO.DadosCadastroCliente;
import legacy_med_project.entities.DTO.DadosListagemCompletaCliente;
import legacy_med_project.entities.DTO.DadosListagemCliente;
import legacy_med_project.entities.DTO.DadosUpdateCliente;
import legacy_med_project.services.ClienteServices;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	ClienteServices service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosListagemCompletaCliente> insert(@Valid @RequestBody DadosCadastroCliente cliente, UriComponentsBuilder builder) {
		Cliente entity = service.insert(new Cliente(cliente));
		URI uri = builder.path("clientes/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosListagemCompletaCliente(entity));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemCliente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DadosListagemCompletaCliente> listagemPorId(@PathVariable Long id) throws Exception{
		Cliente cliente = service.listagemPorId(id);
		return ResponseEntity.ok(new DadosListagemCompletaCliente(cliente));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosListagemCompletaCliente> atualizar(@Valid @RequestBody DadosUpdateCliente dados) throws Exception {
		Cliente cliente = service.atualizar(dados);
		return ResponseEntity.ok(new DadosListagemCompletaCliente(cliente));
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity desativar(@PathVariable Long id) throws Exception {
		service.desativar(id);
		return ResponseEntity.noContent().build();
	}
}
