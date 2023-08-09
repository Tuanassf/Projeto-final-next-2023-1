package br.edu.cesarschool.next.oo.entidade;


public class ContaPoupanca extends ContaCorrente{
    private double percentualBonus;  
    
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
            return " \n " 
            + "Nome: " + getNomeCorrentista() + "\n " 
            + "Número da conta poupança: "+ getNumero() +  "\n" 
            + " Saldo da conta poupança: " + getSaldo() + "\n" 
            + " Percentual Bônus: " + getPercentualBonus() + "\n"  
            + " Data de criação: " + super.getDataHoraCriacao();  
        }
}
