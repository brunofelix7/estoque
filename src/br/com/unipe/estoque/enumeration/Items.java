package br.com.unipe.estoque.enumeration;

import java.util.ArrayList;
import java.util.List;

import br.com.unipe.estoque.model.Item;

public enum Items {

	INSTANCE;
	private static Integer id = 0;

	private List<Item> listItems;

	private Items() {
		listItems = new ArrayList<>();
	}

	public void addUser(Item u) {
		id = id + 1;
		u.setId(id);
		listItems.add(u);
	}
	
	public void updateUser(Item u) {
		for (int i = 0; i < listItems.size(); i++) {
			if(listItems.get(i).getId() == u.getId()) {
				listItems.set(i, u);
			}
		}
	}
	
	public void removeUser(Item u) {
		listItems.remove(u);
	}
	
	public boolean isIdRepetido(Item u) {
		if(u.getId() != null) {
			for (int i = 0; i < listItems.size(); i++) {
				if(listItems.get(i).getId() == u.getId()) {
					return true;
				}
				return false;
			}
			return false;
		} else {
			return false;			
		}
	}

	public List<Item> allItems() {
		return listItems;
	}
}
