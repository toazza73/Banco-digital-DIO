package com.example.demo.model;

public interface IConta {
	
	public void sacar(double valor);
	public void depositar(double valor);
	//public void transferir(double valor, Conta contaFonte, Conta contaDestino);
	public void imprimirExtrato();
}