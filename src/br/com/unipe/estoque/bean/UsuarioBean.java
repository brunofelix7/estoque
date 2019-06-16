package br.com.unipe.estoque.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.unipe.estoque.enumeration.Cidade;
import br.com.unipe.estoque.enumeration.Estado;
import br.com.unipe.estoque.enumeration.Sexo;
import br.com.unipe.estoque.enumeration.Usuarios;
import br.com.unipe.estoque.model.Usuario;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;
	private List<SelectItem> listSexo;
	private List<SelectItem> listCidade;
	private List<Usuario> listUsuario;

	private Estado selectEstado;
	private List<SelectItem> listEstados;
	private List<SelectItem> listMunicipios;

	private String filtro;

	public UsuarioBean() {
		usuario = new Usuario();
		listMunicipios = new ArrayList<>();
		listUsuario = new ArrayList<>();
		listUsuario = Usuarios.INSTANCE.allUsers();
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
		usuario = new Usuario();
		return "cadastroUsuario";
	}

	public String prepararList() {
		return "";
	}

	public String removerUsuario(Usuario usuario) {
		Usuarios.INSTANCE.removeUser(usuario);
		listUsuario = Usuarios.INSTANCE.allUsers();
		return "index";
	}
	
	public String adicionarUsuario() {
		usuario.setCep(usuario.getCep().replace("-", ""));
		if(Usuarios.INSTANCE.isIdRepetido(usuario)) {
			Usuarios.INSTANCE.updateUser(usuario);
		} else {
			Usuarios.INSTANCE.addUser(usuario);
		}
		listUsuario = Usuarios.INSTANCE.allUsers();
		return "listarUsuarios";
	}

	public void filtrarTabela() {
		listUsuario = new ArrayList<>();
		for (Usuario u : Usuarios.INSTANCE.allUsers()) {
			if (u.getUsername().startsWith(filtro)) {
				listUsuario.add(u);
			}
		}
	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}
	
	public String atualizarUsuario(Usuario usuario) {
		this.usuario = usuario;
		return "cadastroUsuario";
	}

	public String carregarDetalhes(Usuario usuario) {
		this.usuario = usuario;
		return "detalhesUsuario";
	}

	public void carregarDetalhes2(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

}
