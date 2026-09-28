import java.util.Locale;
import java.util.Scanner;

/**
 * Exercício 2 — Sistema de Vendas (Versão Robusta e Completa)
 * Disciplina: Técnicas de Programação
 *
 * Objetivo: Coletar vendas diárias, computar métricas estatísticas básicas
 * (total, maior, menor, média, vendas acima de R$ 500) e calcular a comissão por faixa.
 *
 * Melhorias implementadas:
 * - Valida se a quantidade de vendas é maior que zero para evitar divisão por zero (NaN).
 * - Aceita números decimais tanto com ponto quanto com vírgula (ex: 1500.50 ou 1500,50).
 * - Garante que vendas não sejam negativas.
 */
public class SistemaVendas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===================================================");
        System.out.println("          SISTEMA DE GESTÃO DE VENDAS             ");
        System.out.println("===================================================");
        System.out.print("Informe a quantidade de vendas realizadas hoje: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Erro: A quantidade de vendas deve ser um número inteiro.");
            scanner.close();
            return;
        }

        int quantidadeVendas = scanner.nextInt();

        // Validação de regra de negócio: quantidade deve ser positiva
        if (quantidadeVendas <= 0) {
            System.out.println("Atenção: A quantidade de vendas deve ser no mínimo 1.");
            scanner.close();
            return;
        }

        double totalVendido = 0.0;
        double maiorVenda = 0.0;
        double menorVenda = 0.0;
        int vendasAcima500 = 0;

        // Laço de repetição para entrada e processamento de cada venda
        for (int i = 1; i <= quantidadeVendas; i++) {
            System.out.print("Digite o valor da venda #" + i + ": R$ ");
            
            // Permite digitação com ponto (150.50) ou com vírgula (150,50)
            String entrada = scanner.next().replace(",", ".");
            double valorVenda;

            try {
                valorVenda = Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um valor numérico para a venda.");
                i--; // Repete a mesma venda
                continue;
            }

            if (valorVenda < 0) {
                System.out.println("Atenção: O valor da venda não pode ser negativo. Tente novamente.");
                i--; // Repete a mesma venda
                continue;
            }

            totalVendido += valorVenda;

            // Na primeira iteração, inicializamos maior e menor com o primeiro valor real
            if (i == 1) {
                maiorVenda = valorVenda;
                menorVenda = valorVenda;
            } else {
                if (valorVenda > maiorVenda) {
                    maiorVenda = valorVenda;
                }
                if (valorVenda < menorVenda) {
                    menorVenda = valorVenda;
                }
            }

            // Contagem de vendas estritamente superiores a R$ 500,00
            if (valorVenda > 500.00) {
                vendasAcima500++;
            }
        }

        // Média aritmética segura (garantida quantidadeVendas > 0)
        double mediaVendas = totalVendido / quantidadeVendas;

        // Cálculo da comissão por faixas sobre o total vendido
        double percentualComissao;
        if (totalVendido <= 1000.00) {
            percentualComissao = 0.03; // 3%
        } else if (totalVendido <= 5000.00) {
            percentualComissao = 0.05; // 5%
        } else {
            percentualComissao = 0.08; // 8%
        }

        double valorComissao = totalVendido * percentualComissao;

        // Exibição clara e organizada do relatório
        System.out.println("\n================ RELATÓRIO DO DIA ================");
        System.out.printf(Locale.US, "1. Valor total vendido:                    R$ %10.2f%n", totalVendido);
        System.out.printf(Locale.US, "2. Maior venda registrada:                 R$ %10.2f%n", maiorVenda);
        System.out.printf(Locale.US, "3. Menor venda registrada:                 R$ %10.2f%n", menorVenda);
        System.out.printf(Locale.US, "4. Média das vendas:                       R$ %10.2f%n", mediaVendas);
        System.out.printf(Locale.US, "5. Quantidade de vendas acima de R$ 500:   %10d%n", vendasAcima500);
        System.out.printf(Locale.US, "6. Comissão do vendedor (%.0f%%):             R$ %10.2f%n", (percentualComissao * 100), valorComissao);
        System.out.println("===================================================");

        scanner.close();
    }
}
