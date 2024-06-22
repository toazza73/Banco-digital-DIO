package com.example.demo.model;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

//	@Override
//	public void sacar(Conta conta, double valor) {
//		conta.saldo -= valor;
//	}
//
//	@Override
//	public void depositar(Conta conta, double valor) {
//
//	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}
