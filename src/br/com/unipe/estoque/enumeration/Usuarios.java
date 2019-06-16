package br.com.unipe.estoque.enumeration;

import java.util.ArrayList;
import java.util.List;

import br.com.unipe.estoque.model.Usuario;

public enum Usuarios {

	INSTANCE;
	private static Integer id = 0;

	private List<Usuario> listUsuarios;

	private Usuarios() {
		listUsuarios = new ArrayList<>();
	}

	public void addUser(Usuario u) {
		id = id + 1;
		u.setId(id);
		listUsuarios.add(u);
	}
	
	public void updateUser(Usuario u) {
		for (int i = 0; i < listUsuarios.size(); i++) {
			if(listUsuarios.get(i).getId() == u.getId()) {
				listUsuarios.set(i, u);
			}
		}
	}
	
	public void removeUser(Usuario u) {
		listUsuarios.remove(u);
	}
	
	public boolean isIdRepetido(Usuario u) {
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

	public List<Usuario> allUsers() {
		return listUsuarios;
	}
}
