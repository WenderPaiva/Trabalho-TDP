import java.util.Locale;

/**
 * Exercício 3 — Classe Funcionario (POO Básica)
 * Disciplina: Técnicas de Programação
 *
 * Demonstra encapsulamento com atributos privados, construtor, getters/setters
 * e métodos de negócio para reajuste salarial e cálculo de rendimento anual.
 */
public class Funcionario {
    // Atributos privados (Encapsulamento)
    private String nome;
    private String cargo;
    private double salario;

    // Construtor completo
    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = (salario >= 0) ? salario : 0.0;
    }

    // Método para aplicar percentual de aumento sobre o salário atual
    public void aumentarSalario(double percentual) {
        if (percentual > 0) {
            this.salario += this.salario * (percentual / 100.0);
        } else {
            System.out.printf("Aviso: Percentual de reajuste deve ser positivo (informado: %.1f%%).%n", percentual);
        }
    }

    // Método para calcular o salário anual (12 meses)
    public double calcularSalarioAnual() {
        return this.salario * 12;
    }

    // Método para exibir dados formatados do funcionário
    public void exibirDados() {
        System.out.printf(Locale.US, "Nome: %-20s | Cargo: %-22s | Salário Mensal: R$ %9.2f | Salário Anual: R$ %10.2f%n",
                nome, cargo, salario, calcularSalarioAnual());
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        }
    }
}
