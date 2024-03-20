package legacy_med_project.entities;

import jakarta.persistence.Embeddable;
import legacy_med_project.entities.DTO.endereco.DadosCadastroEndereço;

@Embeddable
public class Endereco {

	private String logradouro;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	private String complemento;
	private String numero;

	public Endereco() {
	}

	public Endereco(String logradouro, String bairro, String cep, String cidade, String uf, String complemento,
			String numero) {
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.complemento = complemento;
		this.numero = numero;
	}

	public Endereco(DadosCadastroEndereço endereco) {
		this.logradouro = endereco.logradouro();
		this.bairro = endereco.bairro();
		this.cep = endereco.cep();
		this.cidade = endereco.cidade();
		this.uf = endereco.uf();
		this.complemento = endereco.complemento();
		this.numero = endereco.numero();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void atualizar(DadosCadastroEndereço dados) {
		if (dados.logradouro() != null) {
			this.logradouro = dados.logradouro();
		}

		if (dados.bairro() != null) {
			this.bairro = dados.bairro();
		}

		if (dados.cep() != null) {
			this.cep = dados.cep();
		}

		if (dados.cidade() != null) {
			this.cidade = dados.cidade();
		}

		if (dados.uf() != null) {
			this.uf = dados.uf();
		}

		if (dados.complemento() != null) {
			this.complemento = dados.complemento();
		}

		if (dados.numero() != null) {
			this.numero = dados.numero();
		}

	}
}
