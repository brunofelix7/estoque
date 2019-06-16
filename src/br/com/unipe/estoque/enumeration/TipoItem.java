package br.com.unipe.estoque.enumeration;

public enum TipoItem {
	
	ALIMENTO("Alimento"), 
	ELETRODOMESTICO("Eletrodom�stico"), 
	ELETROPORTATEIS("Eletroport�teis"),
	INFORMATICA("Inform�tica");

	private String label;

	private TipoItem(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
