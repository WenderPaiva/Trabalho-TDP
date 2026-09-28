# 📚 Técnicas de Programação — Guia Acadêmico e Roteiro de Apresentação

> **Disciplina:** Técnicas de Programação  
> **Linguagem:** Java (Standard Edition — sem dependências externas)  
> **Finalidade:** Conjunto de 5 exercícios acadêmicos completos, blindados contra falhas de entrada e roteiro prático para defesa presencial perante o professor.

---

## 🎯 1. Visão Geral do Projeto

Este repositório contém a implementação completa, limpa, funcional e robustecida de 5 exercícios que consolidam a progressão pedagógica da disciplina: partindo de **lógica de programação algorítmica** (estruturas de controle, repetição e arrays) até os pilares centrais da **Programação Orientada a Objetos (POO)**: abstração, encapsulamento, herança e polimorfismo.

### 🛡️ Tratamento Inteligente de Limitações e Casos de Borda
1. **Caixa Eletrônico Inteligente:** O algoritmo tradicional falharia em valores como R$ 6, R$ 11 ou R$ 13 (por tentar retirar R$ 5 ou R$ 10 e deixar sobra 1 ou 3, sem notas para cobrir). Implementamos uma verificação preventiva do resto da divisão, garantindo que qualquer valor válido a partir de R$ 2 seja atendido na combinação exata de cédulas.
2. **Entrada Decimal Flexível:** O leitor de vendas aceita tanto ponto quanto vírgula (ex: `1500.50` ou `1500,50`), eliminando erros de `InputMismatchException` no console.
3. **Divisão por Zero Protegida:** A quantidade de vendas é validada para garantir que seja positiva, evitando médias `NaN`.
4. **Operações Bancárias Seguras:** Métodos de saque e depósito impedem valores negativos e validam se há saldo suficiente para o saque.
5. **POO e Polimorfismo Dinâmico:** Uso de herança, sobrescrita com `@Override` e chamadas 100% polimórficas sem necessidade de downcasts manuais nos laços.

---

## 📂 Estrutura de Arquivos do Projeto

```text
exercicios-tecnicas-programacao/
│
├── exercicio1/
│   └── CaixaEletronico.java
│
├── exercicio2/
│   └── SistemaVendas.java
│
├── exercicio3/
│   ├── Funcionario.java
│   └── SistemaFuncionarios.java
│
├── exercicio4/
│   ├── Funcionario.java
│   ├── Gerente.java
│   ├── Vendedor.java
│   └── SistemaFuncionariosPolimorfismo.java
│
├── exercicio5/
│   ├── Conta.java
│   ├── ContaCorrente.java
│   ├── ContaPoupanca.java
│   └── SistemaContasBancarias.java
│
└── README.md
```

---

## 🚀 Como Compilar e Executar os Exercícios

Abra o terminal (Prompt de Comando, PowerShell ou Terminal do Linux/macOS), navegue até a pasta de cada exercício e execute os comandos correspondentes:

### Exercício 1 — Caixa Eletrônico
```bash
cd exercicio1
javac CaixaEletronico.java
java CaixaEletronico
```

### Exercício 2 — Sistema de Vendas
```bash
cd exercicio2
javac SistemaVendas.java
java SistemaVendas
```

### Exercício 3 — Sistema de Funcionários (POO Básica)
```bash
cd exercicio3
javac *.java
java SistemaFuncionarios
```

### Exercício 4 — Funcionários com Herança e Polimorfismo
```bash
cd exercicio4
javac *.java
java SistemaFuncionariosPolimorfismo
```

### Exercício 5 — Sistema de Contas Bancárias
```bash
cd exercicio5
javac *.java
java SistemaContasBancarias
```

---

## 🎤 Guia de Demonstração e Apresentação (Exercício por Exercício)

Este roteiro foi estruturado para que a dupla divida a fala de forma coordenada, demonstrando segurança conceitual e domínio prático do código.

---

### 💵 Exercício 1 — Caixa Eletrônico

#### 1. Objetivo do Exercício
Receber um valor inteiro de saque e calcular a quantidade mínima de cédulas para compor esse valor, utilizando as notas oficiais: R$ 200, R$ 100, R$ 50, R$ 20, R$ 10, R$ 5 e R$ 2.

#### 2. O Diferencial Técnico da Solução
* Valores como R$ 1 e R$ 3 são impossíveis com as cédulas existentes e são rejeitados com mensagem amigável.
* Valores como R$ 6, R$ 11, R$ 13 ou R$ 21 poderiam travar um algoritmo simples. Nossa implementação prevê que qualquer retirada que resulte em sobra `1` ou `3` deve ser evitada, passando automaticamente para a denominação que fecha a conta com cédulas de 2.

#### 3. Trechos-Chave do Código
```java
int[] notasDisponiveis = {200, 100, 50, 20, 10, 5, 2};
int[] quantidadePorNota = new int[notasDisponiveis.length];

for (int i = 0; i < notasDisponiveis.length; i++) {
    int nota = notasDisponiveis[i];

    while (valorRestante >= nota) {
        int resto = valorRestante - nota;

        // Se retirar esta nota deixar resto 1 ou 3, não podemos retirá-la
        if (resto == 1 || resto == 3) {
            break; // Salta para a próxima cédula viável
        }

        quantidadePorNota[i]++;
        valorRestante -= nota;
    }
}
```

