package br.edu.cesarschool.next.oo.apresentacao;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import br.edu.cesarschool.next.oo.entidade.ContaCorrente;
import br.edu.cesarschool.next.oo.entidade.ContaPoupanca;
import br.edu.cesarschool.next.oo.negocio.MediatorContaCorrente;

public class TelaContaCorrente {
    private static final Scanner ENTRADA = new Scanner(System.in);
    private MediatorContaCorrente mediatorConta = new MediatorContaCorrente();
    
    public TelaContaCorrente() {
    }

    public void iniciarTela() {
		int opcao = 0;
		do {
			System.out.println("Escolha uma opção: ");
			System.out.println("1- Incluir conta");
			System.out.println("2- Creditar conta");
			System.out.println("3- Debitar conta");
            System.out.println("4- Buscar conta");
			System.out.println("5- Gerar relatório geral de contas");
			System.out.println("6- Excluir conta");
			System.out.println("7- Sair");
			opcao = ENTRADA.nextInt();
			if (opcao == 1) {
				incluir();
			} else if (opcao == 2) {
				creditar();
			} else if (opcao == 3) {
				debitar();
			} else if (opcao == 4) {
				contaCorrenteBuscar();
			} else if (opcao == 5) {
				gerarRelatorioGeralContasCorrente();
			} else if (opcao == 6) {
				excluir();
			}
		} while(opcao != 7);
	}
	
    private void incluir() {
		String numero = null;
        double saldo = 0;
        String nomeCorrentista = null;
        String contaPoupanca = "";
        double percentualBonus = 0;
        
        System.out.println("Digite o número da conta: ");
        numero = ENTRADA.next();
        System.out.println("Digite o saldo:");
        saldo = ENTRADA.nextDouble();
        System.out.println("Digite o nome do correntista: ");
        nomeCorrentista = ENTRADA.next();
        System.out.println("A conta corrente a ser incluída é uma conta poupança?: "+ "S" + "/" + "N");
        contaPoupanca = ENTRADA.next();

        
        if (Objects.equals(contaPoupanca, "S")) {
            System.out.println("Digite o percentual de bonus");
            percentualBonus = ENTRADA.nextDouble();
            ContaPoupanca conta = new ContaPoupanca(numero, saldo, nomeCorrentista, percentualBonus);
            String mensagem = mediatorConta.incluir(conta);
               
            if(mensagem == null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM, dd, yyyy HH:mm:ss");
                String formattedDateTime = conta.getDataHoraCriacao().format(formatter);
                System.out.println("Conta poupança incluída com sucesso. Data e hora: " + formattedDateTime + "\n");
            } else {
                System.out.println(mensagem);
            }

        } else {
            ContaCorrente conta = new ContaCorrente(numero, saldo, nomeCorrentista);
            String mensagem = mediatorConta.incluir(conta);

            if(mensagem == null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM, dd, yyyy HH:mm:ss");
                String formattedDateTime = conta.getDataHoraCriacao().format(formatter);
                System.out.println("Conta corrente incluída com sucesso. Data e hora: " + formattedDateTime + "\n");
				
            } else {
                System.out.println(mensagem);
            }
        }                         
	}
	private void creditar() {
		String numero = null;
		double valor = 0;
		System.out.println("Digite o número da conta: ");
		numero = ENTRADA.next();
		System.out.println("Digite o valor a ser creditado: ");
		valor = ENTRADA.nextDouble();
		String mensagem = mediatorConta.creditar(valor, numero);
		if (mensagem == null) {
			System.out.println("Sucesso no creditar!");
		} else {
			System.out.println(mensagem); 
		}		
	}
    private void debitar() {
		String numero = null;
		double valor = 0;
		System.out.println("Digite o número da conta: ");
		numero = ENTRADA.next();
		System.out.println("Digite o valor a ser debitado: ");
		valor = ENTRADA.nextDouble();
		String mensagem = mediatorConta.debitar(valor, numero);
		if (mensagem == null) {
			System.out.println("Sucesso no debitar!");
		} else {
			System.out.println(mensagem); 
		}		
	}
	private void contaCorrenteBuscar() {
		String numero = null;
		System.out.println("Digite o código: ");
		numero = ENTRADA.next();
		ContaCorrente conta = mediatorConta.buscar(numero);
		if (conta == null) {
			System.out.println("Conta não existente!");
		} else {
			System.out.println("Conta encontrada"); 
			System.out.println("Número: " + conta.getNumero());
			System.out.println("Nome correntista: " + conta.getNomeCorrentista());
			System.out.println("Saldo: " + conta.getSaldo());
		}		
	}	
	private void gerarRelatorioGeralContasCorrente() {
		List<ContaCorrente> contas = mediatorConta.gerarRelatorioGeral();
		for (ContaCorrente conta : contas) {
			System.out.println(conta);
		}
	}
	private void excluir() {
		String numero = null;
		System.out.println("Digite o número da conta que deseja excluir: ");
		numero = ENTRADA.next();
		String mensagem = mediatorConta.excluir(numero);
		if (mensagem == null) {
			System.out.println("Conta excluída com sucesso!");
		} else {
			System.out.println(mensagem); 
		}		
	}
}


