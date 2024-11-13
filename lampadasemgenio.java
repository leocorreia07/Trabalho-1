import java.util.Scanner;

public class Lampada {

    private String marca, tipo, modelo, cor, garantia;
    private boolean ligada;

    public Lampada(String marca, String tipo, String modelo, String cor, String garantia, boolean ligada) {
        this.marca = marca;
        this.tipo = tipo;
        this.modelo = modelo;
        this.cor = cor;
        this.garantia = garantia;
        this.ligada = ligada;
    }

    public void ligar() {
        if (!ligada) {
            ligada = true;
            System.out.println("# Lâmpada Ligada #");
        }
    }

    public void desligar() {
        if (ligada) {
            ligada = false;
            System.out.println("# Lâmpada Desligada #");
        }
    }

    public void mostrarInformacoes() {
        System.out.println(">>> INÍCIO DO SOFTWARE DA LÂMPADA <<<");
        System.out.println("COR: " + cor);
        System.out.println("MARCA: " + marca);
        System.out.println("MODELO: " + modelo);
        System.out.println("TIPO: " + tipo);
        System.out.println("GARANTIA: " + garantia);
        System.out.println("STATUS: " + (ligada ? "Ligada" : "Desligada"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a cor da lâmpada:(ex: Branca, Preta) ");
        String cor = scanner.nextLine();

        System.out.print("Digite a marca da lâmpada:(ex: Philco, Phillips) ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo da lâmpada(ex: P589232): ");
        String modelo = scanner.nextLine();

        System.out.print("Digite o tipo da lâmpada (ex: Led, Incandescente): ");
        String tipo = scanner.nextLine();

        System.out.print("Digite a garantia da lâmpada (em meses): ");
        String garantia = scanner.nextLine();

        System.out.print("A lâmpada começa ligada ou desligada? (Digite 'ligada' ou 'desligada'): ");
        String status = scanner.nextLine().toLowerCase();
        
        boolean ligada = status.equals("ligada");

        Lampada lampada = new Lampada(marca, tipo, modelo, cor, garantia, ligada);

        lampada.mostrarInformacoes();

        int opcao;
        do {
            System.out.println("Ligar/Desligar lâmpada? 0 – Sair / 1 – Ligar / 2 – Desligar");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                lampada.ligar();
            } else if (opcao == 2) {
                lampada.desligar();
            } else if (opcao != 0) {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        System.out.println("*** Você encerrou o programa!. ***");
        scanner.close();
    }
}
