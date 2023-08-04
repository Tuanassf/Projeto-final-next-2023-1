package br.edu.cesarschool.next.oo.negocio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.edu.cesarschool.next.oo.dao.DAOContaCorrente;
import br.edu.cesarschool.next.oo.entidade.ContaCorrente;
import br.edu.cesarschool.next.oo.entidade.ContaPoupanca;

public class MediatorContaCorrente {
    private DAOContaCorrente daoContaCorrente = new DAOContaCorrente();
    public String incluir(ContaCorrente conta) {
        if(conta == null){
            return "Conta não informada!";
        } else if(stringNulaOuVazia(conta.getNumero())) {
            return "Número da conta não informada";
        } else if(conta.getNumero().length() < 5 || conta.getNumero().length() > 8) {
            return "Número da conta deve ter tamanho entre 5 e 8 caracteres";
        } else if(conta.getSaldo() < 0) {
            return "Saldo deve ser maior ou igual a zero";  
        } else if(conta.getNomeCorrentista().length()>=60){
            return "Nome deve ter tamanho máximo de 60 caracteres";        
        } else if(stringNulaOuVazia(conta.getNomeCorrentista())) {
            return "Nome do correntista não foi informado";
        } 
            if(conta instanceof ContaPoupanca){
                ContaPoupanca poup = (ContaPoupanca) conta;
                if(poup.getPercentualBonus()<0){
                    return " O percentual de bônus deve ser maior ou igual a zero";
            } else {
                boolean retorno = daoContaCorrente.incluir(conta);
                if(!retorno) {
                     return "Conta existente!";
                } 
             return null;  
            }
            }
         else {
            boolean retorno = daoContaCorrente.incluir(conta);
            if(!retorno) {
                return "Conta existente!";
            } 
        }    
        return null;                   
    }
    public String creditar(double valor, String numero){
        if(valor<0){
            return "Valor precisa ser maior ou igual a zero";
        } else if (stringNulaOuVazia(numero)){
            return "Número da conta não informado";
        } else {
             ContaCorrente conta = daoContaCorrente.buscar(numero);
            if(conta==null) {
                return "Conta não existente!";
            } else {
                conta.creditar(valor);
                daoContaCorrente.alterar(conta);
            }
        }
    return null;
    }
    public String debitar(double valor, String numero){
        if(valor<0){
            return "Valor deve ser maior ou igual a zero";
        } else if (stringNulaOuVazia(numero)){
            return "Número da conta não informado";
        } else {
            ContaCorrente conta = daoContaCorrente.buscar(numero);
            if(conta==null){
                return "Conta inexistente!";
            } else {
                if(conta.getSaldo() < valor){
                    return " Saldo atual é menor que valor a debitar";
                } else {
                    conta.debitar(valor);
                    daoContaCorrente.alterar(conta);
                    return null;
                }
            }
        }
    }
    public ContaCorrente buscar(String numero) {
        if (stringNulaOuVazia(numero)) {
            return null; 
        } else {		
            return daoContaCorrente.buscar(numero);
        }
    }
    public List<ContaCorrente> gerarRelatorioGeral() {
		ContaCorrente[] contas = daoContaCorrente.buscarTodos();
		List<ContaCorrente> listaContaCorrente = Arrays.asList(contas);
		Collections.sort(listaContaCorrente, new ComparadorContaCorrenteSaldo());
		return listaContaCorrente;
		
	}
    private boolean stringNulaOuVazia(String valor) {
		return valor == null || valor.trim().equals("");
	}
}
