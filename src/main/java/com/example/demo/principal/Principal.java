package com.example.demo.principal;

import com.example.demo.model.Cliente;
import com.example.demo.model.Conta;
import com.example.demo.model.ContaCorrente;
import com.example.demo.model.ContaPoupanca;
import com.example.demo.model.Banco;

import java.util.Scanner;

public class Principal {

	private static Scanner scanner = new Scanner(System.in);

	Banco banco = new Banco("Banco Teste");

	public void exibeMenu() {

		var opcao = -1;

		while (opcao != 9) {
			var menu = """
					\n==== Menu Banco Digital ====
					
					1- Criar Conta
					2- Depositar
					3- Sacar
					4- Transferir
					5- Ver saldo
					6- Listar Contas
					                    
					9 - Sair
					==============================
					""";

			System.out.println(menu);
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					criarConta();
					break;
				case 2:
					fazerDeposito();
					break;
				case 3:
					fazerSaque();
					break;
				case 4:
					fazerTransferencia();
					break;
				case 5:
					verSaldo();
					break;
				case 6:
					banco.listarContas();
					break;
				case 9:
					System.out.println("Encerrando a aplicação!");
					break;
				default:
					System.out.println("Opção inválida!");
			}
		}
	}

		public void criarConta () {
			System.out.println("\n==== Criar Conta ====");

			System.out.print("Nome: ");
			String nome = scanner.nextLine();
			System.out.print("RG: ");
			String RG = scanner.nextLine();
			System.out.println();

			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setRG(RG);

			Conta cc = new ContaCorrente(cliente);
			Conta poupanca = new ContaPoupanca(cliente);
			banco.contas.add(cc);
			banco.contas.add(poupanca);

			System.out.println("Nome: " + cliente.getNome());
			System.out.println("RG: " + cliente.getRG());
			System.out.println("Agencia: " + cc.getAgencia());
			System.out.println("C.C.: " + cc.getNumero());
			System.out.println("Poupanca: " + poupanca.getNumero() + "\n");
		}

		public void fazerDeposito() {
			System.out.println("\n==== Depositar ====");
			System.out.print("Digite o numero da conta: ");
			int numeroConta = scanner.nextInt();
			var contaDestino = banco.buscarConta(numeroConta);

			System.out.print("Digite o valor: ");
			double valorDeposito = scanner.nextDouble();

			contaDestino.depositar(valorDeposito);
			contaDestino.imprimirExtrato();
			}

		public void fazerSaque() {
			System.out.println("\n====== Sacar ======");
			System.out.print("Digite o numero da conta: ");
			int numeroConta = scanner.nextInt();
			var contaSaque = banco.buscarConta(numeroConta);

			System.out.print("Digite o valor: ");
			double valorSaque = scanner.nextDouble();
			var saldo = contaSaque.getSaldo();

			if (valorSaque > saldo) {
				System.out.println("Sem saldo suficiente para Sacar");
			} else {
				contaSaque.sacar(valorSaque);
				contaSaque.imprimirExtrato();
			}
		}

	public void fazerTransferencia() {
		System.out.println("\n====== Transferir ======");
		System.out.print("Digite o numero da conta Fonte: ");
		int numeroContaFonte = scanner.nextInt();
		var contaFonte = banco.buscarConta(numeroContaFonte);

		System.out.print("Digite o numero da conta Destino: ");
		int numeroContaDestino = scanner.nextInt();
		var contaDestino = banco.buscarConta(numeroContaDestino);

		System.out.print("Digite o valor a ser transferido: ");
		double valorTransferir = scanner.nextDouble();

		var saldo = contaFonte.getSaldo();

		if (valorTransferir > saldo) {
			System.out.println("Sem saldo suficiente para transferir");
		} else {
			contaFonte.sacar(valorTransferir);
			contaDestino.depositar(valorTransferir);
			contaDestino.imprimirExtrato();
			contaFonte.imprimirExtrato();
		}
	}
	public void verSaldo() {
		System.out.println("\n====== Saldo da conta ======");
		System.out.print("Digite o numero da conta: ");
		int numeroConta = scanner.nextInt();
		var saldoConta = banco.buscarConta(numeroConta);
		System.out.println("Saldo -> R$ " + saldoConta.getSaldo());
	}
}



