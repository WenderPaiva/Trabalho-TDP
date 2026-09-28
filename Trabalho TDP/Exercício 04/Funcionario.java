import java.util.Locale;

/**
 * Exercício 4 — Superclasse Funcionario
 * Disciplina: Técnicas de Programação
 *
 * Classe base que define atributos comuns, encapsulamento e método polimórfico calcularSalario().
 */
public class Funcionario {
    private String nome;
    private double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = (salarioBase >= 0) ? salarioBase : 0.0;
    }

    // Método que será sobrescrito pelas subclasses (Polimorfismo dinâmico)
    public double calcularSalario() {
        return this.salarioBase;
    }

    // Método de exibição que pode ser invocado polimorficamente
    public void exibirInformacoes() {
        System.out.printf(Locale.US, "Colaborador: %-22s | Categoria: %-16s | Base: R$ %9.2f | Salário Final: R$ %9.2f%n",
                nome, "Padrão", salarioBase, calcularSalario());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase >= 0) {
            this.salarioBase = salarioBase;
        }
    }
}
