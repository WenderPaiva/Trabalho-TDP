import java.util.Locale;

/**
 * Exercício 4 — Sistema de Funcionários com Herança e Polimorfismo
 * Disciplina: Técnicas de Programação
 *
 * Demonstra herança com 'extends', construtor via 'super()', anotação '@Override'
 * e polimorfismo dinâmico na invocação de calcularSalario() e exibirInformacoes().
 */
public class SistemaFuncionariosPolimorfismo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("==========================================================================================");
        System.out.println("            SISTEMA DE PAGAMENTOS COM HERANÇA E POLIMORFISMO                             ");
        System.out.println("==========================================================================================");

        // Demonstração do Polimorfismo: referências do tipo superclasse (Funcionario)
        // apontando para instâncias concretas das subclasses (Gerente e Vendedor).
        Funcionario[] colaboradores = {
            new Gerente("Camila Albuquerque", 10000.00),
            new Gerente("Rodrigo Nogueira", 15000.00),
            new Vendedor("Lucas Martins", 3000.00, 25000.00),
            new Vendedor("Juliana Ferreira", 3200.00, 48000.00),
            new Funcionario("Marcos Silva (Administrativo)", 4000.00)
        };

        // Invocação 100% polimórfica: a JVM decide em tempo de execução qual método executar
        for (Funcionario f : colaboradores) {
            f.exibirInformacoes();
        }

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Polimorfismo demonstrado com sucesso: cada classe aplicou sua regra de remuneração.");
        System.out.println("==========================================================================================");
    }
}
