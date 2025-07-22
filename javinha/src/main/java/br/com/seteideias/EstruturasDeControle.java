package br.com.seteideias;

/**
 * Classe com exemplos de estruturas de controle em Java
 */
public class EstruturasDeControle {
    
    /**
     * Exemplos de estruturas if-else
     */
    public void exemploIfElse() {
        System.out.println("=== Exemplos de If-Else ===");
        
        // Exemplo 1: if simples
        int idade = 18;
        if (idade >= 18) {
            System.out.println("Exemplo 1: Pessoa é maior de idade");
        }
        
        // Exemplo 2: if-else
        double nota = 6.5;
        if (nota >= 7.0) {
            System.out.println("Exemplo 2: Aprovado");
        } else {
            System.out.println("Exemplo 2: Reprovado");
        }
        
        // Exemplo 3: if-else-if
        int hora = 14;
        if (hora < 12) {
            System.out.println("Exemplo 3: Bom dia!");
        } else if (hora < 18) {
            System.out.println("Exemplo 3: Boa tarde!");
        } else {
            System.out.println("Exemplo 3: Boa noite!");
        }
        
        // Exemplo 4: if aninhado
        boolean temAutorizacao = true;
        boolean temIdade = true;
        
        if (temIdade) {
            if (temAutorizacao) {
                System.out.println("Exemplo 4: Pode entrar no evento");
            } else {
                System.out.println("Exemplo 4: Tem idade mas não tem autorização");
            }
        } else {
            System.out.println("Exemplo 4: Não tem idade suficiente");
        }
    }
    
    /**
     * Exemplos de estruturas switch
     */
    public void exemploSwitch() {
        System.out.println("\n=== Exemplos de Switch ===");
        
        // Exemplo 1: switch com int
        int diaDaSemana = 3;
        switch (diaDaSemana) {
            case 1:
                System.out.println("Exemplo 1: Domingo");
                break;
            case 2:
                System.out.println("Exemplo 1: Segunda-feira");
                break;
            case 3:
                System.out.println("Exemplo 1: Terça-feira");
                break;
            case 4:
                System.out.println("Exemplo 1: Quarta-feira");
                break;
            case 5:
                System.out.println("Exemplo 1: Quinta-feira");
                break;
            case 6:
                System.out.println("Exemplo 1: Sexta-feira");
                break;
            case 7:
                System.out.println("Exemplo 1: Sábado");
                break;
            default:
                System.out.println("Exemplo 1: Dia inválido");
        }
        
        // Exemplo 2: switch com char
        char opcao = 'B';
        switch (opcao) {
            case 'A':
                System.out.println("Exemplo 2: Opção A selecionada");
                break;
            case 'B':
                System.out.println("Exemplo 2: Opção B selecionada");
                break;
            case 'C':
                System.out.println("Exemplo 2: Opção C selecionada");
                break;
            default:
                System.out.println("Exemplo 2: Opção inválida");
        }
        
        // Exemplo 3: switch com String (Java 7+)
        String mes = "julho";
        switch (mes.toLowerCase()) {
            case "janeiro":
                System.out.println("Exemplo 3: Mês 1");
                break;
            case "fevereiro":
                System.out.println("Exemplo 3: Mês 2");
                break;
            case "julho":
                System.out.println("Exemplo 3: Mês 7");
                break;
            case "dezembro":
                System.out.println("Exemplo 3: Mês 12");
                break;
            default:
                System.out.println("Exemplo 3: Outro mês");
        }
        
        // Exemplo 4: switch com cases agrupados
        int nota = 8;
        switch (nota) {
            case 10:
            case 9:
                System.out.println("Exemplo 4: Conceito A");
                break;
            case 8:
            case 7:
                System.out.println("Exemplo 4: Conceito B");
                break;
            case 6:
            case 5:
                System.out.println("Exemplo 4: Conceito C");
                break;
            default:
                System.out.println("Exemplo 4: Conceito D");
        }
    }
    
    /**
     * Exemplos de estruturas de loop (for, while, do-while)
     */
    public void exemploLoops() {
        System.out.println("\n=== Exemplos de Loops ===");
        
        // Exemplo 1: loop for básico
        System.out.println("Exemplo 1 (for básico):");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Contador: " + i);
        }
        
        // Exemplo 2: loop for com decremento
        System.out.println("\nExemplo 2 (for com decremento):");
        for (int i = 10; i > 0; i--) {
            System.out.println("Contagem regressiva: " + i);
        }
        
        // Exemplo 3: loop for-each (enhanced for)
        System.out.println("\nExemplo 3 (for-each):");
        String[] frutas = {"Maçã", "Banana", "Laranja", "Uva", "Pera"};
        for (String fruta : frutas) {
            System.out.println("Fruta: " + fruta);
        }
        
        // Exemplo 4: loop while
        System.out.println("\nExemplo 4 (while):");
        int contador = 1;
        while (contador <= 5) {
            System.out.println("While contador: " + contador);
            contador++;
        }
        
        // Exemplo 5: loop do-while
        System.out.println("\nExemplo 5 (do-while):");
        int numero = 1;
        do {
            System.out.println("Do-while número: " + numero);
            numero++;
        } while (numero <= 5);
        
        // Exemplo 6: loop com break
        System.out.println("\nExemplo 6 (loop com break):");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                System.out.println("Encontrou o número 6, saindo do loop...");
                break;
            }
            System.out.println("Número: " + i);
        }
        
        // Exemplo 7: loop com continue
        System.out.println("\nExemplo 7 (loop com continue):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                // Pula os números pares
                continue;
            }
            System.out.println("Número ímpar: " + i);
        }
        
        // Exemplo 8: loops aninhados
        System.out.println("\nExemplo 8 (loops aninhados):");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.println("i = " + i + ", j = " + j);
            }
        }
    }
    
    /**
     * Método principal para demonstrar o uso das estruturas de controle
     */
    public static void main(String[] args) {
        var exemplos = new EstruturasDeControle();
        
        // Executando exemplos de if-else
        exemplos.exemploIfElse();
        
        // Executando exemplos de switch
        exemplos.exemploSwitch();
        
        // Executando exemplos de loops
        exemplos.exemploLoops();
    }
}
