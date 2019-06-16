package br.com.unipe.estoque.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.unipe.estoque.enumeration.Cidade;
import br.com.unipe.estoque.enumeration.Enderecos;
import br.com.unipe.estoque.enumeration.Estado;
import br.com.unipe.estoque.enumeration.Sexo;
import br.com.unipe.estoque.model.Endereco;

@ManagedBean(name = "enderecoBean")
@SessionScoped
public class EnderecoBean {

	private Endereco endereco;
	private List<SelectItem> listSexo;
	private List<SelectItem> listCidade;
	private List<Endereco> listUsuario;

	private Estado selectEstado;
	private List<SelectItem> listEstados;
	private List<SelectItem> listMunicipios;

	private String filtro;

	public EnderecoBean() {
		endereco = new Endereco();
		listMunicipios = new ArrayList<>();
		listUsuario = new ArrayList<>();
		listUsuario = Enderecos.INSTANCE.allUsers();
	}

	@PostConstruct
	public void initSexo() {
		listSexo = new ArrayList<>();
		for (Sexo s : Sexo.values()) {
			listSexo.add(new SelectItem(s, s.getLabel()));
		}

		listCidade = new ArrayList<>();
		for (Cidade s : Cidade.values()) {
			listCidade.add(new SelectItem(s, s.getLabel()));
		}

		listEstados = new ArrayList<>();
		for (Estado s : Estado.values()) {
			listEstados.add(new SelectItem(s, s.getLabel()));
		}
	}

	public void carregarMunicipios() {
		listMunicipios = new ArrayList<>();
		for (Cidade cidade : Cidade.values()) {
			if (selectEstado.name().equals(cidade.getEstado()))
				listMunicipios.add(new SelectItem(cidade, cidade.getLabel()));
		}
	}

	public String prepararCadastro() {
		endereco = new Endereco();
		return "cadastroEndereco";
	}

	public String prepararList() {
		return "";
	}

	public String removerUsuario(Endereco usuario) {
		Enderecos.INSTANCE.removeUser(usuario);
		listUsuario = Enderecos.INSTANCE.allUsers();
		return "index";
	}
	
	public String adicionarUsuario() {
		endereco.setCep(endereco.getCep().replace("-", ""));
		if(Enderecos.INSTANCE.isIdRepetido(endereco)) {
			Enderecos.INSTANCE.updateUser(endereco);
		} else {
			Enderecos.INSTANCE.addUser(endereco);
		}
		listUsuario = Enderecos.INSTANCE.allUsers();
		return "listarEnderecos";
	}

	public void filtrarTabela() {
		listUsuario = new ArrayList<>();
		for (Endereco u : Enderecos.INSTANCE.allUsers()) {
			if (u.getCep().startsWith(filtro)) {
				listUsuario.add(u);
			}
		}
	}

	public List<Endereco> getListUsuario() {
		return listUsuario;
	}
	
	public String atualizarUsuario(Endereco usuario) {
		this.endereco = usuario;
		return "cadastroEndereco";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<SelectItem> getListSexo() {
		return listSexo;
	}

	public void setListSexo(List<SelectItem> listSexo) {
		this.listSexo = listSexo;
	}

	public List<SelectItem> getListCidade() {
		return listCidade;
	}

	public void setListCidade(List<SelectItem> listCidade) {
		this.listCidade = listCidade;
	}

	public Estado getSelectEstado() {
		return selectEstado;
	}

	public void setSelectEstado(Estado selectEstado) {
		this.selectEstado = selectEstado;
	}

	public List<SelectItem> getListEstados() {
		return listEstados;
	}

	public void setListEstados(List<SelectItem> listEstados) {
		this.listEstados = listEstados;
	}

	public List<SelectItem> getListMunicipios() {
		return listMunicipios;
	}

	public void setListMunicipios(List<SelectItem> listMunicipios) {
		this.listMunicipios = listMunicipios;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void setListEndereco(List<Endereco> listUsuario) {
		this.listUsuario = listUsuario;
	}

}
