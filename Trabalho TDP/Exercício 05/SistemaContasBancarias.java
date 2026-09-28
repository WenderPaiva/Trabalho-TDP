import java.util.Locale;

/**
 * Exercício 5 — Sistema de Contas Bancárias (Classe Executável)
 * Disciplina: Técnicas de Programação
 *
 * Executa rigorosamente as 6 etapas solicitadas no edital:
 * 1. Criar contas correntes;
 * 2. Criar contas poupança;
 * 3. Realizar depósitos;
 * 4. Realizar saques;
 * 5. Calcular o saldo de cada conta (demonstrando o polimorfismo);
 * 6. Exibir os dados finais das contas.
 */
public class SistemaContasBancarias {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("==========================================================================================");
        System.out.println("                   SISTEMA BANCÁRIO — EXECUÇÃO DAS 6 ETAPAS                               ");
        System.out.println("==========================================================================================");

        // ETAPA 1: Criar contas correntes
        System.out.println("\n[ETAPA 1] Criando Contas Correntes...");
        ContaCorrente cc1 = new ContaCorrente(1001, "Lucas Silva", 2000.00, 25.00);
        ContaCorrente cc2 = new ContaCorrente(1002, "Mariana Rios", 3500.00, 30.00);
        System.out.println("  ✓ CC 1001 criada (Titular: Lucas Silva | Saldo Inicial: R$ 2000.00 | Taxa: R$ 25.00)");
        System.out.println("  ✓ CC 1002 criada (Titular: Mariana Rios | Saldo Inicial: R$ 3500.00 | Taxa: R$ 30.00)");

        // ETAPA 2: Criar contas poupança
        System.out.println("\n[ETAPA 2] Criando Contas Poupança...");
        ContaPoupanca cp1 = new ContaPoupanca(2001, "Beatriz Souza", 5000.00, 0.05); // 5% de rendimento
        ContaPoupanca cp2 = new ContaPoupanca(2002, "Fernando Dias", 8000.00, 0.06); // 6% de rendimento
        System.out.println("  ✓ CP 2001 criada (Titular: Beatriz Souza | Saldo Inicial: R$ 5000.00 | Rendimento: 5%)");
        System.out.println("  ✓ CP 2002 criada (Titular: Fernando Dias | Saldo Inicial: R$ 8000.00 | Rendimento: 6%)");

        // ETAPA 3: Realizar depósitos
        System.out.println("\n[ETAPA 3] Realizando Depósitos...");
        cc1.depositar(500.00);
        cp1.depositar(1000.00);

        // ETAPA 4: Realizar saques
        System.out.println("\n[ETAPA 4] Realizando Saques...");
        cc2.sacar(300.00);
        cp2.sacar(1500.00);

        // ETAPA 5: Calcular o saldo de cada conta (demonstrando o polimorfismo)
        System.out.println("\n[ETAPA 5] Calculando o Saldo de Cada Conta via Polimorfismo...");
        System.out.println("  (Armazenando todas as contas em um array polimórfico de tipo base 'Conta')");
        Conta[] contas = { cc1, cc2, cp1, cp2 };

        for (Conta c : contas) {
            // Chamada polimórfica ao método calcularSaldo()
            double saldoCalculado = c.calcularSaldo();
            String tipoConta = (c instanceof ContaCorrente) ? "Conta Corrente" : "Conta Poupança";
            System.out.printf("  [%-14s] Conta: %d | Saldo Bruto: R$ %9.2f | Saldo Ajustado (após regra): R$ %9.2f%n",
                    tipoConta, c.getNumero(), c.getSaldo(), saldoCalculado);
        }

        // ETAPA 6: Exibir os dados finais das contas
        System.out.println("\n[ETAPA 6] Exibição dos Dados Finais de Todas as Contas:");
        System.out.println("------------------------------------------------------------------------------------------");
        for (Conta c : contas) {
            c.exibirDados();
        }
        System.out.println("==========================================================================================");
        System.out.println("Todas as 6 etapas concluídas com total estabilidade e fidelidade ao edital.");
    }
}
