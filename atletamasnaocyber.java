import java.util.Scanner;

public class RelatorioAtletas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual a quantidade de atletas? (N > 0): ");
        int N = scanner.nextInt();
        scanner.nextLine(); 

        double totalPeso = 0;
        double maiorAltura = 0;
        String atletaMaisAlto = "";
        int contHomens = 0;
        int contMulheres = 0;
        double alturaTotalMulheres = 0;

        for (int i = 1; i <= N; i++) {
            System.out.println("\nDigite os dados do atleta número " + i + ":");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            String sexo;
            while (true) {
                System.out.print("Sexo (M para Masculino, F para Feminino): ");
                sexo = scanner.nextLine().toUpperCase();
                if (sexo.equals("M") || sexo.equals("F")) {
                    break;
                } else {
                    System.out.println("Valor inválido! Digite M para Masculino ou F para Feminino.");
                }
            }

            double altura;
            while (true) {
                System.out.print("Altura (exemplo: 1.75): ");
                altura = scanner.nextDouble();
                if (altura > 0) {
                    break;
                } else {
                    System.out.println("Valor inválido! A altura deve ser maior que zero.");
                }
            }

            double peso;
            while (true) {
                System.out.print("Peso (exemplo: 70.5): ");
                peso = scanner.nextDouble();
                if (peso > 0) {
                    break;
                } else {
                    System.out.println("Valor inválido! O peso deve ser maior que zero.");
                }
            }

            scanner.nextLine(); 

            totalPeso += peso;

            if (sexo.equals("M")) {
                contHomens++;
            } else {
                contMulheres++;
                alturaTotalMulheres += altura;
            }

            if (altura > maiorAltura) {
                maiorAltura = altura;
                atletaMaisAlto = nome;
            }
        }

        double pesoMedio = totalPeso / N;
        double porcentagemHomens = (contHomens * 100.0) / N;

        System.out.println("\n### RELATÓRIO ###");
        System.out.printf("Peso médio dos atletas: %.2f\n", pesoMedio);
        System.out.println("Atleta mais alto: " + atletaMaisAlto);
        System.out.printf("Porcentagem de homens: %.1f %%\n", porcentagemHomens);

        if (contMulheres > 0) {
            double alturaMediaMulheres = alturaTotalMulheres / contMulheres;
            System.out.printf("Altura média das mulheres: %.2f\n", alturaMediaMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas");
        }

        scanner.close();
    }
}
