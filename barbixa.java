import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o seu salário anual: ");
        double salarioAnual = sc.nextDouble();

        System.out.println("Digite a renda anual de prestação de serviços: ");
        double servicoAnual = sc.nextDouble();

        System.out.println("Digite o ganho de capital anual (imóveis, ações, etc.): ");
        double ganhoCapitalAnual = sc.nextDouble();

        System.out.println("Digite os gastos médicos anuais: ");
        double gastosMedicos = sc.nextDouble();

        System.out.println("Digite os gastos educacionais anuais: ");
        double gastosEducacionais = sc.nextDouble();

        sc.close();

        double impostoSalario = calcularImpostoSalario(salarioAnual);
        double impostoServico = calcularImpostoServico(servicoAnual);
        double impostoGanhoCapital = calcularImpostoGanhoCapital(ganhoCapitalAnual);


        double impostoBruto = impostoSalario + impostoServico + impostoGanhoCapital;

        double impostoFinal = aplicarDeducoes(impostoBruto, gastosMedicos, gastosEducacionais);

        System.out.printf("Imposto sobre Salário: R$ %.2f\n", impostoSalario);
        System.out.printf("Imposto sobre Serviços: R$ %.2f\n", impostoServico);
        System.out.printf("Imposto sobre Ganho de Capital: R$ %.2f\n", impostoGanhoCapital);
        System.out.printf("Imposto Bruto Total: R$ %.2f\n", impostoBruto);
        System.out.printf("Imposto Final (após deduções): R$ %.2f\n", impostoFinal);
    }


    public static double calcularImpostoSalario(double salarioAnual) {
        double salarioMensal = salarioAnual / 12;
        if (salarioMensal < 3000) {
            return 0;
        } else if (salarioMensal < 5000) {
            return salarioAnual * 0.10;
        } else {
            return salarioAnual * 0.20;
        }
    }


    public static double calcularImpostoServico(double servicoAnual) {
        return servicoAnual * 0.15;
    }

    public static double calcularImpostoGanhoCapital(double ganhoCapitalAnual) {
        return ganhoCapitalAnual * 0.20;
    }


    public static double aplicarDeducoes(double impostoBruto, double gastosMedicos, double gastosEducacionais) {
        double gastosTotais = gastosMedicos + gastosEducacionais;
        double limiteDeducao = impostoBruto * 0.30;

        if (gastosTotais >= limiteDeducao) {
            return impostoBruto - limiteDeducao;
        } else {
            return impostoBruto - gastosTotais;
        }
    }
}
