import java.util.Locale;

/**
 * Exercício 4 — Subclasse Vendedor
 * Disciplina: Técnicas de Programação
 *
 * Herda de Funcionario, possui atributo próprio (totalVendas) e comissão de 10% sobre vendas.
 */
public class Vendedor extends Funcionario {
    private double totalVendas;

    public Vendedor(String nome, double salarioBase, double totalVendas) {
        super(nome, salarioBase);
        this.totalVendas = (totalVendas >= 0) ? totalVendas : 0.0;
    }

    // Sobrescrita do método (@Override): Salário base + 10% do total de vendas
    @Override
    public double calcularSalario() {
        return getSalarioBase() + (this.totalVendas * 0.10);
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf(Locale.US, "Colaborador: %-22s | Categoria: %-16s | Base: R$ %9.2f | Vendas: R$ %8.2f | Final: R$ %9.2f%n",
                getNome(), "Vendedor", getSalarioBase(), totalVendas, calcularSalario());
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        if (totalVendas >= 0) {
            this.totalVendas = totalVendas;
        }
    }
}
