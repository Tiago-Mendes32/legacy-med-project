package legacy_med_project.entities.DTO.medico;

import legacy_med_project.entities.Especialidade;
import legacy_med_project.entities.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

	public DadosListagemMedico(Medico medico) {
		this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
	}
}
