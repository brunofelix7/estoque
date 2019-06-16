package br.com.unipe.estoque.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.unipe.estoque.enumeration.Cidade;

public class Endereco {
	
	private Integer id;
	
	private Cidade municipio;
	
	private String logradouro;
	
	private String numero;
	
	@Length(min = 9, max = 9, message = "CEP deve conter 8 números")
	@NotEmpty
	private String cep;
	
	public Endereco() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cidade getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Cidade municipio) {
		this.municipio = municipio;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
