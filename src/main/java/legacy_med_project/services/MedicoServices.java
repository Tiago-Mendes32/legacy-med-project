package legacy_med_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import legacy_med_project.entities.Medico;
import legacy_med_project.entities.DTO.DadosListagemMedico;
import legacy_med_project.entities.DTO.DadosUpdateMedico;
import legacy_med_project.repositories.MedicoRepository;

@Service
public class MedicoServices {

	@Autowired
	private MedicoRepository repository;
	
	public Medico insert(Medico medico) {
		return repository.save(medico);
	}

	public Page<DadosListagemMedico> findAll(Pageable pageable) {
	    return repository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
	}
	
	public Medico atualizar(DadosUpdateMedico dados) throws Exception {
		Medico medico = listagemPorId(dados.id());
		medico = atualizarInformacoes(medico, dados);
		return medico;
	}

	private Medico atualizarInformacoes(Medico medico, DadosUpdateMedico dados) {
		if(dados.nome() != null) {medico.setNome(dados.nome());}
		if(dados.telefone() != null) {medico.setTelefone(dados.telefone());}
		if(dados.endereco() != null) {medico.getEndereco().atualizar(dados.endereco());}
		
		return repository.save(medico);
	}

	public void desativar(Long id) throws Exception {
		Medico medico = listagemPorId(id);
		medico.desativar();
		repository.save(medico);
	}

	public Medico listagemPorId(Long id) throws Exception{
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Object not found"));
	}
}
