package legacy_med_project.entities.DTO;

import legacy_med_project.entities.Especialidade;
import legacy_med_project.entities.Medico;

public record DadosListagemCompletaMedico(
		Long id,
		String nome,
		String email, 
		String telefone,
		String crm,
		Especialidade especialidade, 
		
		DadosListagemEndereço endereco) {
	
	public DadosListagemCompletaMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), new DadosListagemEndereço(medico.getEndereco()));
	}
}
