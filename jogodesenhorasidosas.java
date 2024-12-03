import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] tabuleiro = new char[3][3];
        inicializarTabuleiro(tabuleiro);
        
        boolean jogoEmAndamento = true;
        char jogadorAtual = 'X';
        
        while (jogoEmAndamento) {
            exibirTabuleiro(tabuleiro);
            System.out.println("Jogador " + jogadorAtual + ", faça sua jogada.");
            int linha, coluna;
            
            while (true) {
                System.out.print("Digite a linha (1, 2, 3): ");
                linha = scanner.nextInt() - 1;
                System.out.print("Digite a coluna (1, 2, 3): ");
                coluna = scanner.nextInt() - 1;
                scanner.nextLine();

                if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                    break;
                } else {
                    System.out.println("Coordenada inválida! Tente novamente. Lembre-se que as coordenadas vão de 1 a 3, e que não pode nenhum X ou O pode sobrescrever o outro.");
                }
            }
            
            tabuleiro[linha][coluna] = jogadorAtual;
            
            if (verificarVencedor(tabuleiro, jogadorAtual)) {
                exibirTabuleiro(tabuleiro);
                System.out.println("Jogador " + jogadorAtual + " venceu!, mais sorte na proxima vez");
                jogoEmAndamento = false;
            } else if (empate(tabuleiro)) {
                exibirTabuleiro(tabuleiro);
                System.out.println("Empate! O jogo acabou sem vencedor.");
                jogoEmAndamento = false;
            } else {
                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
            }
        }
        
        scanner.close();
    }
    
    public static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }
    
    public static void exibirTabuleiro(char[][] tabuleiro) {
        System.out.println("\nTabuleiro:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tabuleiro[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("---|---|---");
        }
    }
    
    public static boolean verificarVencedor(char[][] tabuleiro, char jogador) {
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) || 
                (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }
        
        if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) || 
            (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) {
            return true;
        }
        
        return false;
    }
    
    public static boolean empate(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