#### 4. Roteiro de Fala ("O que falar na hora")
> *"Professor, neste primeiro exercício, fomos além do algoritmo ingênuo. Sabendo que não existem notas de R$ 1 e R$ 3, implementamos uma lógica de antecipação: se a retirada de uma nota maior for deixar um saldo restante de 1 ou 3 reais, o laço interrompe a retirada dessa nota e recorre à próxima cédula menor. Dessa forma, valores desafiadores como R$ 6 ou R$ 11 são resolvidos perfeitamente com a menor quantidade de notas possível."*

#### 5. Perguntas Típicas do Professor & Respostas
* **Pergunta 1:** *"O que acontece se o usuário tentar sacar R$ 1, R$ 3 ou um número negativo?"*  
  * **Resposta Ideal:** *"O programa valida previamente esses valores e informa ao usuário que não é possível realizar o saque com as notas disponíveis (a menor quantia viável é R$ 2, e quantias ímpares a partir de R$ 5)."*
* **Pergunta 2:** *"Como o programa garante que a saída mostra apenas as notas utilizadas?"*  
  * **Resposta Ideal:** *"No laço final de exibição, a condicional `if (quantidadePorNota[i] > 0)` filtra e imprime apenas as posições do array cujo contador seja estritamente superior a zero."*

---

### 📊 Exercício 2 — Sistema de Vendas

#### 1. Objetivo do Exercício
Ler a quantidade de vendas de um dia e o valor de cada uma. Computar em tempo de execução o total vendido, a maior e a menor venda, a média, o número de vendas acima de R$ 500,00 e o percentual e valor de comissão por faixas.

#### 2. Melhorias de Robustez
* Valida se a quantidade de vendas é `>= 1`.
* Aceita ponto e vírgula na digitação decimal via `replace(",", ".")`.
* Rejeita valores de venda negativos sem encerrar o programa (pede para redigitar a venda atual).

#### 3. Trechos-Chave do Código
```java
// Leitura flexível para vírgula ou ponto
String entrada = scanner.next().replace(",", ".");
double valorVenda = Double.parseDouble(entrada);

// Cálculo das faixas de comissão
double percentualComissao;
if (totalVendido <= 1000.00) {
    percentualComissao = 0.03; // 3%
} else if (totalVendido <= 5000.00) {
    percentualComissao = 0.05; // 5%
} else {
    percentualComissao = 0.08; // 8%
}
double valorComissao = totalVendido * percentualComissao;
```

#### 4. Roteiro de Fala ("O que falar na hora")
> *"Professor, no exercício 2 construímos o relatório diário de vendas. Tratamos a leitura para aceitar tanto vírgula quanto ponto decimal. Na primeira venda inicializamos os limites de maior e menor venda, e nas subsequentes acumulamos o total e atualizamos as métricas. Ao final, a comissão é calculada de acordo com as faixas de faturamento: 3% até mil reais, 5% até cinco mil, e 8% para valores superiores."*

---

### 👥 Exercício 3 — Sistema de Funcionários (POO Básica)

#### 1. Objetivo do Exercício
Demonstrar a aplicação de encapsulamento com atributos privados (`nome`, `cargo`, `salario`), métodos de negócio para reajuste salarial e cálculo de salário anual, instanciando 5 funcionários e exibindo seus dados antes e depois do aumento.

#### 2. Trechos-Chave do Código
```java
public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public void aumentarSalario(double percentual) {
        if (percentual > 0) {
            this.salario += this.salario * (percentual / 100.0);
        }
    }

    public double calcularSalarioAnual() {
        return this.salario * 12;
    }
}
```

---

### 🧬 Exercício 4 — Funcionários com Herança e Polimorfismo

#### 1. Objetivo do Exercício
Modelar uma hierarquia com herança (`extends`) e polimorfismo dinâmico. A classe base `Funcionario` possui `calcularSalario()` e `exibirInformacoes()`. As subclasses `Gerente` (+20% de bônus) e `Vendedor` (+10% de comissão sobre vendas) sobrescrevem esses métodos.

#### 2. Trechos-Chave do Código
```java
// No main: Laço 100% polimórfico
Funcionario[] colaboradores = {
    new Gerente("Camila Albuquerque", 10000.00),
    new Vendedor("Lucas Martins", 3000.00, 25000.00)
};

for (Funcionario f : colaboradores) {
    // A JVM resolve dinamicamente em tempo de execução o método da classe concreta
    f.exibirInformacoes();
}
```

---

### 🏦 Exercício 5 — Sistema de Contas Bancárias

#### 1. Objetivo do Exercício
Executar rigorosamente as 6 etapas exigidas pelo edital:
1. Criar contas correntes;
2. Criar contas poupança;
3. Realizar depósitos;
4. Realizar saques;
5. Calcular o saldo de cada conta (demonstrando polimorfismo);
6. Exibir os dados finais das contas.

#### 2. Trechos-Chave do Código
```java
// ContaCorrente deduz taxa
@Override
public double calcularSaldo() {
    return getSaldo() - this.taxaManutencao;
}

// ContaPoupanca adiciona rendimento
@Override
public double calcularSaldo() {
    return getSaldo() + (getSaldo() * this.percentualRendimento);
}
```
