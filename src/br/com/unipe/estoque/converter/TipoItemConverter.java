package br.com.unipe.estoque.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.unipe.estoque.enumeration.TipoItem;

@FacesConverter("tipoItemConverter")
public class TipoItemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 != null && !arg2.equals("")) {
			for (TipoItem s : TipoItem.values()) {
				if (arg2.equals(s.getLabel())) {
					return s;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null && !arg2.equals("")) {
			TipoItem s = (TipoItem) arg2;
			return s.getLabel();
		}
		return null;
	}

}