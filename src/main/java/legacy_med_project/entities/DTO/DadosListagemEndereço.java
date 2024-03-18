package legacy_med_project.entities.DTO;

import legacy_med_project.entities.Endereco;

public record DadosListagemEndereço(
		String logradouro, 
		String bairro, 
		String cep, 
		String cidade, 
		String uf, 
		String complemento, 
		String numero) { 

	public DadosListagemEndereço(Endereco endereco) {
		this(
				endereco.getLogradouro(),
				endereco.getBairro(),
				endereco.getCep(),
				endereco.getCidade(),
				endereco.getUf(),
				endereco.getComplemento(),
				endereco.getNumero()
				);
	}
}
