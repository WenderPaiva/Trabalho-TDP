/**
 * Exercício 5 — Subclasse ContaCorrente
 * Disciplina: Técnicas de Programação
 *
 * Herda de Conta e possui taxa de manutenção mensal deduzida ao calcular o saldo líquido.
 */
public class ContaCorrente extends Conta {
    private double taxaManutencao;

    public ContaCorrente(int numero, String titular, double saldoInicial, double taxaManutencao) {
        super(numero, titular, saldoInicial);
        this.taxaManutencao = taxaManutencao;
    }

    // Sobrescrita (@Override): deduz a taxa de manutenção no cálculo do saldo
    @Override
    public double calcularSaldo() {
        return getSaldo() - this.taxaManutencao;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }
}
