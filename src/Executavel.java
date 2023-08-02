import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
    static Jogador j1,j2;
    public static void main(String[] args) {
        menuInicial();
    }

    private static boolean validarVitoria(Jogador adversario) {
        for ( Peca peca : adversario.getPecas() ) {
            if(peca instanceof Rei) {
                return false;
            }
        }
        return true;
    }

    public static void menuInicial() {
        int opcao;
        do {
            System.out.println("""
                    1- Nova Conta
                    2- Jogar
                    3- Visualizar Contas
                    """);
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o seu nome: ");
                    String nome = sc.next();
                    System.out.println("Digite a sua senha: ");
                    String senha = sc.next();
                    Jogador jogadorNovo = new Jogador(nome, senha);
                    listaJogadores.add(jogadorNovo);
                    System.out.println(listaJogadores);
                    break;
                case 2:
                    jogar();
                    break;
                case 3:
                    System.out.println(listaJogadores);
            }
        } while (opcao != 2 || opcao != 3);
    }

    public static void jogar() {
        if(loginJogador()) {
            Tabuleiro tabuleiroPecas = new Tabuleiro();
            /* ArrayList<String> tabuleiroDesign = criarTabuleiro();
            tabuleiroDesignPecas();
            exibirTabuleiro(tabuleiroDesign);
            */
            j1.setCor("Branco", tabuleiroPecas);
            j2.setCor("Preto", tabuleiroPecas);

            System.out.println(tabuleiroPecas);

            // Escolha da peça jogador 1
            System.out.println("Escolha da peça jogador 1: ");
            System.out.println(j1.getPecas());
            int escolhaPeca = sc.nextInt();
            Peca peca = j1.getPecas().get(escolhaPeca);
            System.out.println(peca);

            // Escolha da posição para o movimento
            System.out.println(peca.possiveisMovimentos(tabuleiroPecas));
            ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiroPecas);
            System.out.println(posicoes);
            int escolhaPosicao = sc.nextInt();
            Posicao posicao = posicoes.get(escolhaPosicao);
            // Movimentação da peça escohida para a posição desejada
            j1.moverPeca(peca, posicao, tabuleiroPecas, j2);
            System.out.println(validarVitoria(j2));
        } else {
            System.out.println("O login falhou");
        }
    }

    public static boolean loginJogador() {
        int cont = 0;
        boolean verifica = true;
       do {
           System.out.println("Selecione o jogador 1 : ");
           for (Jogador jogadorFor : listaJogadores) {
               System.out.println(cont + " " + jogadorFor.getNome());
               cont ++;
           }
           int escolha = sc.nextInt();
           j1 = listaJogadores.get(escolha);
           System.out.println(j1.getNome());
           System.out.println("Digite a senha do usuário escolhido: ");
           String senha = sc.next();
           if (verificaSenha(j1, senha)) {
               System.out.println("Jogador 1 logado com sucesso!");
           } else {
               System.out.println("Senha incorreta!");
               verifica = false;
           }

           System.out.println("Selecione o jogador 2 : ");
           cont = 0;
           for (Jogador jogadorFor : listaJogadores) {
               System.out.println(cont + " " + jogadorFor.getNome());
               cont++;
           }
           int escolha2 = sc.nextInt();
           j2 = listaJogadores.get(escolha);
           System.out.println("Digite a senha do usuário escolhido: ");
           String senha2 = sc.next();
           if(verificaSenha(j2, senha2)) {
               System.out.println("Jogador 2 logado com sucesso!");
               return true;
           } else {
               System.out.println("Senha incorreta!");
               verifica = false;
               return false;
           }
       } while(verifica);
    }

    public static boolean verificaSenha(Jogador jogador ,String senha) {
        for (Jogador jogadorFor: listaJogadores) {
            if (jogador.getSenha().equals(jogadorFor.getSenha())) {
                    return true;
            }
        }
        return false;
    }

    public static ArrayList<String> criarTabuleiro() {
        ArrayList<String> tabuleiro = new ArrayList<>();
        int tamanho = 8; // Tamanho do tabuleiro (8x8)

        for (int linha = 0; linha < tamanho; linha++) {
            for (int coluna = 0; coluna < tamanho; coluna++) {
                if ((linha + coluna) % 2 == 0) {
                    tabuleiro.add("|   "); // Casas pretas são representadas por "|-"
                } else {
                    tabuleiro.add("|   "); // Casas brancas são representadas por "| "
                }
            }
            tabuleiro.add("|"); // Coluna final
            tabuleiro.add("\n"); // Nova linha
            for (int coluna = 0; coluna < tamanho; coluna++) {
                tabuleiro.add("----"); // Representação das divisões horizontais
            }
            tabuleiro.add("-"); // Fim da linha (borda do tabuleiro)
            tabuleiro.add("\n"); // Nova linha
        }

        return tabuleiro;
    }

    public static void tabuleiroDesignPecas() {

    }

    public static void exibirTabuleiro(ArrayList<String> tabuleiro) {
        for (String tabu : tabuleiro) {
            System.out.print(tabu);
        }
    }
}



