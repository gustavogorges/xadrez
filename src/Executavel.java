import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Jogador> listaJogadores;
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
            case 2:
                jogar();
            case 3:
                System.out.println(listaJogadores);
        }
    }

    public static void jogar() {
        if(loginJogador()) {
            Tabuleiro tabuleiro = new Tabuleiro();
            j1.setCor("Branco", tabuleiro);
            j2.setCor("Preto", tabuleiro);
            // Escolha da peça
            System.out.println(j1.getPecas());
            int escolhaPeca = sc.nextInt();
            Peca peca = j1.getPecas().get(escolhaPeca);
            System.out.println(peca);

            // Escolha da posição para o movimento
            System.out.println(peca.possiveisMovimentos(tabuleiro));
            ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);
            System.out.println(posicoes);
            int escolhaPosicao = sc.nextInt();
            Posicao posicao = posicoes.get(escolhaPosicao);
            // Movimentação da peça escohida para a posição desejada
            j1.moverPeca(peca, posicao, tabuleiro, j2);
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
           }
           int escolha = sc.nextInt();
           j1 = listaJogadores.get(escolha - 1);
           System.out.println("Digite a senha do usuário escolhido: ");
           String senha = sc.next();
           if (verificaSenha(j1, senha)) {
               System.out.println("Jogador 1 logado com sucesso!");
           } else {
               System.out.println("Senha incorreta!");
               verifica = false;
           }

           System.out.println("Selecione o jogador 2 : ");
           for (Jogador jogadorFor : listaJogadores) {
               System.out.println(cont + " " + jogadorFor.getNome());
           }
           int escolha2 = sc.nextInt();
           j2 = listaJogadores.get(escolha - 1);
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
                if (jogador.getNome().equals(senha)) {
                    return true;
                }
            }
        }
        return false;
    }


}
