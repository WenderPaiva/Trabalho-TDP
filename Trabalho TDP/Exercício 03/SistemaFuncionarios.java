import java.util.Locale;

/**
 * Exercício 3 — Sistema de Funcionários (Classe Executável)
 * Disciplina: Técnicas de Programação
 *
 * Demonstra a instanciação de múltiplos objetos, manipulação de estado
 * via métodos de negócio e exibição comparativa antes e depois dos aumentos.
 */
public class SistemaFuncionarios {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("==========================================================================================");
        System.out.println("                   SISTEMA DE GESTÃO DE FUNCIONÁRIOS (POO BÁSICA)                        ");
        System.out.println("==========================================================================================");

        // 1. Instanciação de 5 funcionários com dados distintos
        Funcionario[] funcionarios = {
            new Funcionario("Carlos Silva", "Desenvolvedor Júnior", 3500.00),
            new Funcionario("Ana Souza", "Analista de QA", 4200.00),
            new Funcionario("Bruno Oliveira", "Desenvolvedor Pleno", 6000.00),
            new Funcionario("Mariana Santos", "Arquiteta de Software", 9500.00),
            new Funcionario("Roberto Lima", "Gerente de Projetos", 8000.00)
        };

        // Percentuais de aumento distintos para cada funcionário
        double[] percentuaisAumento = {10.0, 12.0, 8.0, 15.0, 5.0};

        // 2. Exibição dos dados ANTES do aumento
        System.out.println("\n--- RELAÇÃO DE FUNCIONÁRIOS (ANTES DO REAJUSTE) ---");
        for (Funcionario f : funcionarios) {
            f.exibirDados();
        }

        // 3. Aplicação dos aumentos individualizados
        System.out.println("\n--- APLICANDO REAJUSTES SALARIAIS ---");
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.printf("Aplicando aumento de %4.1f%% para %s...%n",
                    percentuaisAumento[i], funcionarios[i].getNome());
            funcionarios[i].aumentarSalario(percentuaisAumento[i]);
        }

        // 4. Exibição dos dados APÓS o aumento
        System.out.println("\n--- RELAÇÃO DE FUNCIONÁRIOS (APÓS O REAJUSTE) ---");
        for (Funcionario f : funcionarios) {
            f.exibirDados();
        }
        System.out.println("==========================================================================================");
    }
}
