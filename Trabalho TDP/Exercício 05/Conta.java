import java.util.Locale;

/**
 * Exercício 5 — Superclasse Conta Bancária
 * Disciplina: Técnicas de Programação
 *
 * Superclasse que encapsula os atributos essenciais de uma conta bancária
 * e define operações seguras de depósito, saque e cálculo de saldo polimórfico.
 */
public class Conta {
    private int numero;
    private String titular;
    private double saldo;

    public Conta(int numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = (saldoInicial >= 0) ? saldoInicial : 0.0;
    }

    // Operação de depósito segura: aceita apenas valores positivos
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.printf(Locale.US, "    [Depósito] Conta %d (+ R$ %.2f) | Novo saldo: R$ %.2f%n",
                    this.numero, valor, this.saldo);
        } else {
            System.out.println("    [Erro] O valor de depósito deve ser positivo.");
        }
    }

    // Operação de saque segura: verifica disponibilidade de saldo
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("    [Erro] O valor do saque deve ser positivo.");
            return;
        }

        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.printf(Locale.US, "    [Saque] Conta %d (- R$ %.2f) | Novo saldo: R$ %.2f%n",
                    this.numero, valor, this.saldo);
        } else {
            System.out.printf(Locale.US, "    [Recusado] Saldo insuficiente na Conta %d (Tentativa: R$ %.2f | Saldo: R$ %.2f)%n",
                    this.numero, valor, this.saldo);
        }
    }

    // Método polimórfico: na classe base retorna o saldo nominal
    public double calcularSaldo() {
        return this.saldo;
    }

    public void exibirDados() {
        System.out.printf(Locale.US, "Conta nº %-5d | Titular: %-18s | Saldo em Conta: R$ %9.2f | Saldo Ajustado: R$ %9.2f%n",
                numero, titular, saldo, calcularSaldo());
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
