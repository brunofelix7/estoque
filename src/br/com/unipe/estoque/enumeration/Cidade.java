package br.com.unipe.estoque.enumeration;

public enum Cidade {

	JP("João Pessoa", "PB"), PT("Patos", "PB"), CG("Campina Grande", "PB"), RE("Recife", "PE"), EX("Exu",
			"PE"), NT("Natal", "RN");

	private String label;
	private String estado;

	private Cidade(String label, String estado) {
		this.label = label;
		this.estado = estado;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
