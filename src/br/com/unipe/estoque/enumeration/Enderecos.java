package br.com.unipe.estoque.enumeration;

import java.util.ArrayList;
import java.util.List;

import br.com.unipe.estoque.model.Endereco;

public enum Enderecos {

	INSTANCE;
	private static Integer id = 0;

	private List<Endereco> listUsuarios;

	private Enderecos() {
		listUsuarios = new ArrayList<>();
	}

	public void addUser(Endereco u) {
		id = id + 1;
		u.setId(id);
		listUsuarios.add(u);
	}
	
	public void updateUser(Endereco u) {
		for (int i = 0; i < listUsuarios.size(); i++) {
			if(listUsuarios.get(i).getId() == u.getId()) {
				listUsuarios.set(i, u);
			}
		}
	}
	
	public void removeUser(Endereco u) {
		listUsuarios.remove(u);
	}
	
	public boolean isIdRepetido(Endereco u) {
		if(u.getId() != null) {
			for (int i = 0; i < listUsuarios.size(); i++) {
				if(listUsuarios.get(i).getId() == u.getId()) {
					return true;
				}
				return false;
			}
			return false;
		} else {
			return false;			
		}
	}

	public List<Endereco> allUsers() {
		return listUsuarios;
	}
}
