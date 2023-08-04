package br.edu.cesarschool.next.oo.entidade;

import javax.print.attribute.standard.Media;

import br.edu.cesarschool.next.oo.negocio.MediatorContaCorrente;

public class ContaPoupanca extends ContaCorrente{
    private double percentualBonus;  
    private MediatorContaCorrente MediatorContaCorrente;
    public ContaPoupanca() {
        
    }
    public ContaPoupanca(double percentualBonus) {
        this.percentualBonus = percentualBonus;
    }       
    public ContaPoupanca(String numero, double saldo, String nomeCorrentista, double percentualBonus) {
        super(numero, saldo, nomeCorrentista);
        this.percentualBonus = percentualBonus;
    }
    public double getPercentualBonus() {
        return percentualBonus;
    }
    public void setPercentualBonus(double percentualBonus) {
        this.percentualBonus = percentualBonus;
    }
    //creditar- está usando a função da mãe porque o saldo foi pedido para não ser setado
    @Override
    public void creditar(double valor){
        super.creditar(super.getSaldo() + valor *(1 + percentualBonus / 100));
    }
        //reuso toString da classe ContaCorrente
        public String toString() {
            return getNomeCorrentista() + " , " + getNumero() + " , " + getSaldo() + " , " + getPercentualBonus();
        }
}
