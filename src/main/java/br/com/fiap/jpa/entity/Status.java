package br.com.fiap.jpa.entity;

public enum Status {

	ATIVO('A'),
	INATIVO('I');
	
	private char valor;
	
	private Status(char valor) {
		this.valor = valor;
	}

	public char getValor() {
		return valor;
	}
}
