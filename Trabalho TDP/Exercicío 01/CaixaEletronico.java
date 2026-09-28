
import java.util.Scanner;

/**
 * Exercício 1 — Caixa Eletrônico (Versão Robusta e Completa) Disciplina:
 * Técnicas de Programação
 *
 * Objetivo: Calcular a quantidade mínima de cédulas para saque utilizando
 * estruturas de repetição e condicionais.
 *
 * Solução inteligente de dispensação: - Cédulas válidas: R$ 200, 100, 50, 20,
 * 10, 5 e 2. - Evita o travamento do algoritmo guloso tradicional para valores
 * como R$ 6, R$ 11, R$ 13, garantindo que restos 1 e 3 sejam convertidos na
 * combinação correta de notas de 5 e 2. - Valida entradas nulas, negativas ou
 * impossíveis (R$ 1 e R$ 3).
 */
public class CaixaEletronico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("           CAIXA ELETRÔNICO             ");
        System.out.println("========================================");
        System.out.print("Digite o valor para saque: R$ ");

        // Validação de entrada numérica
        if (!scanner.hasNextInt()) {
            System.out.println("Erro: Por favor, digite um número inteiro válido.");
            scanner.close();
            return;
        }

        int valorSaque = scanner.nextInt();

        // Cédulas disponíveis definidas no edital (em ordem decrescente)
        int[] notasDisponiveis = {200, 100, 50, 20, 10, 5, 2};
        int[] quantidadePorNota = new int[notasDisponiveis.length];

        // Validação de regras de negócio: valores menores ou iguais a zero, ou 1 e 3 (impossíveis com notas de 2 e 5)
        if (valorSaque <= 0 || valorSaque == 1 || valorSaque == 3) {
            System.out.println("\nNão é possível realizar o saque deste valor com as cédulas disponíveis (R$ 200, 100, 50, 20, 10, 5, 2).");
            System.out.println("Valores mínimos possíveis: R$ 2 ou a partir de R$ 4.");
            scanner.close();
            return;
        }

        int valorRestante = valorSaque;

        // Laço de repetição com verificação de viabilidade do resto
        for (int i = 0; i < notasDisponiveis.length; i++) {
            int nota = notasDisponiveis[i];

            while (valorRestante >= nota) {
                int restoAposSubtracao = valorRestante - nota;

                // Se a retirada dessa nota deixar um resto de 1 ou 3, não podemos retirá-la,
                // pois 1 e 3 não podem ser compostos pelas cédulas menores (5 e 2).
                if (restoAposSubtracao == 1 || restoAposSubtracao == 3) {
                    break; // Interrompe para usar a próxima denominação viável
                }

                quantidadePorNota[i]++;
                valorRestante -= nota;
            }
        }

        // Exibição da saída estritamente conforme o modelo do edital
        System.out.println("\nNotas:");
        for (int i = 0; i < notasDisponiveis.length; i++) {
            if (quantidadePorNota[i] > 0) {
                System.out.println(quantidadePorNota[i] + " x R$ " + notasDisponiveis[i]);
            }
        }

        scanner.close();
    }
}
