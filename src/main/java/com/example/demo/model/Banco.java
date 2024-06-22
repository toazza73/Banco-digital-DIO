package com.example.demo.model;

import java.util.*;

public class Banco {
	private String nome;
	public List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public Conta buscarConta(int numero) {
		for (Conta conta : contas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		System.out.println("Conta não encontrada!");
		return null;
	}

	public void listarContas() {
		if (contas.isEmpty()) {
			System.out.println("O banco não possui contas cadastradas.");
			return;
		}
		System.out.println("---------- Lista de Contas ----------");
		for (Conta conta : contas) {
			System.out.println("Número: " + conta.getNumero());
			System.out.println("Titular: " + conta.cliente.getNome());
			System.out.println("Saldo: R$ " + conta.getSaldo());
			System.out.println("---------------------------------");
		}
	}
}
