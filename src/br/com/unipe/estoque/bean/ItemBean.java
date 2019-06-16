package br.com.unipe.estoque.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.unipe.estoque.enumeration.Items;
import br.com.unipe.estoque.enumeration.TipoItem;
import br.com.unipe.estoque.model.Item;

@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemBean {

	private Item item;
	private List<Item> listItem;

	private TipoItem selectTipos;
	private List<SelectItem> listTipos;

	private String filtro;

	public ItemBean() {
		item = new Item();
		listItem = new ArrayList<>();
		listItem = Items.INSTANCE.allItems();
	}

	@PostConstruct
	public void initTipos() {
		listTipos = new ArrayList<>();
		for (TipoItem s : TipoItem.values()) {
			listTipos.add(new SelectItem(s, s.getLabel()));
		}
	}

	public String prepararCadastro() {
		item = new Item();
		return "cadastroItem";
	}

	public String prepararList() {
		return "";
	}

	public String removerItem(Item item) {
		Items.INSTANCE.removeUser(item);
		listItem = Items.INSTANCE.allItems();
		return "index";
	}
	
	public String adicionarItem() {
		if(Items.INSTANCE.isIdRepetido(item)) {
			Items.INSTANCE.updateUser(item);
		} else {
			Items.INSTANCE.addUser(item);
		}
		listItem = Items.INSTANCE.allItems();
		return "listarItems";
	}

	public void filtrarTabela() {
		System.out.println("Filtrar " + filtro);
		listItem = new ArrayList<>();
		for (Item u : Items.INSTANCE.allItems()) {
			System.out.println("agora o label é" + u.getTipo().getLabel());
			if (u.getTipo().getLabel().toLowerCase().startsWith(filtro.toLowerCase())) {
				System.out.println("UHKUHYIKU" + u.getTipo().getLabel());
				listItem.add(u);
			}
		}
	}

	public List<Item> getListItem() {
		return listItem;
	}
	
	public String atualizarItem(Item item) {
		this.item = item;
		return "cadastroItem";
	}

	public String carregarDetalhes(Item item) {
		this.item = item;
		return "detalhesItem";
	}

	public void carregarDetalhes2(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public TipoItem getSelectTipos() {
		return selectTipos;
	}

	public void setSelectTipos(TipoItem selectTipos) {
		this.selectTipos = selectTipos;
	}

	public List<SelectItem> getListTipos() {
		return listTipos;
	}

	public void setListTipos(List<SelectItem> listTipos) {
		this.listTipos = listTipos;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}

}
