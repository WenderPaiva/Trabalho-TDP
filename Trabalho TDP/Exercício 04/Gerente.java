import java.util.Locale;

/**
 * Exercício 4 — Subclasse Gerente
 * Disciplina: Técnicas de Programação
 *
 * Herda de Funcionario e aplica regra de bonificação fixa de 20% sobre o salário-base.
 */
public class Gerente extends Funcionario {

    public Gerente(String nome, double salarioBase) {
        // Chamada explícita ao construtor da superclasse
        super(nome, salarioBase);
    }

    // Sobrescrita do método (@Override): Salário base + 20% de bônus
    @Override
    public double calcularSalario() {
        return getSalarioBase() * 1.20;
    }

    @Override
    public void exibirInformacoes() {
        System.out.printf(Locale.US, "Colaborador: %-22s | Categoria: %-16s | Base: R$ %9.2f | Salário Final (+20%%): R$ %9.2f%n",
                getNome(), "Gerente", getSalarioBase(), calcularSalario());
    }
}
