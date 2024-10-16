import java.util.Scanner;

public class BarBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double precoIngressoHomem = 10.0;
        double precoIngressoMulher = 8.0;
        double precoCerveja = 5.0;
        double precoRefrigerante = 3.0;
        double precoEspetinho = 7.0;
        double couvertArtistico = 4.0;

        System.out.print("Digite o sexo (M para masculino, F para feminino): ");
        char sexo = scanner.next().toUpperCase().charAt(0);

        System.out.print("Digite a quantidade de cervejas consumidas: ");
        int qtdCervejas = scanner.nextInt();

        System.out.print("Digite a quantidade de refrigerantes consumidos: ");
        int qtdRefrigerantes = scanner.nextInt();

        System.out.print("Digite a quantidade de espetinhos consumidos: ");
        int qtdEspetinhos = scanner.nextInt();

        scanner.close();


        double valorIngresso = (sexo == 'M') ? precoIngressoHomem : precoIngressoMulher;

        double totalConsumo = (qtdCervejas * precoCerveja) + (qtdRefrigerantes * precoRefrigerante) + (qtdEspetinhos * precoEspetinho);

        double valorCouvert = (totalConsumo > 30) ? 0.0 : couvertArtistico;

        double totalPagar = valorIngresso + totalConsumo + valorCouvert;

        System.out.println("\n--- Relatório da Conta ---");
        System.out.printf("Valor do ingresso: R$ %.2f%n", valorIngresso);
        System.out.printf("Total consumido: R$ %.2f%n", totalConsumo);
        System.out.printf("Couvert artístico: R$ %.2f%n", valorCouvert);
        System.out.printf("Valor total a pagar: R$ %.2f%n", totalPagar);
    }
}
