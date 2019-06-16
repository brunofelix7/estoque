package br.com.unipe.estoque.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.unipe.estoque.enumeration.Cidade;
import br.com.unipe.estoque.enumeration.Sexo;

public class Usuario {
	
	private Integer id;

	@Length(min = 10)
	@NotEmpty
	private String nome;

	@NotEmpty
	private String username;

	@NotEmpty
	@Length(min = 8, max = 16)
	private String password;

	@NotNull
	private Sexo sexo;

	@Past
	@NotNull
	private Date dataNasc;

	@NotNull
	private Cidade cidadeNasc;

	@Max(40)
	private Float valor;

	@Min(18)
	private Integer idade;

	@Email
	@NotEmpty
	private String email;

	private String cpf;

	private Cidade municipio;
	
	private String logradouro;
	
	private String numero;
	
	@Length(min = 9, max = 9, message = "CEP deve conter 8 números")
	@NotEmpty
	private String cep;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Cidade getCidadeNasc() {
		return cidadeNasc;
	}

	public void setCidadeNasc(Cidade cidadeNasc) {
		this.cidadeNasc = cidadeNasc;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cidade getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Cidade municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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


	
}
