package br.com.unipe.estoque.enumeration;

public enum Estado {

	PB("Paraiba"), PE("Pernambuco"), RN("Rio Grande do Norte");

	private String label;

	private Estado(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
