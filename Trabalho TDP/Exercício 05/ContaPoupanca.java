/**
 * Exercício 5 — Subclasse ContaPoupanca
 * Disciplina: Técnicas de Programação
 *
 * Herda de Conta e possui rendimento percentual acrescido ao calcular o saldo projetado.
 */
public class ContaPoupanca extends Conta {
    private double percentualRendimento;

    public ContaPoupanca(int numero, String titular, double saldoInicial, double percentualRendimento) {
        super(numero, titular, saldoInicial);
        this.percentualRendimento = percentualRendimento;
    }

    // Sobrescrita (@Override): acrescenta os rendimentos no cálculo do saldo
    @Override
    public double calcularSaldo() {
        return getSaldo() + (getSaldo() * this.percentualRendimento);
    }

    public double getPercentualRendimento() {
        return percentualRendimento;
    }

    public void setPercentualRendimento(double percentualRendimento) {
        this.percentualRendimento = percentualRendimento;
    }
}
