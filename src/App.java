import br.edu.cesarschool.next.oo.entidade.ContaCorrente;
import br.edu.cesarschool.next.oo.entidade.ContaPoupanca;

public class App {
    public static void main(String[] args) throws Exception {
        ContaCorrente c1 = new ContaCorrente("12345", 100.00, "Tuana");
        System.out.println(c1);

        c1.creditar(10.00);
        c1.debitar(50.00);
        c1.creditar(0.0);
        System.out.println(c1);

        ContaPoupanca p1 = new ContaPoupanca("12345", 5.00, "Tuana", 0);
        
        System.out.println("Poupança :" + p1);
    }
}
