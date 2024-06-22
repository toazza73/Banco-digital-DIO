package com.example.demo.model;

public class Cliente {
	private String nome;
	private String RG;


	public Cliente() {	}

	public Cliente(String nome, String RG) {
		this.nome = nome;
		this.RG = RG;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRG() {	return RG;}
	public void setRG(String RG) { this.RG = RG;}

}
