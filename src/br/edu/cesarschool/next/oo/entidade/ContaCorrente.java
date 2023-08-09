package br.edu.cesarschool.next.oo.entidade;

import java.io.Serializable;

public class ContaCorrente extends RegistroIdentificavel{
    private static final long serialVersionUID = 1L;
    private String numero;
    private double saldo;
    private String nomeCorrentista;
    public ContaCorrente(){

    }
    public ContaCorrente(String numero, double saldo, String nomeCorrentista) {
        this.numero = numero;
        this.saldo = saldo;
        this.nomeCorrentista = nomeCorrentista;
    }
    public String getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getNomeCorrentista() {
        return nomeCorrentista;
    }
    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    //creditar
    public void creditar(double valor){
        saldo = saldo + valor;
    } 
     //debitar
    public void debitar(double valor){
        saldo = saldo - valor;
    } 
    @Override
	public String toString() {
		return " \n " 
        + "Nome: " + nomeCorrentista + " \n " 
        + "Número conta corrente:" + numero + " \n "  
        + "Saldo conta corrente:" + saldo + " \n " 
        + "Data de criação: " + getDataHoraCriacao();
	}
    @Override
    public String obterChave() {
        return numero;
    }
}
